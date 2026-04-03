package com.enterprise.resale.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaRequestDTO {

    private Long salaId;
    private String nomeSolicitante;
    private String email;

    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    private String finalidade;
}