package com.beerhouse.service;

import com.beerhouse.entity.CervejaEntity;
import com.beerhouse.repository.CervejaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CervejaServiceTest {

    private static final String MARCA = "Heineken";

    @Mock
    private CervejaRepository cervejaRepository;

    @Mock
    private CervejaService cervejaService;

    @Mock
    private CervejaEntity cervejaEntity;

    @BeforeEach
    public void setup() throws IllegalArgumentException {

        cervejaService = new CervejaService(cervejaRepository);

        cervejaEntity = new CervejaEntity();
        cervejaEntity.setMarca(MARCA);

        when(cervejaRepository.findByMarca(MARCA)).thenReturn(Optional.empty());
    }

    @Test
    public void salvarClienteComSucesso() throws IllegalArgumentException {

        cervejaService.salvar(cervejaEntity);
        verify(cervejaRepository).save(cervejaEntity);
    }

    @Test
    public void salvarClienteComErro() throws IllegalArgumentException {

        when(cervejaRepository.findByMarca(MARCA)).thenReturn(Optional.ofNullable(cervejaEntity));
        cervejaService.salvar(cervejaEntity);
    }
}
