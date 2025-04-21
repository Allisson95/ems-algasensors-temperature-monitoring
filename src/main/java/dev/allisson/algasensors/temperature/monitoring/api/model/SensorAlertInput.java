package dev.allisson.algasensors.temperature.monitoring.api.model;

import java.io.Serializable;

/**
 * DTO for {@link dev.allisson.algasensors.temperature.monitoring.domain.model.SensorAlert}
 */
public record SensorAlertInput(
        Double maxTemperature,
        Double minTemperature
) implements Serializable {
}