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
@Tag(
        name = "Salas",
        description = "Endpoints responsáveis pelo gerenciamento de salas disponíveis para reserva"
)
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @Operation(
            summary = "Criar uma nova sala",
            description = """
                    Cria uma nova sala no sistema.
                    
                    Regras:
                    - O nome deve ser preenchido
                    - A capacidade deve ser maior que zero
                    - O status pode ser ATIVA ou INATIVA
                    
                    Use este endpoint antes de criar reservas.
                    """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sala criada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SalaResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    @PostMapping
    public SalaResponseDTO criar(
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "JSON para criação da sala",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "Sala pequena",
                                            summary = "Exemplo básico",
                                            value = """
                                                    {
                                                      "nome": "Sala Reunião A",
                                                      "capacidade": 5,
                                                      "localizacao": "Andar 1",
                                                      "status": "ATIVA"
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "Sala grande",
                                            summary = "Sala corporativa",
                                            value = """
                                                    {
                                                      "nome": "Auditório Principal",
                                                      "capacidade": 50,
                                                      "localizacao": "Andar 3",
                                                      "status": "ATIVA"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
            @Valid SalaRequestDTO dto
    ) {
        return service.criar(dto);
    }

    @Operation(
            summary = "Listar salas",
            description = "Retorna todas as salas cadastradas no sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = SalaResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    @GetMapping
    public List<SalaResponseDTO> listar() {
        return service.listar();
    }
}