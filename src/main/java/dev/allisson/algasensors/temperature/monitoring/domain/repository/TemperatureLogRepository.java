package dev.allisson.algasensors.temperature.monitoring.domain.repository;

import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLog;
import dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLogId;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TemperatureLogRepository extends BaseJpaRepository<TemperatureLog, TemperatureLogId> {
    Page<TemperatureLog> findAllBySensorId(SensorId sensorId, Pageable pageable);
}