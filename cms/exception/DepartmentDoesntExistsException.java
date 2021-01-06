package com.softwareengineering.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Department doesn't exists")
public class DepartmentDoesntExistsException extends  RuntimeException{
    String departmentName;
    String message;

    public DepartmentDoesntExistsException(String departmentName){
        this.departmentName = departmentName;
        this.message = "Department doesn't exist";
    }
}
