package com.beerhouse.exception;

public class BaseException extends ExceptionHandler {
    public BaseException() {
        super(ErrorCodes.CUSTOM_EXCEPTION_1.getCode());
    }
}
