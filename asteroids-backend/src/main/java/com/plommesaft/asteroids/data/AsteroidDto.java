package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsteroidDto {
    private LinksDto links;
    private BigInteger id;
    private BigInteger neoReferenceId;
    private String name;
    private String designation;
    private URI nasaJplUrl;
    private BigDecimal absoluteMagnitudeH;
    private SizeDto estimatedDiameter;
    private boolean isPotentiallyHazardousAsteroid;
    private List<CloseApproachDto> closeApproachData;
    //TODO private OrbitalDataDto orbitalData;
    private boolean isSentryObject;

    public AsteroidDto(LinksDto links, BigInteger id, BigInteger neoReferenceId, String name, URI nasaJplUrl, SizeDto estimatedDiameter, boolean isPotentiallyHazardousAsteroid, List<CloseApproachDto> closeApproachData, boolean isSentryObject) {
        this.links = links;
        this.id = id;
        this.neoReferenceId = neoReferenceId;
        this.name = name;
        this.nasaJplUrl = nasaJplUrl;
        this.estimatedDiameter = estimatedDiameter;
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
        this.closeApproachData = closeApproachData;
        this.isSentryObject = isSentryObject;
    }

    public LinksDto getLinks() {
        return links;
    }

    public void setLinks(LinksDto links) {
        this.links = links;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(BigInteger neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(URI nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public SizeDto getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(SizeDto estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setPotentiallyHazardousAsteroid(boolean potentiallyHazardousAsteroid) {
        isPotentiallyHazardousAsteroid = potentiallyHazardousAsteroid;
    }

    public List<CloseApproachDto> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproachDto> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    public boolean isSentryObject() {
        return isSentryObject;
    }

    public void setSentryObject(boolean sentryObject) {
        isSentryObject = sentryObject;
    }
}
