package com.beerhouse.adapter.output;

import com.beerhouse.adapter.output.mapper.CervejaEntityMapper;
import com.beerhouse.adapter.output.repository.CervejaRepository;
import com.beerhouse.application.port.CervejaReadPort;
import com.beerhouse.domain.Cerveja;
import com.beerhouse.infra.annotations.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Adapter
@RequiredArgsConstructor
public class CervejaReadAdapter implements CervejaReadPort {

    private final CervejaRepository repository;
    private final CervejaEntityMapper mapper;

    @Override
    public List<Cerveja> listar() {

        return repository.findAll()
                .stream()
                .map(mapper::convertToEntity)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<Cerveja> buscarPorMarca(String marca) {

        return repository.findByMarca(marca)
                .map(mapper::convertToEntity);
    }
}
