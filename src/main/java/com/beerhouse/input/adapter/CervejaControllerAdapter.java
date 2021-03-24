package com.beerhouse.input.adapter;

import com.beerhouse.application.domain.Cerveja;
import com.beerhouse.application.usecase.BuscarUseCase;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/craftbeer")
@Slf4j
@RequiredArgsConstructor
@Api(value = "API Cervejas artesanais do Renan")
public class CervejaControllerAdapter {

    private final BuscarUseCase useCase;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void consultarProduto(@RequestBody @Valid Cerveja cerveja) {
        log.info("Produto: " + cerveja);
        useCase.buscarProduto(cerveja);
    }

}
