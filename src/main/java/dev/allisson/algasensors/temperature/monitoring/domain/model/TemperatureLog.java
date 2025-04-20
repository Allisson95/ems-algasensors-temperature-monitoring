package dev.allisson.algasensors.temperature.monitoring.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Entity
public class TemperatureLog implements Serializable {
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "UUID"))
    private TemperatureLogId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "sensor_id", columnDefinition = "BIGINT"))
    private SensorId sensorId;

    @Column(name = "\"value\"", nullable = false)
    private Double value;

    private Instant registeredAt;

}