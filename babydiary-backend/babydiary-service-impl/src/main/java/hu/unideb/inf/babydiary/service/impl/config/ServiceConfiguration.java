package hu.unideb.inf.babydiary.service.impl.config;

import hu.unideb.inf.babydiary.persistence.config.PersistenceConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
@EnableScheduling
@Import(PersistenceConfiguration.class)
@ComponentScan("hu.unideb.inf.babydiary.service")
public class ServiceConfiguration {
}
