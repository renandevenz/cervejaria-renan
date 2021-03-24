package com.beerhouse.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCodes {

    CUSTOM_EXCEPTION_1("Ocorreu um erro na aplicação");

    private final String code;
}
