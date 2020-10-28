package com.beerhouse.mapper;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.entity.CervejaEntity;
import com.beerhouse.mock.CervejaTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CervejaMapperTest {

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
