package com.plommesaft.asteroids.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseApproachDto {
    private Date closeApproachDate;
    private Long epochDateCloseApproach;
    private RelativeVelocityDto relativeVelocity;
    private MissDistanceDto missDistance;
    private String orbitingBody;

    public CloseApproachDto(Date closeApproachDate, Long epochDateCloseApproach, RelativeVelocityDto relativeVelocity, MissDistanceDto missDistance, String orbitingBody) {
        this.closeApproachDate = closeApproachDate;
        this.epochDateCloseApproach = epochDateCloseApproach;
        this.relativeVelocity = relativeVelocity;
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }

    public Date getCloseApproachDate() {
        return closeApproachDate;
    }

    public void setCloseApproachDate(Date closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    public Long getEpochDateCloseApproach() {
        return epochDateCloseApproach;
    }

    public void setEpochDateCloseApproach(Long epochDateCloseApproach) {
        this.epochDateCloseApproach = epochDateCloseApproach;
    }

    public RelativeVelocityDto getRelativeVelocity() {
        return relativeVelocity;
    }

    public void setRelativeVelocity(RelativeVelocityDto relativeVelocity) {
        this.relativeVelocity = relativeVelocity;
    }

    public MissDistanceDto getMissDistance() {
        return missDistance;
    }

    public void setMissDistance(MissDistanceDto missDistance) {
        this.missDistance = missDistance;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }
}
