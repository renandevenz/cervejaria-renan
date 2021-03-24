package com.beerhouse.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler extends RuntimeException {

    public ExceptionHandler(String message) {
        super(message);
    }
}
