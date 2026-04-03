package com.enterprise.resale.dto;

import com.enterprise.resale.model.StatusReserva;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaResponseDTO {

    private Long id;
    private Long salaId;
    private String nomeSolicitante;
    private String email;

    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    private String finalidade;
    private StatusReserva status;

}