package dev.allisson.algasensors.temperature.monitoring.api.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import io.hypersistence.tsid.TSID;

/**
 * DTO for {@link dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLog}
 */
public record TemperatureLogData(
        UUID id,
        TSID sensorId,
        Double temperature,
        Instant registeredAt
) implements Serializable {
}