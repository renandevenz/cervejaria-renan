package com.beerhouse.input;

import com.beerhouse.adapter.input.mapper.CervejaRequestMapper;
import com.beerhouse.application.service.CervejaService;
import com.beerhouse.domain.Cerveja;
import com.beerhouse.domain.Tipo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class CervejaRequestControllerTest {

    static String API = "/craftbeer";

    @Autowired
    MockMvc mockMvc;

    @Mock
    CervejaService service;

    @Mock
    CervejaRequestMapper mapper;

    @Test
    @DisplayName("Deve salvar um produto com sucesso")
    public void criarProdutoTest() throws Exception {

        Cerveja cerveja = Cerveja.builder()
                .marca("Itaipava")
                .tipo(Tipo.valueOf("Pilsen"))
                .preco(BigDecimal.valueOf(1.1))
                .build();

        String json = new ObjectMapper().writeValueAsString(mapper);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isOk());
    }
}
