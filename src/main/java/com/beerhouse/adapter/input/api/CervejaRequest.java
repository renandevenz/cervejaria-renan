package com.beerhouse.adapter.input.api;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Builder
public class CervejaRequest {

    @NotBlank
    private String marca;

    @NotBlank
    private String tipo;

    @NotNull
    private BigDecimal preco;
}
