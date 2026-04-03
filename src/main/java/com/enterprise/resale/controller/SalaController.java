package com.enterprise.resale.controller;

import com.enterprise.resale.dto.*;
import com.enterprise.resale.service.SalaService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@Tag(name = "Salas", description = "Gerenciamento de salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @Operation(
            summary = "Criar uma nova sala",
            description = "Cria uma sala disponível para reservas"
    )
    @ApiResponse(responseCode = "200", description = "Sala criada com sucesso")
    @PostMapping
    public SalaResponseDTO criar(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados para criação da sala",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Exemplo de Sala",
                                    value = """
                                    {
                                      "nome": "Sala de Reunião A",
                                      "capacidade": 10,
                                      "localizacao": "Andar 2",
                                      "status": "ATIVA"
                                    }
                                    """
                            )
                    )
            )
            @Valid SalaRequestDTO dto
    ) {
        return service.criar(dto);
    }

    @Operation(summary = "Listar salas")
    @GetMapping
    public List<SalaResponseDTO> listar() {
        return service.listar();
    }
}