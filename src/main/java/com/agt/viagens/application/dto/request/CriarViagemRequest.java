package com.agt.viagens.application.dto.request;

import com.agt.viagens.domain.enums.FinalidadeEnum;
import com.agt.viagens.domain.enums.TransporteEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CriarViagemRequest(
        @NotBlank(message = "Destino é obrigatório")
        String destino,

        @NotNull(message  = "Data de ida é obrigatória")
        LocalDate dataIda,

        @NotNull(message  = "Data de volta é obrigatória")
        LocalDate dataVolta,

        @NotNull(message = "Finalidade é obrigatória")
        @Schema(description = "Finalidade da viagem", allowableValues = {"VISITA_TECNICA", "REUNIAO", "TREINAMENTO", "ENTREGA", "OUTRO"}, example = "VISITA_TECNICA")
        FinalidadeEnum finalidade,

        @NotNull(message = "Transporte é obrigatório")
        @Schema(description = "Meio de transporte", allowableValues = {"CARRO_PROPRIO", "CARRO_EMPRESA", "AEREO", "ONIBUS"}, example = "CARRO_PROPRIO")
        TransporteEnum transporte,

        String observacoes
) {}
