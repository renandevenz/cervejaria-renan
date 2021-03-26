package com.beerhouse.adapter.input.api;

import com.beerhouse.adapter.input.FindAllCervejaAdapter;
import com.beerhouse.adapter.output.CervejaReadAdapter;
import com.beerhouse.domain.Cerveja;
import com.beerhouse.exception.BaseException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/craftbeer")
@Log
@RequiredArgsConstructor
@Api(value = "API Cervejas artesanais do Renan")
public class CervejaControllerAdapter {

    private final FindAllCervejaAdapter allCervejaAdapter;
    private final CervejaReadAdapter readAdapter;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<CervejaRequest> listarProdutos() {

        return allCervejaAdapter.collect();
    }

    @GetMapping("/{marca}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cerveja> buscarPorMarca(@PathVariable String marca) {

        return Optional.ofNullable(readAdapter.buscarPorMarca(marca).orElseThrow(BaseException::new));
    }

}
