package com.enterprise.resale.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer capacidade;
    private String localizacao;

    @Enumerated(EnumType.STRING)
    private StatusSala status;

    // getters e setters
}