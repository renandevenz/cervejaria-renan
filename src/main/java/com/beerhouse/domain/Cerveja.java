package com.beerhouse.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_CERVEJAS")
public class Cerveja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "MARCA", unique = true)
    private String marca;

    @NotBlank
    @Column(name = "TIPO")
    private String tipo;

    @NotNull
    @Column(name = "PRECO")
    private BigDecimal preco;

    public Cerveja(String marca, String tipo, BigDecimal preco) {
    }
}
