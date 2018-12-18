package com.amal.devopsaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.amal.devopsaws.backend.persistence.repositories")
public class DevopsawsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevopsawsApplication.class, args);
    }
}
