package dev.allisson.algasensors.temperature.monitoring.domain.model;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;

@Getter
@Entity
@EntityListeners({ AuditingEntityListener.class })
public class SensorMonitoring implements Serializable {

    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    @EmbeddedId
    private SensorId id;

    private Double lastTemperature;

    @LastModifiedDate
    private Instant updatedAt;

    private Boolean enabled;

    protected SensorMonitoring() {
        // Default constructor for JPA
    }

    public SensorMonitoring(final SensorId id) {
        this.id = id;
        this.enabled = false;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public void updateLastTemperature(final Double lastTemperature) {
        if (lastTemperature == null) {
            throw new IllegalArgumentException("Last temperature cannot be null");
        }
        if (!this.isEnabled()) {
            throw new IllegalStateException("Sensor is not enabled");
        }
        this.lastTemperature = lastTemperature;
    }

    public boolean isEnabled() {
        return Boolean.TRUE.equals(this.enabled);
    }

}
