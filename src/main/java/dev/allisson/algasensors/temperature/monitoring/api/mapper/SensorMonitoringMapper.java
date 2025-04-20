package dev.allisson.algasensors.temperature.monitoring.api.mapper;

import dev.allisson.algasensors.temperature.monitoring.api.model.SensorMonitoringOutput;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorMonitoring;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SensorMonitoringMapper {
    @Mapping(target = "id", source = "id.value")
    SensorMonitoringOutput toDto(SensorMonitoring sensorMonitoring);
}