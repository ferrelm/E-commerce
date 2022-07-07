package com.example.demo;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public void outOfBounds() {
        System.out.println("OUT OF BOUNDS");
    }

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ExceptionHandler({ MyResourceNotFoundException.class, NoSuchElementException.class })
    public String notFound(Exception ex, HttpSession session) {
        String sessionId = session.getId();
        System.out.println("Session ID: sessionId()");
        return sessionId;
    }
}
