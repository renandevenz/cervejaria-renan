package com.beerhouse.mock;

import com.beerhouse.domain.Cerveja;

public class CervejaTO {

    public static Cerveja get() {
        return Cerveja.builder()
                .marca("Bavaria")
                .tipo("Pilsen")
                .preco(Double.valueOf("123"))
                .build();
    }
}
