package com.beerhouse.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Tipo {

    TIPO;

    private static final String A = "PURO_MALTE";
    private static final String B = "PILSEN";
    private static final String C = "IPA";
}
