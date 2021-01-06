package com.softwareengineering.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="Password is incorrect")
public class InvalidCredentialsException extends RuntimeException {
    private String emailId;
    private String message;

    public InvalidCredentialsException(String emailId){
        this.message = "Given password is incorrect";
        this.emailId = emailId;
    }
}
