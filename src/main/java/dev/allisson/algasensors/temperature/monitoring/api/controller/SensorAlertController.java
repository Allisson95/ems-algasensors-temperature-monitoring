package dev.allisson.algasensors.temperature.monitoring.api.controller;

import dev.allisson.algasensors.temperature.monitoring.api.mapper.SensorAlertMapper;
import dev.allisson.algasensors.temperature.monitoring.api.model.SensorAlertInput;
import dev.allisson.algasensors.temperature.monitoring.api.model.SensorAlertOutput;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorAlert;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import dev.allisson.algasensors.temperature.monitoring.domain.repository.SensorAlertRepository;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sensors/{sensorId}/alert")
public class SensorAlertController {

    private final SensorAlertRepository sensorAlertRepository;
    private final SensorAlertMapper sensorAlertMapper;

    @GetMapping
    public ResponseEntity<SensorAlertOutput> getOne(@PathVariable final TSID sensorId) {
        return this.sensorAlertRepository.findById(new SensorId(sensorId))
                .map(sensorAlertMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<SensorAlertOutput> put(
            @PathVariable final TSID sensorId, @RequestBody final SensorAlertInput input) {
        final SensorAlert sensorAlert = this.sensorAlertRepository.findById(new SensorId(sensorId))
                .orElseGet(() ->
                        this.sensorAlertRepository.persist(
                                this.sensorAlertMapper.toEntity(new SensorId(sensorId), input)));
        this.sensorAlertMapper.partialUpdate(input, sensorAlert);
        this.sensorAlertRepository.update(sensorAlert);
        return ResponseEntity.ok(this.sensorAlertMapper.toDto(sensorAlert));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(@PathVariable TSID sensorId) {
        this.sensorAlertRepository.findById(new SensorId(sensorId))
                .ifPresentOrElse(
                        this.sensorAlertRepository::delete,
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        });
    }

}
