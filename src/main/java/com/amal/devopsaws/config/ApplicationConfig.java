package com.amal.devopsaws.config;


import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.amal.devopsaws.backend.persistence.repositories")
@EntityScan(basePackages = "com.amal.devopsaws.backend.persistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
