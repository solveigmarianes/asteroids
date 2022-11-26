package com.plommesaft.asteroids.service;

import com.plommesaft.asteroids.config.AsteroidClientProperties;
import com.plommesaft.asteroids.data.AsteroidCollectionDto;
import com.plommesaft.asteroids.data.AsteroidDto;
import com.plommesaft.asteroids.data.AsteroidResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.util.*;

@Service
public class NasaAsteroidsClientService {

    private final RestTemplate restTemplate;
    private final AsteroidClientProperties asteroidClientProperties;

    @Autowired
    public NasaAsteroidsClientService(RestTemplate restTemplate, AsteroidClientProperties asteroidClientProperties) {
        this.restTemplate = restTemplate;
        this.asteroidClientProperties = asteroidClientProperties;
    }

    @Cacheable(value = "asteroids")
    public ResponseEntity<AsteroidDto> fetchAsteroidById(BigInteger id) {
        URI uri = UriComponentsBuilder.fromUriString(asteroidClientProperties.getBasePath())
                .pathSegment("neo")
                .pathSegment(id.toString())
                .queryParam("api_key", asteroidClientProperties.getApiKey())
                .build().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, null, AsteroidDto.class);
    }

    // TODO Improve caching. One entry per date
    @Cacheable(value = "nearEarthObjects", key = "#startDate")
    public ResponseEntity<AsteroidCollectionDto> fetchNearEarthObjects(String startDate, Optional<String> endDate) {
        URI uri = UriComponentsBuilder.fromUriString(asteroidClientProperties.getBasePath())
                .pathSegment("feed")
                .queryParam("start_date", startDate)
                .queryParamIfPresent("end_date", endDate)
                .queryParam("api_key", asteroidClientProperties.getApiKey())
                .build().toUri();
        ResponseEntity<AsteroidResultDto> result = restTemplate.exchange(uri, HttpMethod.GET, null, AsteroidResultDto.class);

        if (result.getBody() != null) {
            AsteroidCollectionDto.Builder builder = AsteroidCollectionDto.builder()
                    .links(result.getBody().getLinks())
                    .elementCount(result.getBody().getElementCount());

            if (result.getBody().getNearEarthObjects() != null) {
                List<AsteroidDto> sortedAsteroids = getSortedAsteroids(result.getBody().getNearEarthObjects());
                builder.nearEarthObjects(sortedAsteroids);
            }

            return ResponseEntity.ok(builder.build());
        } else return new ResponseEntity<>(result.getStatusCode());
    }

    private static List<AsteroidDto> getSortedAsteroids(Map<Date, List<AsteroidDto>> nearEarthObjects) {
        return nearEarthObjects.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(asteroid -> asteroid
                        .getCloseApproachData()
                        .get(0)
                        .getMissDistance()
                        .getAstronomical()))
                .toList();
    }
}
