package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MissDistanceDto {
    private BigDecimal astronomical;
    private BigDecimal lunar;
    private BigDecimal kilometers;
    private BigDecimal miles;

    public MissDistanceDto(BigDecimal astronomical, BigDecimal lunar, BigDecimal kilometers, BigDecimal miles) {
        this.astronomical = astronomical;
        this.lunar = lunar;
        this.kilometers = kilometers;
        this.miles = miles;
    }

    public BigDecimal getAstronomical() {
        return astronomical;
    }

    public void setAstronomical(BigDecimal astronomical) {
        this.astronomical = astronomical;
    }

    public BigDecimal getLunar() {
        return lunar;
    }

    public void setLunar(BigDecimal lunar) {
        this.lunar = lunar;
    }

    public BigDecimal getKilometers() {
        return kilometers;
    }

    public void setKilometers(BigDecimal kilometers) {
        this.kilometers = kilometers;
    }

    public BigDecimal getMiles() {
        return miles;
    }

    public void setMiles(BigDecimal miles) {
        this.miles = miles;
    }
}
