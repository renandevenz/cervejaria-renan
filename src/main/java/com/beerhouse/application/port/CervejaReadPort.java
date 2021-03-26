package com.beerhouse.application.port;

import com.beerhouse.domain.Cerveja;

import java.util.List;
import java.util.Optional;

public interface CervejaReadPort {

    List<Cerveja> listar();

    Optional<Cerveja> buscarPorMarca(String marca);
}
