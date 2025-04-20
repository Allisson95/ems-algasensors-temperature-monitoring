package dev.allisson.algasensors.temperature.monitoring.api.config.web;

import io.hypersistence.tsid.TSID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringToTSIDConverter implements Converter<String, TSID> {
    @Override
    public TSID convert(final @NonNull String source) {
        return TSID.from(source);
    }
}
