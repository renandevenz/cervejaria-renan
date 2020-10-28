package com.beerhouse.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Cerveja {

    private String marca;
    private String tipo;
    private BigDecimal preco;
}
