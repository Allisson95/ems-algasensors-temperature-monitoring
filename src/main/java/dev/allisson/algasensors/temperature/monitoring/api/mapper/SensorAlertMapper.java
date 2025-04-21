package dev.allisson.algasensors.temperature.monitoring.api.mapper;

import dev.allisson.algasensors.temperature.monitoring.api.model.SensorAlertInput;
import dev.allisson.algasensors.temperature.monitoring.api.model.SensorAlertOutput;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorAlert;
import dev.allisson.algasensors.temperature.monitoring.domain.model.SensorId;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SensorAlertMapper {
    SensorAlert toEntity(SensorId sensorId, SensorAlertInput sensorAlertInput);

    @Mapping(target = "id", source = "id.value")
    SensorAlertOutput toDto(SensorAlert sensorAlert);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SensorAlert partialUpdate(SensorAlertInput sensorAlertInput, @MappingTarget SensorAlert sensorAlert);
}