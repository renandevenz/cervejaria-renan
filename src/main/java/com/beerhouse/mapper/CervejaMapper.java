package com.beerhouse.mapper;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.entity.CervejaEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CervejaMapper {

    public static CervejaEntity convert(Cerveja cerveja) {
        log.info("Construção do Mapper");
        return CervejaEntity.builder()
                .marca(cerveja.getMarca())
                .tipo(cerveja.getTipo())
                .preco(cerveja.getPreco())
                .build();
    }
}
