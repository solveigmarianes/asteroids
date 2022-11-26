package com.plommesaft.asteroids.data;

import java.util.List;

public class AsteroidCollectionDto {
    private LinksDto links;
    private Integer elementCount;
    private List<AsteroidDto> nearEarthObjects;

    public AsteroidCollectionDto(LinksDto links, int elementCount, List<AsteroidDto> nearEarthObjects) {
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

    public Integer getElementCount() {
        return elementCount;
    }

    public void setElementCount(Integer elementCount) {
        this.elementCount = elementCount;
    }

    public List<AsteroidDto> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(List<AsteroidDto> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private LinksDto links;
        private Integer elementCount;
        private List<AsteroidDto> nearEarthObjects;

        private Builder() {
        }

        public Builder links(LinksDto links) {
            this.links = links;
            return this;
        }

        public Builder elementCount(Integer elementCount) {
            this.elementCount = elementCount;
            return this;
        }

        public Builder nearEarthObjects(List<AsteroidDto> nearEarthObjects) {
            this.nearEarthObjects = nearEarthObjects;
            return this;
        }

        public AsteroidCollectionDto build() {
            return new AsteroidCollectionDto(links, elementCount, nearEarthObjects);
        }

    }
}
