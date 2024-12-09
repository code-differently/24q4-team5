package com.employee_mgr_server.domain.core.exceptions;

public class ResourceCreationException extends RuntimeException{
    public ResourceCreationException(String message){
        super(message);
    }
}
