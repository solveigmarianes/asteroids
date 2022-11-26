package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;
import java.util.List;
import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsteroidResultDto {
    private LinksDto links;
    private int elementCount;
    private Map<Date, List<AsteroidDto>> nearEarthObjects;

    public AsteroidResultDto(LinksDto links, int elementCount, Map<Date, List<AsteroidDto>> nearEarthObjects) {
        this.links = links;
        this.elementCount = elementCount;
        this.nearEarthObjects = nearEarthObjects;
    }

    public LinksDto getLinks() {
        return links;
    }

    public void setLinks(LinksDto links) {
        this.links = links;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public Map<Date, List<AsteroidDto>> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(Map<Date, List<AsteroidDto>> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }
}
