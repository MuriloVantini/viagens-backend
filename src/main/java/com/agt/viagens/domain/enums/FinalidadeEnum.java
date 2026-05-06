package com.agt.viagens.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum FinalidadeEnum {
    VISITA_TECNICA("Visita Técnica"),
    REUNIAO("Reunião"),
    TREINAMENTO("Treinamento"),
    ENTREGA("Entrega"),
    OUTRO("Outro");

    private final String descricao;

    FinalidadeEnum(String descricao) {
        this.descricao = descricao;
    }

    public static List<String> getDescricoes() {
        return Arrays.stream(values())
                .map(FinalidadeEnum::getDescricao)
                .toList();
    }
}
