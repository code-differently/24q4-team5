package com.employee_mgr_server.domain.core.exceptions;

public class ResourceNotFoundException extends RunTimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
