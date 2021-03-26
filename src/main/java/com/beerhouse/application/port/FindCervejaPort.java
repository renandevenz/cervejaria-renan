package com.beerhouse.application.port;

import com.beerhouse.adapter.output.entity.CervejaEntity;
import com.beerhouse.domain.Cerveja;

import java.util.List;

public interface FindCervejaPort {

    void entity(CervejaEntity cervejaEntity);
    List<Cerveja> listar();
}
