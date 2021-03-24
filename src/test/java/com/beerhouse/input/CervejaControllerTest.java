package com.beerhouse.input;

import com.beerhouse.output.adapter.mapper.CervejaMapper;
import com.beerhouse.application.service.CervejaService;
import com.beerhouse.output.adapter.entity.CervejaEntity;
import com.beerhouse.application.domain.Cerveja;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class CervejaControllerTest {

    static String API = "/craftbeer";

    @Autowired
    MockMvc mockMvc;

    @Mock
    CervejaService cervejaService;

    @Test
    @DisplayName("Deve salvar um produto com sucesso")
    public void criarProdutoTest() throws Exception {

        Cerveja cerveja = Cerveja.builder()
                .marca("Itaipava")
                .tipo("Pilsen")
                .preco(1.1)
                .build();

        CervejaEntity mapper = CervejaMapper.convert(cerveja);

//        BDDMockito.given(cervejaService.salvar(Mockito.any(Cerveja.class))).willReturn(mapper);

        String json = new ObjectMapper().writeValueAsString(mapper);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isCreated());
    }
}
