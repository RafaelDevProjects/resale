package com.enterprise.resale.mapper;

import com.enterprise.resale.dto.*;
import com.enterprise.resale.model.*;

public class SalaMapper {

    public static Sala toEntity(SalaRequestDTO dto) {
        Sala sala = new Sala();

        sala.setNome(dto.getNome());
        sala.setCapacidade(dto.getCapacidade());
        sala.setLocalizacao(dto.getLocalizacao());
        sala.setStatus(StatusSala.valueOf(dto.getStatus()));

        return sala;
    }

    public static SalaResponseDTO toDTO(Sala sala) {
        SalaResponseDTO dto = new SalaResponseDTO();

        dto.setId(sala.getId());
        dto.setNome(sala.getNome());
        dto.setCapacidade(sala.getCapacidade());
        dto.setLocalizacao(sala.getLocalizacao());
        dto.setStatus(sala.getStatus().name());

        return dto;
    }
}