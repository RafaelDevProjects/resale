package com.enterprise.resale.mapper;

import com.enterprise.resale.dto.*;
import com.enterprise.resale.model.Reserva;
import com.enterprise.resale.model.Sala;

public class ReservaMapper {

    public static Reserva toEntity(ReservaRequestDTO dto) {
        Reserva r = new Reserva();

        r.setSalaId(dto.getSalaId()); // ✅ CORRETO

        r.setNomeSolicitante(dto.getNomeSolicitante());
        r.setEmail(dto.getEmail());
        r.setData(dto.getData());
        r.setHoraInicio(dto.getHoraInicio());
        r.setHoraFim(dto.getHoraFim());
        r.setFinalidade(dto.getFinalidade());

        return r;
    }

    public static ReservaResponseDTO toDTO(Reserva r) {
        ReservaResponseDTO dto = new ReservaResponseDTO();
        dto.setId(r.getId());
        dto.setSalaId(r.getSalaId());
        dto.setNomeSolicitante(r.getNomeSolicitante());
        dto.setEmail(r.getEmail());
        dto.setData(r.getData());
        dto.setHoraInicio(r.getHoraInicio());
        dto.setHoraFim(r.getHoraFim());
        dto.setFinalidade(r.getFinalidade());
        dto.setStatus(r.getStatus());
        return dto;
    }
}