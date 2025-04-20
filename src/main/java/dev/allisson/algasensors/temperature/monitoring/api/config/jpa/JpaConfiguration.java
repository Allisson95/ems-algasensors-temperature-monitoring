package dev.allisson.algasensors.temperature.monitoring.api.config.jpa;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        value = "dev.allisson.algasensors.temperature.monitoring.domain",
        repositoryBaseClass = BaseJpaRepositoryImpl.class
)
public class JpaConfiguration {
}
