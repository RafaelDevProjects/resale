package com.enterprise.resale.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SalaRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Capacidade é obrigatória")
    @Min(value = 1, message = "Capacidade deve ser maior que 0")
    private Integer capacidade;

    @NotBlank(message = "Localização é obrigatória")
    private String localizacao;

    @NotNull(message = "Status é obrigatório")
    private String status;

    // getters e setters
}