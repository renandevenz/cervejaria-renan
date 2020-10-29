package com.beerhouse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cerveja {

    @NotBlank
    private String marca;

    @NotBlank
    private String tipo;

    @NotNull
    private Double preco;
}
