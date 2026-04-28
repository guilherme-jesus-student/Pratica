# 💅 Espaço Ka - Sistema de Agendamento

Sistema de gestão para salões de manicure com foco em **automação de processos**, **regras de negócio reais** e **prevenção de conflitos de agenda**.  
Desenvolvido com **Spring Boot 3**, seguindo boas práticas de arquitetura em camadas.

---

## 🚀 Funcionalidades

### 👤 Gestão de Clientes
- Cadastro completo de clientes
- Validação de e-mail único
- Busca por nome e e-mail

### 🎁 Regras de Fidelização
- Desconto automático para clientes aniversariantes do mês

### 📅 Agendamento Inteligente
- Validação de horário de funcionamento (08h às 19h)
- Bloqueio de agendamentos em horários passados
- Prevenção de conflitos (um profissional não pode ter dois agendamentos no mesmo horário)

### 🤖 Automação
- Rotina executada a cada 10 minutos
- Cancelamento automático de agendamentos com mais de 20 minutos de atraso

---

## 🧠 Regras de Negócio Aplicadas

- Validação de data e hora em tempo real
- Controle de conflitos de agenda (anti double booking)
- Regras automáticas de cancelamento
- Lógica de fidelização de clientes

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Maven
- Lombok

---

## 🏗️ Arquitetura

- **Controller:** exposição dos endpoints REST
- **Service:** regras de negócio
- **Repository:** acesso ao banco de dados
- **DTO:** transporte seguro de dados
- **Entity/Model:** estrutura das entidades

---

## 🔗 Endpoints

### Clientes

```http
POST /clientes
GET /clientes
GET /clientes/{id}
GET /clientes?page=0&size=10
GET /clientes/email?email=example@email.com
GET /clientes/nome?nome=Maria
GET /clientes/{id}/desconto
DELETE /clientes/{id}```

