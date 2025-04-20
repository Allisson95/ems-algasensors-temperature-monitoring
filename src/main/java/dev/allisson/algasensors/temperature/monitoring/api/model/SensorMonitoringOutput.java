package dev.allisson.algasensors.temperature.monitoring.api.model;

import io.hypersistence.tsid.TSID;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link dev.allisson.algasensors.temperature.monitoring.domain.model.SensorMonitoring}
 */
public record SensorMonitoringOutput(
        TSID id,
        Double lastTemperature,
        Instant updatedAt,
        Boolean enabled
) implements Serializable {
}