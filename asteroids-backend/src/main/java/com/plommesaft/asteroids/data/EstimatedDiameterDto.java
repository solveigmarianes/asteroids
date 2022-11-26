package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstimatedDiameterDto {
    private BigDecimal estimatedDiameterMin;
    private BigDecimal estimatedDiameterMax;

    public EstimatedDiameterDto(BigDecimal estimatedDiameterMin, BigDecimal estimatedDiameterMax) {
        this.estimatedDiameterMin = estimatedDiameterMin;
        this.estimatedDiameterMax = estimatedDiameterMax;
    }

    public BigDecimal getEstimatedDiameterMin() {
        return estimatedDiameterMin;
    }

    public void setEstimatedDiameterMin(BigDecimal estimatedDiameterMin) {
        this.estimatedDiameterMin = estimatedDiameterMin;
    }

    public BigDecimal getEstimatedDiameterMax() {
        return estimatedDiameterMax;
    }

    public void setEstimatedDiameterMax(BigDecimal estimatedDiameterMax) {
        this.estimatedDiameterMax = estimatedDiameterMax;
    }
}
