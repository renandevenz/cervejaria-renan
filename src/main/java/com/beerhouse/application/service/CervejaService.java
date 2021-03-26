package com.beerhouse.application.service;

import com.beerhouse.adapter.output.entity.CervejaEntity;
import com.beerhouse.application.port.FindCervejaPort;
import com.beerhouse.application.usecase.BuscarUseCase;
import com.beerhouse.application.usecase.ListarUseCase;
import com.beerhouse.domain.Cerveja;
import com.beerhouse.exception.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
@Log
public class CervejaService implements BuscarUseCase, ListarUseCase {

    private Converter<Cerveja, CervejaEntity> converter;
    private final FindCervejaPort port;

    @Override
    public void buscarProduto(Cerveja produto) {

        try {
            final CervejaEntity entity = converter.convert(produto);
            port.entity(entity);
        } catch (BaseException e) {
            log.severe(e.getMessage());
        }
    }

    @Override
    public Collection<Cerveja> listar() {

        return port.listar();
    }
}