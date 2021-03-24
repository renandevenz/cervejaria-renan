package com.beerhouse.application.service;

import com.beerhouse.application.domain.Cerveja;
import com.beerhouse.application.usecase.BuscarUseCase;
import com.beerhouse.application.usecase.ListarUseCase;
import com.beerhouse.output.adapter.entity.CervejaEntity;
import com.beerhouse.output.adapter.port.CervejaPort;
import com.beerhouse.output.adapter.port.ListarCervejasPort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class CervejaService implements BuscarUseCase, ListarUseCase {

    private Converter<Cerveja, CervejaEntity> converter;
    private final CervejaPort port;
    private final ListarCervejasPort cervejasPort;

    @Override
    public void buscarProduto(Cerveja produto) {
        try {
            final CervejaEntity entity = converter.convert(produto);
            port.convert(entity);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Collection<Cerveja> listar() {
        return cervejasPort.listar();
    }
}