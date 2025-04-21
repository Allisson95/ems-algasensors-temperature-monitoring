package dev.allisson.algasensors.temperature.monitoring.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class SensorAlert {
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private SensorId id;
    @Setter
    private Double maxTemperature;
    @Setter
    private Double minTemperature;

    protected SensorAlert() {
        // Default constructor for JPA
    }

    public SensorAlert(SensorId sensorId, Double maxTemperature, Double minTemperature) {
        this.id = sensorId;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }
}
