package com.softwareengineering.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Admin exists")
public class AdminAlreadyExistsException extends RuntimeException {
    String emailId;
    String utaId;
    String message;

    public AdminAlreadyExistsException(String emailId, String utaId){
        this.emailId = emailId;
        this.utaId = utaId;
        this.message = "Admin exists with this emailId or utaId";
    }
}
