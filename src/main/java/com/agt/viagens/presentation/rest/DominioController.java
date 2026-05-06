package com.agt.viagens.presentation.rest;

import com.agt.viagens.domain.enums.FinalidadeEnum;
import com.agt.viagens.domain.enums.TransporteEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dominios")
@Tag(name = "Domínios", description = "Valores de domínio para preenchimento de formulários")
@SecurityRequirement(name = "bearerAuth")
public class DominioController {

    @GetMapping("/finalidades")
    @Operation(summary = "Lista as finalidades disponíveis para registro de viagem")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autenticado")
    })
    public ResponseEntity<List<String>> finalidades() {
        return ResponseEntity.ok(FinalidadeEnum.getDescricoes());
    }

    @GetMapping("/transportes")
    @Operation(summary = "Lista os meios de transporte disponíveis para registro de viagem")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autenticado")
    })
    public ResponseEntity<List<String>> transportes() {
        return ResponseEntity.ok(TransporteEnum.getDescricoes());
    }
}
