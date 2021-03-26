package com.beerhouse.application.usecase;

import com.beerhouse.domain.Cerveja;

import java.util.Collection;

public interface ListarUseCase {

    Collection<Cerveja> listar();
}
