package com.amal.devopsaws.config;

import com.amal.devopsaws.backend.service.EmailService;
import com.amal.devopsaws.backend.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")

@PropertySource(value = {"file:///C:/Users/Amal/Documents/devopsaws-stripe/application-dev.properties"})
public class DevelopmentConfig {

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}
