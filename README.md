# 📌 API de Reserva de Salas

API REST desenvolvida em **Spring Boot** para gerenciamento de salas e reservas corporativas.

O sistema permite:

* Criar e listar salas
* Criar, listar e cancelar reservas
* Validar conflitos de horário
* Controlar status de salas e reservas
* Testar endpoints via Swagger UI

---

# 🚀 Tecnologias Utilizadas

* Java 21+
* Spring Boot 3.x
* Spring Web
* Spring Data JPA
* Spring Security (Basic Auth)
* H2 Database (memória)
* Swagger / OpenAPI (springdoc)
* Lombok

---

# 📂 Estrutura do Projeto

```
com.enterprise.resale
│
├── controller     → Endpoints da API
├── service        → Regras de negócio
├── repository     → Acesso ao banco
├── model          → Entidades JPA
├── dto            → Objetos de transferência
├── mapper         → Conversão Entity ↔ DTO
├── config         → Configurações (Swagger / Security)
```

---

# ⚙️ Como Rodar o Projeto

## 📌 Pré-requisitos

* Java 21+
* Maven instalado

---

## ▶️ Executar via terminal

```bash
mvn clean install
mvn spring-boot:run
```

---

## ▶️ Executar pela IDE

* Abrir projeto no IntelliJ ou VS Code
* Rodar a classe:

```
ResaleApplication.java
```

---

# 🌐 Acessos da Aplicação

| Recurso      | URL                                   |
| ------------ | ------------------------------------- |
| API          | http://localhost:8080                 |
| Swagger UI   | http://localhost:8080/swagger-ui.html |
| OpenAPI JSON | http://localhost:8080/v3/api-docs     |
| H2 Console   | http://localhost:8080/h2-console      |

---

# 🔐 Autenticação

A API usa **Basic Auth**.

Ao iniciar, o Spring gera um usuário:

```
username: user
password: (ver no console ao iniciar)
```

Exemplo no log:

```
Using generated security password: 1234-xxxx-xxxx
```

---

## 🔑 Como autenticar no Swagger

1. Clique em **Authorize**
2. Digite:

```
user
senha_do_console
```

3. Clique em Authorize

---

# 📌 Fluxo de Teste (PASSO A PASSO)

## 1️⃣ Criar uma Sala

### POST `/salas`

```json
{
  "nome": "Sala Reunião A",
  "capacidade": 10,
  "localizacao": "Andar 2",
  "status": "ATIVA"
}
```

---

## 2️⃣ Listar Salas

### GET `/salas`

---

## 3️⃣ Criar Reserva

### POST `/reservas`

```json
{
  "salaId": 1,
  "nomeSolicitante": "Rafael",
  "email": "rafael@email.com",
  "data": "2026-04-10",
  "horaInicio": "10:00:00",
  "horaFim": "11:00:00",
  "finalidade": "Reunião"
}
```

---

## 4️⃣ Listar Reservas

### GET `/reservas`

---

## 5️⃣ Cancelar Reserva

### DELETE `/reservas/{id}`

---

# ⚠️ Regras de Negócio

* ❌ Não é possível reservar sala inexistente
* ❌ Não é possível reservar sala INATIVA
* ❌ Hora fim não pode ser menor que hora início
* ❌ Não pode haver conflito de horários
* ✔ Reserva inicia com status **ATIVA**
* ✔ Cancelamento altera status para **CANCELADA**

---

# 🧪 Possíveis Erros

| Código | Motivo                                     |
| ------ | ------------------------------------------ |
| 400    | Dados inválidos                            |
| 409    | Conflito de horário ou sala não encontrada |
| 401    | Não autenticado                            |

---

# 🗄️ Banco de Dados (H2)

Configuração padrão:

```
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vazio)
```

---

# 📌 Melhorias Futuras

* 🔐 Autenticação com JWT
* 📊 Logs estruturados
* 🧠 Tratamento global de exceções
* 📦 Dockerização
* 📈 Monitoramento (Actuator)

---

# 👨‍💻 Autores

| Nome | RM |
|------|----|
| Rafael De Almeida Sigoli | RM554019 |
| Giovanna Franco Gaudino Rodrigues | RM553701 |
| [NOME 3] | [RM] |


---
