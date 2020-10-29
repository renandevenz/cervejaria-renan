package com.beerhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CERVEJAS")
public class CervejaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "MARCA", unique = true)
    private String marca;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "PRECO")
    private Double preco;
}
