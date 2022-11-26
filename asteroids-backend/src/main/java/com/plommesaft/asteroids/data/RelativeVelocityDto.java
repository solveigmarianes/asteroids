package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelativeVelocityDto {
    private BigDecimal kilometersPerSecond;
    private BigDecimal kilometersPerHour;
    private BigDecimal milesPerHour;

    public RelativeVelocityDto(BigDecimal kilometersPerSecond, BigDecimal kilometersPerHour, BigDecimal milesPerHour) {
        this.kilometersPerSecond = kilometersPerSecond;
        this.kilometersPerHour = kilometersPerHour;
        this.milesPerHour = milesPerHour;
    }

    public BigDecimal getKilometersPerSecond() {
        return kilometersPerSecond;
    }

    public void setKilometersPerSecond(BigDecimal kilometersPerSecond) {
        this.kilometersPerSecond = kilometersPerSecond;
    }

    public BigDecimal getKilometersPerHour() {
        return kilometersPerHour;
    }

    public void setKilometersPerHour(BigDecimal kilometersPerHour) {
        this.kilometersPerHour = kilometersPerHour;
    }

    public BigDecimal getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(BigDecimal milesPerHour) {
        this.milesPerHour = milesPerHour;
    }
}
