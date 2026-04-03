package com.enterprise.resale.service;

import com.enterprise.resale.dto.*;
import com.enterprise.resale.mapper.SalaMapper;
import com.enterprise.resale.model.Sala;
import com.enterprise.resale.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public SalaResponseDTO criar(SalaRequestDTO dto) {
        Sala sala = SalaMapper.toEntity(dto);
        Sala salva = repository.save(sala);
        return SalaMapper.toDTO(salva);
    }

    public List<SalaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(SalaMapper::toDTO)
                .toList();
    }
}