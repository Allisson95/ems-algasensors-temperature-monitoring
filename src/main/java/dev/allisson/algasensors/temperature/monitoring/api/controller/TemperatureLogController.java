package dev.allisson.algasensors.temperature.monitoring.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.allisson.algasensors.temperature.monitoring.api.mapper.TemperatureLogMapper;
import dev.allisson.algasensors.temperature.monitoring.api.model.TemperatureLogData;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLog;
import dev.allisson.algasensors.temperature.monitoring.domain.repository.TemperatureLogRepository;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures")
public class TemperatureLogController {

    private final TemperatureLogRepository temperatureLogRepository;
    private final TemperatureLogMapper temperatureLogMapper;

    @GetMapping
    public ResponseEntity<Page<TemperatureLogData>> search(
            @PathVariable final TSID sensorId,
            @PageableDefault final Pageable pageable) {
        final Page<TemperatureLog> temperatureLogs = this.temperatureLogRepository
                .findAllBySensorId(new SensorId(sensorId), pageable);
        return ResponseEntity.ok(temperatureLogs.map(this.temperatureLogMapper::toDto));
    }

}
