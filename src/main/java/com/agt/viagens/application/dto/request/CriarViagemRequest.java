package com.agt.viagens.application.dto.request;

import com.agt.viagens.domain.enums.FinalidadeEnum;
import com.agt.viagens.domain.enums.TransporteEnum;
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
        FinalidadeEnum finalidade,

        @NotNull(message = "Transporte é obrigatório")
        TransporteEnum transporte,

        String observacoes
) {}
