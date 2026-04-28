#  Espaço Ka - Sistema de Agendamento Prática

Este é um sistema robusto de gestão para salões de manicure, desenvolvido com **Spring Boot 3**. O projeto foi evoluído de um CRUD básico para uma aplicação com regras de negócio reais, focado em automação e experiência do cliente.

---

## 🚀 Funcionalidades Principais

* **Gestão de Clientes:** Cadastro completo com validação de e-mail único e busca por nome/e-mail.
* **Regras de Fidelização:** Verificação automática de desconto para clientes aniversariantes do mês.
* **Agendamento Inteligente:** * Validação de horário de funcionamento (08h às 19h).
    * Bloqueio de agendamentos em horários passados.
    * **Prevenção de Conflitos:** O sistema impede que um profissional tenha dois agendamentos no mesmo horário.
*  Automação (Scheduling):** Robô que monitora o banco de dados a cada 10 minutos e cancela automaticamente agendamentos com mais de 20 minutos de atraso.

---

# Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência de dados)
* **H2 Database** (Banco de dados em memória para desenvolvimento)
* **Maven** (Gerenciador de dependências)
* **Lombok** (Produtividade no código)

---

## 🏗️ Arquitetura do Projeto

O projeto segue as melhores práticas de desenvolvimento, com separação clara de responsabilidades:

1.  **Controller:** Exposição dos endpoints REST.
2.  **Service:** Camada onde reside toda a inteligência e regras de negócio do salão.
3.  **Repository:** Interface de comunicação com o banco de dados via JPA.
4.  **DTO (Data Transfer Object):** Segurança e performance no tráfego de dados.
5.  **Model/Entity:** Representação das tabelas do banco e estados (Enums).

---

## 🏁 Como Executar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/guilherme-jesus-student/Pratica.git](https://github.com/guilherme-jesus-student/Pratica.git)
