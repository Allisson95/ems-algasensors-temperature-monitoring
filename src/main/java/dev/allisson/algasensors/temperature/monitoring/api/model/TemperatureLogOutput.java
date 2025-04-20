package dev.allisson.algasensors.temperature.monitoring.api.model;

import io.hypersistence.tsid.TSID;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLog}
 */
public record TemperatureLogOutput(
        UUID id,
        TSID sensorId,
        Double temperature,
        Instant registeredAt
) implements Serializable {
}