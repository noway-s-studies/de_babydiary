package hu.unideb.inf.babydiary.persistence.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "hu.unideb.inf.babydiary.persistence.repository")
@EntityScan(basePackages = "hu.unideb.inf.babydiary.persistence.entity")
public class PersistenceConfiguration {
}
