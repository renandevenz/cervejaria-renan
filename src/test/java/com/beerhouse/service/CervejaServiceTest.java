package com.beerhouse.service;

import com.beerhouse.entity.CervejaEntity;
import com.beerhouse.repository.CervejaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

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
    @DisplayName("Deve salvar o produto com sucesso")
    public void salvarCervejaComSucesso() throws IllegalArgumentException {

        cervejaService.salvar(cervejaEntity);
        verify(cervejaRepository).save(cervejaEntity);
    }

    @Test
    @DisplayName("Não deve salvar o produto")
    public void salvarCervejaComErro() throws IllegalArgumentException {

        when(cervejaRepository.findByMarca(MARCA)).thenReturn(Optional.ofNullable(cervejaEntity));
        cervejaService.salvar(cervejaEntity);
    }
}
