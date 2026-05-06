package com.agt.viagens.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum TransporteEnum {
    CARRO_PROPRIO("Carro Próprio"),
    CARRO_EMPRESA("Carro da Empresa"),
    AEREO("Aéreo"),
    ONIBUS("Ônibus");

    private final String descricao;

    TransporteEnum(String descricao) {
        this.descricao = descricao;
    }

    public static List<String> getDescricoes() {
        return Arrays.stream(values())
                .map(TransporteEnum::getDescricao)
                .toList();
    }
}
