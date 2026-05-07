# viagens-backend

Backend scaffold do desafio técnico AGT — **Controle de Viagens Corporativas**.

## Pré-requisitos

- Java 21+
- Maven 3.9+

Sem banco externo — usa H2 em memória, sobe com um comando.


## Como rodar

```bash
.\mvnw spring-boot:run "-Dspring-boot.run.profiles=dev"
```

ou via IDE: executar a classe `ViagemBackendApplication`.

Aguarde a linha no console:

```
Seed concluído — usuário de teste criado: usuario.teste
```

---

## URLs após subir

| Recurso    | URL                                      |
|------------|------------------------------------------|
| Swagger UI | http://localhost:8080/swagger-ui.html    |
| API base   | http://localhost:8080                    |

> **H2 Console** disponível apenas com perfil dev:
> `./mvnw spring-boot:run -Dspring-boot.run.profiles=dev`
> → http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:viagens`, usuário: `sa`, senha: vazia)

---

## Credencial de teste

| Campo    | Valor           |
|----------|-----------------|
| username | `usuario.teste` |
| password | `senha123`      |


---

