package com.beerhouse.application.usecase;

import com.beerhouse.application.domain.Cerveja;

import java.util.Collection;

public interface ListarUseCase {

    Collection<Cerveja> listar();
}
