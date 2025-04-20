package dev.allisson.algasensors.temperature.monitoring.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Entity
public class SensorMonitoring implements Serializable {
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    @EmbeddedId
    private SensorId id;
    private Double lastTemperature;
    private Instant updatedAt;
    private Boolean enabled;

    protected SensorMonitoring() {
        // Default constructor for JPA
    }

    public SensorMonitoring(SensorId id) {
        this.id = id;
        this.enabled = false;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }
}
