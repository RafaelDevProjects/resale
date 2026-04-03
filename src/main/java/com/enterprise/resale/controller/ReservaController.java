package com.enterprise.resale.controller;

import com.enterprise.resale.dto.*;
import com.enterprise.resale.service.ReservaService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Tag(name = "Reservas", description = "Gerenciamento de reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    // =========================
    // 🔍 BUSCAR POR ID
    // =========================
    @Operation(
            summary = "Buscar reserva por ID",
            description = "Retorna uma reserva específica pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada")
    })
    @GetMapping("/{id}")
    public ReservaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // =========================
    // ➕ CRIAR RESERVA
    // =========================
    @Operation(
            summary = "Criar reserva",
            description = "Cria uma nova reserva para uma sala existente"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva criada com sucesso"),
            @ApiResponse(responseCode = "409", description = "Conflito de horário ou sala inválida"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ReservaResponseDTO criar(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados da reserva",
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Exemplo de Reserva",
                                    value = """
                                    {
                                      "salaId": 1,
                                      "nomeSolicitante": "Rafael",
                                      "email": "rafael@email.com",
                                      "data": "2026-04-10",
                                      "horaInicio": "10:00:00",
                                      "horaFim": "11:00:00",
                                      "finalidade": "Reunião"
                                    }
                                    """
                            )
                    )
            )
            @Valid ReservaRequestDTO dto
    ) {
        return service.criarReserva(dto);
    }

    // =========================
    // 📄 LISTAR
    // =========================
    @Operation(
            summary = "Listar reservas",
            description = "Retorna todas as reservas cadastradas"
    )
    @GetMapping
    public List<ReservaResponseDTO> listar() {
        return service.listar();
    }

    // =========================
    // ❌ CANCELAR
    // =========================
    @Operation(
            summary = "Cancelar reserva",
            description = "Cancela uma reserva pelo ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva cancelada"),
            @ApiResponse(responseCode = "404", description = "Reserva não encontrada"),
            @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        service.cancelar(id);
    }
}