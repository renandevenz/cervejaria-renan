package com.beerhouse.mock;

import com.beerhouse.domain.Cerveja;

import java.math.BigDecimal;

public class CervejaTO {

    private static final BigDecimal PRECO = new BigDecimal(1);

    public static Cerveja get() {
        return Cerveja.builder()
                .marca("Bavaria")
                .tipo("Pilsen")
                .preco(PRECO)
                .build();
    }
}
