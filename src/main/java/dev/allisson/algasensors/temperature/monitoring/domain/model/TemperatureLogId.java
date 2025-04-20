package dev.allisson.algasensors.temperature.monitoring.domain.model;

import jakarta.persistence.Embeddable;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record TemperatureLogId(UUID value) implements Serializable {

    public TemperatureLogId {
        if (value == null) {
            throw new IllegalArgumentException("UUID cannot be null");
        }
    }

    public TemperatureLogId() {
        this(UUID.randomUUID());
    }

    public TemperatureLogId(String value) {
        this(UUID.fromString(value));
    }

    @Override
    public @NonNull String toString() {
        return value.toString();
    }

}
