package com.beerhouse.adapter.output.mapper;

import com.beerhouse.application.domain.Cerveja;
import com.beerhouse.adapter.output.entity.CervejaEntity;
import com.beerhouse.mock.CervejaTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CervejaRequestMapperTest {

    @Test
    void comparaCamposCervejaMapper() {

        Cerveja cerveja = CervejaTO.get();
        CervejaEntity cervejaEntity = CervejaMapper.convert(cerveja);

        Assertions.assertThat(cervejaEntity.getMarca())
                .isEqualTo(cerveja.getMarca());
        Assertions.assertThat(cervejaEntity.getTipo())
                .isEqualTo(cerveja.getTipo());
        Assertions.assertThat(cervejaEntity.getPreco())
                .isEqualTo(cerveja.getPreco());
    }
}
