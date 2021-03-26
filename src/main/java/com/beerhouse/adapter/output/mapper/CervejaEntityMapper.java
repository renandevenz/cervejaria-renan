package com.beerhouse.adapter.output.mapper;

import com.beerhouse.adapter.output.entity.CervejaEntity;
import com.beerhouse.domain.Cerveja;
import com.beerhouse.domain.Tipo;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class CervejaEntityMapper {

    public Cerveja convertToEntity(CervejaEntity entity) {

        return Cerveja.builder()
                .marca(entity.getMarca())
                .tipo(Tipo.valueOf(entity.getTipo()))
                .preco(entity.getPreco())
                .build();
    }
}
