package com.softwareengineering.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="No user with the specified emailId")
public class UserNotFoundException extends RuntimeException {
    private String message;

    public UserNotFoundException(String message){
        this.message = message;
    }
}
