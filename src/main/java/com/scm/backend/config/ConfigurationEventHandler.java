package com.scm.backend.config;

import com.scm.backend.entity.events.processors.UserEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationEventHandler {

    @Bean
    public UserEventHandler userEventHandler(){
        return new UserEventHandler();
    }
}
