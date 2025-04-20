package dev.allisson.algasensors.temperature.monitoring.domain.repository;

import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorMonitoring;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;

public interface SensorMonitoringRepository extends BaseJpaRepository<SensorMonitoring, SensorId> {
}