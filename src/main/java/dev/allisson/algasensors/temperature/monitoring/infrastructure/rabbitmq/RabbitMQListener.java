package dev.allisson.algasensors.temperature.monitoring.infrastructure.rabbitmq;

import static dev.allisson.algasensors.temperature.monitoring.infrastructure.rabbitmq.RabbitMQConfiguration.QUEUE;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import dev.allisson.algasensors.temperature.monitoring.api.model.TemperatureLogData;
import dev.allisson.algasensors.temperature.monitoring.domain.service.TemperatureMonitoringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitMQListener {

    private final TemperatureMonitoringService temperatureMonitoringService;

    @RabbitListener(queues = { QUEUE })
    void handleTemperatureData(
            @Payload final TemperatureLogData temperatureLogData,
            @Headers final MessageHeaders headers) {
        log.info("Received temperature data: {} and headers: {}", temperatureLogData, headers);
        this.temperatureMonitoringService.processTemperatureData(temperatureLogData);
    }

}
