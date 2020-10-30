package com.beerhouse.exception;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface RestExceptionHandler<E extends Exception, T> {

    ResponseEntity<T> handleException(E exception, HttpServletRequest request);
}
