package com.beerhouse.output.adapter.mapper;

import com.beerhouse.application.domain.Cerveja;
import com.beerhouse.output.adapter.entity.CervejaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
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
