package com.beerhouse.mapper;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.entity.CervejaEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class CervejaMapper {

    public static CervejaEntity convert(Cerveja cerveja) {
        return CervejaEntity.builder()
                .marca(cerveja.getMarca())
                .tipo(cerveja.getTipo())
                .preco(cerveja.getPreco())
                .build();
    }
}
