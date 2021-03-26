package com.beerhouse.adapter.input.mapper;

import com.beerhouse.adapter.input.api.CervejaRequest;
import com.beerhouse.domain.Cerveja;
import com.beerhouse.domain.Tipo;
import org.springframework.stereotype.Component;

@Component
public class CervejaRequestMapper {

    public CervejaRequest convertToDomain(Cerveja cerveja) {

        return CervejaRequest.builder()
                .marca(cerveja.getMarca())
                .tipo(String.valueOf(Tipo.TIPO))
                .preco(cerveja.getPreco())
                .build();
    }
}
