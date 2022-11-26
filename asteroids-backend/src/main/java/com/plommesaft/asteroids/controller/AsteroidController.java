package com.plommesaft.asteroids.controller;

import com.plommesaft.asteroids.data.AsteroidCollectionDto;
import com.plommesaft.asteroids.data.AsteroidDto;
import com.plommesaft.asteroids.service.NasaAsteroidsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RequestMapping(path = "api/asteroids")
@RestController
public class AsteroidController {
    private final NasaAsteroidsClientService asteroidsClientService;

    @Autowired
    public AsteroidController(NasaAsteroidsClientService asteroidsClientService) {
        this.asteroidsClientService = asteroidsClientService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<AsteroidDto> getAsteroidById(@PathVariable BigInteger id) {
        return asteroidsClientService.fetchAsteroidById(id);
    }

    @GetMapping
    public ResponseEntity<AsteroidCollectionDto> getAsteroidsForDates(
            @RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate", required = false) String endDate) {
        System.out.println("Start date: " + startDate + ", End date: " + endDate);
        return asteroidsClientService.fetchNearEarthObjects(startDate, Optional.ofNullable(endDate));
    }
}
