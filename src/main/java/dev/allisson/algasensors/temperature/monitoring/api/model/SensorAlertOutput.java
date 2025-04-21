package dev.allisson.algasensors.temperature.monitoring.api.model;

import io.hypersistence.tsid.TSID;

import java.io.Serializable;

/**
 * DTO for {@link dev.allisson.algasensors.temperature.monitoring.domain.model.SensorAlert}
 */
public record SensorAlertOutput(
        TSID id,
        Double maxTemperature,
        Double minTemperature
) implements Serializable {
}