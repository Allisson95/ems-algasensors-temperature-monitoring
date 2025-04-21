package dev.allisson.algasensors.temperature.monitoring.domain.repository;

import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorAlert;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;

public interface SensorAlertRepository extends BaseJpaRepository<SensorAlert, SensorId> {
}