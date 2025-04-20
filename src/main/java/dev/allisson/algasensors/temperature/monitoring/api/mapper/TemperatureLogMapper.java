package dev.allisson.algasensors.temperature.monitoring.api.mapper;

import dev.allisson.algasensors.temperature.monitoring.api.model.TemperatureLogOutput;
import dev.allisson.algasensors.temperature.monitoring.domain.model.TemperatureLog;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TemperatureLogMapper {
    @Mappings({
            @Mapping(source = "id.value", target = "id"),
            @Mapping(source = "sensorId.value", target = "sensorId"),
            @Mapping(source = "value", target = "temperature"),
            @Mapping(source = "registeredAt", target = "registeredAt")
    })
    TemperatureLogOutput toDto(TemperatureLog temperatureLog);

}