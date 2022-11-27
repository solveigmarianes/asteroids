package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
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

    public AsteroidDto(@JsonProperty("links") LinksDto links,
                       @JsonProperty("id") BigInteger id,
                       @JsonProperty("neo_reference_id") BigInteger neoReferenceId,
                       @JsonProperty("name") String name,
                       @JsonProperty("designation") String designation,
                       @JsonProperty("nasa_jpl_url") URI nasaJplUrl,
                       @JsonProperty("absolute_magnitude_h") BigDecimal absoluteMagnitudeH,
                       @JsonProperty("estimated_diameter") SizeDto estimatedDiameter,
                       @JsonProperty(value = "is_potentially_hazardous_asteroid") boolean isPotentiallyHazardousAsteroid,
                       @JsonProperty("close_approach_data") List<CloseApproachDto> closeApproachData,
                       @JsonProperty(value = "is_sentry_object") boolean isSentryObject) {
        this.links = links;
        this.id = id;
        this.neoReferenceId = neoReferenceId;
        this.name = name;
        this.designation = designation;
        this.nasaJplUrl = nasaJplUrl;
        this.absoluteMagnitudeH = absoluteMagnitudeH;
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

    public boolean getIsPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setIsPotentiallyHazardousAsteroid(boolean potentiallyHazardousAsteroid) {
        this.isPotentiallyHazardousAsteroid = potentiallyHazardousAsteroid;
    }

    public List<CloseApproachDto> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproachDto> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    public boolean getIsSentryObject() {
        return isSentryObject;
    }

    public void setIsSentryObject(boolean sentryObject) {
        isSentryObject = sentryObject;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(BigDecimal absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }
}
