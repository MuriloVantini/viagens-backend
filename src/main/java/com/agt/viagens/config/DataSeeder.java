package com.agt.viagens.config;

import com.agt.viagens.domain.enums.FinalidadeEnum;
import com.agt.viagens.domain.enums.TransporteEnum;
import com.agt.viagens.domain.model.StatusViagem;
import com.agt.viagens.domain.model.Usuario;
import com.agt.viagens.domain.model.Viagem;
import com.agt.viagens.domain.port.UsuarioPort;
import com.agt.viagens.domain.port.ViagemPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataSeeder implements ApplicationRunner {

    private final UsuarioPort     usuarioPort;
    private final ViagemPort      viagemPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        if (usuarioPort.buscarPorUsername("usuario.teste").isPresent()) return;

        Usuario usuario = usuarioPort.salvar(
                Usuario.builder()
                        .username("usuario.teste")
                        .password(passwordEncoder.encode("senha123"))
                        .build()
        );

        viagemPort.salvar(Viagem.builder()
                .destino("São Paulo - SP")
                .dataIda(LocalDate.now().plusDays(10))
                .dataVolta(LocalDate.now().plusDays(12))
                .finalidade(FinalidadeEnum.REUNIAO)
                .transporte(TransporteEnum.AEREO)
                .observacoes("Levar apresentação atualizada")
                .status(StatusViagem.AGENDADA)
                .usuario(usuario)
                .build());

        viagemPort.salvar(Viagem.builder()
                .destino("Campinas - SP")
                .dataIda(LocalDate.now().minusDays(10))
                .dataVolta(LocalDate.now().minusDays(9))
                .finalidade(FinalidadeEnum.TREINAMENTO)
                .transporte(TransporteEnum.CARRO_EMPRESA)
                .status(StatusViagem.CONCLUIDA)
                .usuario(usuario)
                .build());

        viagemPort.salvar(Viagem.builder()
                .destino("Ribeirão Preto - SP")
                .dataIda(LocalDate.now().minusDays(2))
                .dataVolta(LocalDate.now().plusDays(1))
                .finalidade(FinalidadeEnum.VISITA_TECNICA)
                .transporte(TransporteEnum.CARRO_PROPRIO)
                .status(StatusViagem.EM_ANDAMENTO)
                .usuario(usuario)
                .build());

        log.info("=============================================================");
        log.info("  Seed concluído — usuário de teste criado: usuario.teste");
        log.info("  Swagger UI  → http://localhost:8080/swagger-ui.html");
        log.info("  Para H2 Console, inicie com perfil dev:");
        log.info("  mvn spring-boot:run -Dspring-boot.run.profiles=dev");
        log.info("=============================================================");
    }
}
