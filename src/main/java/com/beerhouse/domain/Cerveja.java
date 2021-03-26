package com.beerhouse.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@Setter
public class Cerveja implements Serializable {

    @NotBlank
    private String marca;

    @NotBlank
    private Tipo tipo;

    @NotNull
    private BigDecimal preco;
}
