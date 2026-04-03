package com.enterprise.resale.controller;

import com.enterprise.resale.dto.*;
import com.enterprise.resale.service.ReservaService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
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

    @Operation(
            summary = "Criar reserva",
            description = "Cria uma nova reserva para uma sala existente"
    )
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

    @Operation(summary = "Listar reservas")
    @GetMapping
    public List<ReservaResponseDTO> listar() {
        return service.listar();
    }
}