package com.beerhouse.application;

import com.beerhouse.adapter.output.entity.CervejaEntity;
import com.beerhouse.adapter.output.repository.CervejaRepository;
import com.beerhouse.application.service.CervejaService;
import com.beerhouse.domain.Cerveja;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CervejaRequestServiceTest {

    private static final String MARCA = "Heineken";

    @Mock
    private CervejaRepository cervejaRepository;

    @Mock
    private CervejaService cervejaService;

    @Mock
    private Cerveja cerveja;

    private CervejaEntity cervejaEntity;

    @BeforeEach
    public void setup() throws IllegalArgumentException {

        cervejaEntity = new CervejaEntity();
        cervejaEntity.setMarca(MARCA);

        when(cervejaRepository.findByMarca(MARCA)).thenReturn(Optional.empty());
    }

    @Test
    @DisplayName("Deve salvar o produto com sucesso")
    public void salvarCervejaComSucesso() throws IllegalArgumentException {

        cervejaService.buscarProduto(cerveja);
        verify(cervejaRepository).save(cervejaEntity);
    }

    @Test
    @DisplayName("Não deve salvar o produto")
    public void salvarCervejaComErro() throws IllegalArgumentException {

        when(cervejaRepository.findByMarca(MARCA)).thenReturn(Optional.ofNullable(cervejaEntity));
        cervejaService.buscarProduto(cerveja);
    }
}
