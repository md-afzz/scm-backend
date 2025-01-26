package com.scm.backend.config;

import com.scm.backend.entity.Contact;
import com.scm.backend.entity.User;
import com.scm.backend.entity.events.processors.UserEventHandler;
import com.scm.backend.utils.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class Configurations {

    @Bean
    public UserEventHandler userEventHandler(){
        return new UserEventHandler();
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(){
        return new RepositoryRestConfigurer(){

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
//                config.setBasePath(AppConstants.BASE_PATH);
                config.setDefaultPageSize(AppConstants.DEFAULT_PAGE_SIZE);
                config.setReturnBodyOnCreate(true);
                config.setReturnBodyOnDelete(false);
                config.exposeIdsFor(User.class, Contact.class);
                config.setExposeRepositoryMethodsByDefault(true);
                config.setDefaultMediaType(MediaType.APPLICATION_JSON);
            }

        };
    }
}
