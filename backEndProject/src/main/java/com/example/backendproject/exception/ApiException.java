package com.example.backendproject.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
