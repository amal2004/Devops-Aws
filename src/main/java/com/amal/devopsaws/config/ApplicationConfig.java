package com.amal.devopsaws.config;


import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.amal.devopsaws.backend.persistence.repositories")
@EntityScan(basePackages = "com.amal.devopsaws.backend.persistence.domain.backend")
@PropertySource(value = {"file:///C:/Users/Amal/Documents/devopsaws-stripe/application-common.properties"})
@EnableTransactionManagement
public class ApplicationConfig {
}
