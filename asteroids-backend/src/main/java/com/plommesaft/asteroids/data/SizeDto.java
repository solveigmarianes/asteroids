package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SizeDto {
    private EstimatedDiameterDto kilometers;
    private EstimatedDiameterDto meters;
    private EstimatedDiameterDto miles;
    private EstimatedDiameterDto feet;

    public SizeDto(EstimatedDiameterDto kilometers, EstimatedDiameterDto meters, EstimatedDiameterDto miles, EstimatedDiameterDto feet) {
        this.kilometers = kilometers;
        this.meters = meters;
        this.miles = miles;
        this.feet = feet;
    }

    public EstimatedDiameterDto getKilometers() {
        return kilometers;
    }

    public void setKilometers(EstimatedDiameterDto kilometers) {
        this.kilometers = kilometers;
    }

    public EstimatedDiameterDto getMeters() {
        return meters;
    }

    public void setMeters(EstimatedDiameterDto meters) {
        this.meters = meters;
    }

    public EstimatedDiameterDto getMiles() {
        return miles;
    }

    public void setMiles(EstimatedDiameterDto miles) {
        this.miles = miles;
    }

    public EstimatedDiameterDto getFeet() {
        return feet;
    }

    public void setFeet(EstimatedDiameterDto feet) {
        this.feet = feet;
    }
}
