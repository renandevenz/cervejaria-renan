package com.beerhouse.service;

import com.beerhouse.domain.Cerveja;
import com.beerhouse.repository.CervejaRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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
    private Cerveja cerveja;

    @BeforeEach
    public void setup() throws IllegalArgumentException {

        cervejaService = new CervejaService(cervejaRepository);

        cerveja = new Cerveja();
        cerveja.setMarca(MARCA);

        when(cervejaRepository.findByMarca(MARCA)).thenReturn(Optional.empty());
    }

    @Test
    public void salvarClienteComSucesso() throws IllegalArgumentException {

        cervejaService.salvar(cerveja);
        verify(cervejaRepository).save(cerveja);
    }

    @Test
    public void salvarClienteComErro() throws IllegalArgumentException {

        when(cervejaRepository.findByMarca(MARCA)).thenReturn(Optional.ofNullable(cerveja));
        cervejaService.salvar(cerveja);
    }
}
