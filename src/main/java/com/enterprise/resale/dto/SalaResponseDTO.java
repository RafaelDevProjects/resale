package com.enterprise.resale.dto;

import lombok.Data;

@Data
public class SalaResponseDTO {

    private Long id;
    private String nome;
    private Integer capacidade;
    private String localizacao;
    private String status;

    // getters e setters
}