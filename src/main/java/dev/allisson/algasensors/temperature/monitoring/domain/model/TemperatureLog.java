package dev.allisson.algasensors.temperature.monitoring.domain.model;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;

@Getter
@Entity
@EntityListeners({ AuditingEntityListener.class })
public class TemperatureLog implements Serializable {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "UUID"))
    private TemperatureLogId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "sensor_id", columnDefinition = "BIGINT"))
    private SensorId sensorId;

    @Column(name = "\"value\"", nullable = false)
    private Double value;

    @CreatedDate
    private Instant registeredAt;

    protected TemperatureLog() {
        // Default constructor for JPA
    }

    public TemperatureLog(final SensorId sensorId, final Double value) {
        this.id = new TemperatureLogId();
        this.sensorId = sensorId;
        this.value = value;
    }

}