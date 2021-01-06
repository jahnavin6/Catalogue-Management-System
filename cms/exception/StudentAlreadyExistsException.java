package com.softwareengineering.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Student already exists")
public class StudentAlreadyExistsException extends RuntimeException{
    String emailId;
    String utaId;
    String message;

    public StudentAlreadyExistsException(String emailId, String utaId){
        this.emailId = emailId;
        this.utaId = utaId;
        this.message = "Student already exists with this emailId or utaId";
    }
}
