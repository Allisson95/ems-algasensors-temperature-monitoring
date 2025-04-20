package dev.allisson.algasensors.temperature.monitoring.api.controller;

import dev.allisson.algasensors.temperature.monitoring.api.mapper.SensorMonitoringMapper;
import dev.allisson.algasensors.temperature.monitoring.api.model.SensorMonitoringOutput;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorMonitoring;
import dev.allisson.algasensors.temperature.monitoring.domain.repository.SensorMonitoringRepository;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sensors/{sensorId}/monitoring")
public class SensorMonitoringController {

    private final SensorMonitoringRepository sensorMonitoringRepository;
    private final SensorMonitoringMapper sensorMonitoringMapper;

    @GetMapping
    public ResponseEntity<SensorMonitoringOutput> get(@PathVariable final TSID sensorId) {
        final SensorId id = new SensorId(sensorId);
        final SensorMonitoring sensorMonitoring = this.getSensorMonitoringOrDefault(id);
        return ResponseEntity.ok(this.sensorMonitoringMapper.toDto(sensorMonitoring));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/enable")
    public void enable(@PathVariable TSID sensorId) {
        final SensorId id = new SensorId(sensorId);
        final SensorMonitoring sensorMonitoring = this.getSensorMonitoringOrDefault(id);
        sensorMonitoring.enable();
        this.sensorMonitoringRepository.update(sensorMonitoring);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/enable")
    public void disable(@PathVariable TSID sensorId) {
        final SensorId id = new SensorId(sensorId);
        final SensorMonitoring sensorMonitoring = this.getSensorMonitoringOrDefault(id);
        sensorMonitoring.disable();
        this.sensorMonitoringRepository.update(sensorMonitoring);
    }

    private SensorMonitoring getSensorMonitoringOrDefault(final SensorId id) {
        return this.sensorMonitoringRepository.findById(id)
                .orElseGet(() -> this.sensorMonitoringRepository.persist(new SensorMonitoring(id)));
    }

}
