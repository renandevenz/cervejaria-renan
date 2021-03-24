package com.beerhouse.output.adapter.port;

import com.beerhouse.application.domain.Cerveja;

import java.util.List;

public interface ListarCervejasPort {

    List<Cerveja> listar();
}
