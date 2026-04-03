package com.enterprise.resale.service;

import com.enterprise.resale.dto.ReservaRequestDTO;
import com.enterprise.resale.dto.ReservaResponseDTO;
import com.enterprise.resale.mapper.ReservaMapper;
import com.enterprise.resale.model.*;
import com.enterprise.resale.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;

    public ReservaService(ReservaRepository reservaRepository, SalaRepository salaRepository) {
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
    }

    public ReservaResponseDTO criarReserva(ReservaRequestDTO dto) {

        Reserva reserva = ReservaMapper.toEntity(dto);

        Sala sala = salaRepository.findById(reserva.getSalaId())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        if (sala.getStatus() == StatusSala.INATIVA) {
            throw new RuntimeException("Sala inativa");
        }

        if (reserva.getHoraFim().isBefore(reserva.getHoraInicio())) {
            throw new RuntimeException("Horário inválido");
        }

        boolean conflito = reservaRepository.existsConflito(
                reserva.getSalaId(),
                reserva.getData(),
                reserva.getHoraInicio(),
                reserva.getHoraFim()
        );

        if (conflito) {
            throw new RuntimeException("Conflito de horário");
        }

        reserva.setStatus(StatusReserva.ATIVA);

        Reserva salva = reservaRepository.save(reserva);

        return ReservaMapper.toDTO(salva);
    }

    public List<ReservaResponseDTO> listar() {
        return reservaRepository.findAll()
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();
    }

    public void cancelar(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setStatus(StatusReserva.CANCELADA);
        reservaRepository.save(reserva);
    }

    public ReservaResponseDTO buscarPorId(Long id) {

        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return ReservaMapper.toDTO(reserva);
    }
}