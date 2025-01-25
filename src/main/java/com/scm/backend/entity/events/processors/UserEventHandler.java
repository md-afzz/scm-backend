package com.scm.backend.entity.events.processors;

import com.scm.backend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.util.UUID;


@RepositoryEventHandler
public class UserEventHandler {

    private Logger log = LoggerFactory.getLogger(UserEventHandler.class);

    @HandleBeforeSave
    public void handleUserBeforeSave(User user){
        user.setUserId(UUID.randomUUID().toString());
        // Also , encrypt password here , for hashing purpose...
    }

    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user){
        log.info("User creation in progress now !! {}", user.getUserId());
    }

    @HandleAfterDelete
    public void handleUserAfterDelete(User user){
        log.info("User is deleted now !! {}", user.getUserId());
    }
}
