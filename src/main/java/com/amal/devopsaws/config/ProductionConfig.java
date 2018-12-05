package com.amal.devopsaws.config;

import com.amal.devopsaws.backend.service.EmailService;
import com.amal.devopsaws.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource(value = {"file:///C:/Users/Amal/Documents/devopsaws-stripe/application-prod.properties"})
public class ProductionConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
