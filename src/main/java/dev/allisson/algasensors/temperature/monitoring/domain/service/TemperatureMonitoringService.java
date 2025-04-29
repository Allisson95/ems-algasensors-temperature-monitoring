package dev.allisson.algasensors.temperature.monitoring.domain.service;

import org.springframework.stereotype.Service;

import dev.allisson.algasensors.temperature.monitoring.api.model.TemperatureLogData;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorMonitoring;
import dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLog;
import dev.allisson.algasensors.temperature.monitoring.domain.repository.SensorMonitoringRepository;
import dev.allisson.algasensors.temperature.monitoring.domain.repository.TemperatureLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TemperatureMonitoringService {

    private final SensorMonitoringRepository sensorMonitoringRepository;

    private final TemperatureLogRepository temperatureLogRepository;

    public void processTemperatureData(final TemperatureLogData temperatureLogData) {
        this.sensorMonitoringRepository.findById(new SensorId(temperatureLogData.sensorId()))
                .ifPresentOrElse(
                        sensor -> this.handleTemperatureLogData(temperatureLogData, sensor),
                        () -> log.warn("Temperature log ignored. Sensor with id {} not found",
                                temperatureLogData.sensorId()));
    }

    private void handleTemperatureLogData(final TemperatureLogData temperatureLogData, final SensorMonitoring sensor) {
        if (sensor.isEnabled()) {
            sensor.updateLastTemperature(temperatureLogData.temperature());
            this.sensorMonitoringRepository.update(sensor);

            final TemperatureLog temperatureLog = new TemperatureLog(sensor.getId(), temperatureLogData.temperature());
            this.temperatureLogRepository.persist(temperatureLog);
        } else {
            log.warn("Temperature log ignored. Sensor with id {} is disabled", temperatureLogData.sensorId());
        }
    }

}
