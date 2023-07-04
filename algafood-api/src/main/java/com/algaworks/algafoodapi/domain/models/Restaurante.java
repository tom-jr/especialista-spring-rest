package com.algaworks.algafoodapi.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome", length = 30)
    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;
}
