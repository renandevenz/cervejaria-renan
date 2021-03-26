package com.beerhouse.adapter.input;

import com.beerhouse.adapter.input.api.CervejaRequest;
import com.beerhouse.adapter.input.mapper.CervejaRequestMapper;
import com.beerhouse.application.port.FindAllCervejaPort;
import com.beerhouse.application.usecase.ListarUseCase;
import com.beerhouse.infra.annotations.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@Adapter
@RequiredArgsConstructor
public class FindAllCervejaAdapter implements FindAllCervejaPort {

    private final CervejaRequestMapper mapper;
    private final ListarUseCase listarUseCase;

    @Override
    public Collection<CervejaRequest> collect() {
        return listarUseCase.listar()
                .stream()
                .map(mapper::convertToDomain)
                .collect(Collectors.toUnmodifiableList());
    }
}
