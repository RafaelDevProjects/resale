package com.enterprise.resale.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long salaId;
    private String nomeSolicitante;
    private String email;

    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    private String finalidade;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;
}