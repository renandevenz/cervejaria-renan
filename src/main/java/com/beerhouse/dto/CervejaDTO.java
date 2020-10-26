package com.beerhouse.dto;

import com.beerhouse.domain.Cerveja;

import java.math.BigDecimal;

public class CervejaDTO {

    private String marca;
    private String tipo;
    private int quantidade;
    private BigDecimal preco;

    public Cerveja cervejaMapper() {
        return new Cerveja(marca, tipo, quantidade, preco);
    }
}
