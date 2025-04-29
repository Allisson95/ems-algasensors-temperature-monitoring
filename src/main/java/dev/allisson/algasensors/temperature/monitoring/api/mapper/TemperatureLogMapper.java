package dev.allisson.algasensors.temperature.monitoring.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import dev.allisson.algasensors.temperature.monitoring.api.model.TemperatureLogData;
import dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLog;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TemperatureLogMapper {
    @Mappings({
            @Mapping(source = "id.value", target = "id"),
            @Mapping(source = "sensorId.value", target = "sensorId"),
            @Mapping(source = "value", target = "temperature"),
            @Mapping(source = "registeredAt", target = "registeredAt")
    })
    TemperatureLogData toDto(TemperatureLog temperatureLog);

}