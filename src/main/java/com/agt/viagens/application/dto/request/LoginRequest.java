package com.agt.viagens.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Username é obrigatório")
        @Schema(example = "usuario.teste")
        String username,

        @NotBlank(message = "Password é obrigatório")
        @Schema(example = "senha123")
        String password
) {}
