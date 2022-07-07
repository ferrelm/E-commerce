package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource Not Found")
public class MyResourceNotFoundException extends RuntimeException {

    public MyResourceNotFoundException() {
        super();
    }

    public MyResourceNotFoundException(String message) {
        super(message);
    }

    public MyResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
