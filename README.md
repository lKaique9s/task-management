# 🎯 Task Manager

[![Status](https://img.shields.io/badge/Status-Finalizado-success)](README.md)
[![Java](https://img.shields.io/badge/Java-17%20%7C%2021-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.2-brightgreen)](https://spring.io/projects/spring-boot)
[![Postman](https://img.shields.io/badge/Tested%20with-Postman-orange)](https://www.postman.com/)

> **Projeto Finalizado!** 🎉  
> Este projeto foi desenvolvido com o propósito de colocar em prática os conhecimentos que venho estudando em **Java**, **Programação Orientada a Objetos (POO)**, **Clean Code**, **padrões de projeto** e representa um marco importante nos meus estudos: **a construção da minha primeira API REST**! 🚀

---

## 📌 Sobre o Projeto

O objetivo principal deste projeto foi vivenciar na prática a evolução do desenvolvimento de software em Java:
1. **Primeiro passo (Módulo Core - Java Puro):** Criação de uma aplicação de console com domínio rico, regras de transição de estado, desacoplamento por meio do padrão *Repository*, injeção de dependências e tratamento de exceções customizadas.
2. **Segundo passo (Módulo Web - Primeira API REST):** Evolução para uma API HTTP completa desenvolvida com **Spring Boot**, implementando arquitetura em camadas (*Controller*, *Service*, *DTO*, *Model*), operações de CRUD completas, validações de requisição com *Bean Validation* e tratamento semântico de erros com `@ExceptionHandler`.
3. **Validação e Testes:** Utilização do **Postman** para simular, testar e validar o funcionamento de todas as requisições HTTP da API.

---

## 📁 Estrutura do Repositório

```text
task/
├── postman/                                     # Coleção e configurações do Postman para testes da API
│   └── collections/
│       └── New Collection/
│           └── New Request.request.yaml
├── taskmanager/                                 # MÓDULO 1: Java Puro (Console / POO)
│   └── src/taskmanager/
│       ├── Main.java                            # Classe principal para execução e teste no console
│       ├── Tarefa.java                          # Entidade de domínio (validações e máquina de estados)
│       ├── StatusTarefa.java                    # Enum de estados (PENDENTE, EM_ANDAMENTO, CONCLUIDA)
│       ├── TarefaRepository.java               # Interface do repositório (abstração de dados)
│       ├── TarefaRepositoryHashMap.java        # Repositório em memória usando HashMap
│       ├── GerenciadorTarefas.java              # Camada de serviço / orquestração das regras de negócio
│       └── TarefaNaoEncontradaException.java    # Exceção customizada para tarefas inexistentes
└── task-manager-api/                            # MÓDULO 2: Minha Primeira API REST (Spring Boot)
    └── task-manager-api/
        ├── pom.xml                              # Gerenciamento de dependências com Maven
        ├── mvnw / mvnw.cmd                      # Maven Wrapper
        └── src/
            ├── main/
            │   ├── java/com/taskmanager/
            │   │   ├── TaskManagerApiApplication.java # Classe de inicialização Spring Boot
            │   │   ├── controller/
            │   │   │   └── TarefaController.java       # Controller REST (endpoints e handlers de erro)
            │   │   ├── dto/
            │   │   │   ├── CriarTarefaRequest.java     # DTO de entrada para criação com validações
            │   │   │   ├── AtualizarTarefaRequest.java # DTO de entrada para atualização com validações
            │   │   │   └── ErroResponse.java           # DTO para padronização de respostas de erro
            │   │   ├── model/
            │   │   │   └── Tarefa.java                 # Entidade do modelo de dados
            │   │   └── service/
            │   │       ├── TarefaService.java          # Lógica de negócio e persistência em memória
            │   │       └── TarefaNaoEncontradaException.java # Exceção de negócio (404)
            │   └── resources/
            │       └── application.properties          # Configurações da aplicação
            └── test/
                └── java/com/taskmanager/
                    └── TaskManagerApiApplicationTests.java # Teste de carregamento de contexto Spring
```

---

## 💡 Conceitos Praticados e Aprendizados

Durante o desenvolvimento deste projeto, foram aplicados e consolidados diversos conceitos fundamentais:

- **Programação Orientada a Objetos (POO):** Encapsulamento, atributos imutáveis e geração controlada de IDs, além de métodos de negócio que protegem o estado interno da entidade.
- **Padrão Repository & Injeção de Dependência:** Isolamento da persistência através de interfaces ([`TarefaRepository`](TarefaRepository.java)) e injeção via construtor na camada de serviço ([`GerenciadorTarefas`](GerenciadorTarefas.java)).
- **Arquitetura em Camadas (Spring Boot):**
  - **Controller:** Ponto de entrada das requisições HTTP, definindo rotas, verbos e códigos de status semânticos.
  - **DTO (Data Transfer Object):** Separação clara entre os dados que transitam nas requisições HTTP ([`CriarTarefaRequest`](CriarTarefaRequest.java), [`AtualizarTarefaRequest`](AtualizarTarefaRequest.java)) e a entidade interna [`Tarefa`](Tarefa.java).
  - **Service:** Concentração das regras de negócio e manipulação dos dados.
- **Validação de Dados (Bean Validation):** Aplicação de anotações como `@NotBlank` e `@Valid` para garantir a integridade dos dados enviados pelo cliente.
- **Tratamento Centralizado de Erros:** Uso de anotações `@ExceptionHandler` no [`TarefaController`](TarefaController.java) para capturar exceções (`TarefaNaoEncontradaException`, `MethodArgumentNotValidException`, `IllegalArgumentException`) e retornar respostas padronizadas em JSON com status HTTP correspondentes (`404` e `400`).
- **Testes com Postman:** Uso de cliente HTTP para disparar requisições, inspecionar headers (`Location`), validar status codes e verificar os corpos das respostas.

---

## 📡 Endpoints da API REST (Primeira API)

A API disponibiliza operações completas de CRUD (Create, Read, Update, Delete) em `http://localhost:8080/tarefas`.

| Método | Rota | Descrição | Status de Sucesso | Status de Erro |
|---|---|---|---|---|
| `GET` | `/tarefas` | Retorna todas as tarefas cadastradas | `200 OK` | - |
| `GET` | `/tarefas/{id}` | Busca os detalhes de uma tarefa pelo ID | `200 OK` | `404 Not Found` |
| `POST` | `/tarefas` | Cadastra uma nova tarefa | `201 Created` | `400 Bad Request` |
| `PUT` | `/tarefas/{id}` | Atualiza uma tarefa existente | `200 OK` | `400 Bad Request` / `404 Not Found` |
| `DELETE` | `/tarefas/{id}` | Remove uma tarefa pelo ID | `204 No Content` | `404 Not Found` |

### Exemplos de Requisições e Respostas

#### 1. Criar Tarefa (`POST /tarefas`)
- **Body (JSON):**
  ```json
  {
    "titulo": "Estudar Spring Boot",
    "conteudo": "Aprender a criar uma API REST"
  }
  ```
- **Resposta (`201 Created`):**
  - **Header:** `Location: /tarefas/4`
  - **Body:**
    ```json
    {
      "id": 4,
      "titulo": "Estudar Spring Boot",
      "conteudo": "Aprender a criar uma API REST"
    }
    ```

#### 2. Atualizar Tarefa (`PUT /tarefas/{id}`)
- **Body (JSON):**
  ```json
  {
    "titulo": "Estudar Spring Boot e Postman",
    "conteudo": "Praticar envio de requisições e validações de API"
  }
  ```
- **Resposta (`200 OK`):**
  ```json
  {
    "id": 1,
    "titulo": "Estudar Spring Boot e Postman",
    "conteudo": "Praticar envio de requisições e validações de API"
  }
  ```

#### 3. Remover Tarefa (`DELETE /tarefas/{id}`)
- **Resposta (`204 No Content`)**: Sem corpo, confirmando a exclusão do recurso.

#### 4. Resposta de Erro (Exemplo: Validação ou Tarefa Não Encontrada)
Quando um campo obrigatório não é enviado ou a tarefa não existe, o sistema retorna uma resposta amigável estruturada pelo [`ErroResponse`](ErroResponse.java):
```json
{
  "mensagem": "must not be blank"
}
```
ou
```json
{
  "mensagem": "Tarefa nao foi encontrada!"
}
```

---

## 📮 Testando com o Postman

Todas as requisições HTTP foram testadas e validadas através do **Postman**:
1. Inicie a API Spring Boot (conforme as instruções abaixo).
2. Abra o **Postman** e importe os arquivos presentes na pasta `postman/` ou crie uma coleção apontando para a base `http://localhost:8080`.
3. Teste os fluxos:
   - Listar todas as tarefas (`GET /tarefas`).
   - Criar uma nova tarefa (`POST /tarefas`) e verificar o header `Location`.
   - Consultar a tarefa recém-criada (`GET /tarefas/{id}`).
   - Modificar os dados da tarefa (`PUT /tarefas/{id}`).
   - Tentar criar tarefas com campos vazios para observar as respostas de erro `400 Bad Request`.
   - Excluir a tarefa (`DELETE /tarefas/{id}`) e verificar o status `204 No Content`.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17 / 21
- **Framework Web:** Spring Boot (Spring Web MVC)
- **Validação:** Jakarta Bean Validation (`spring-boot-starter-validation`)
- **Gerenciador de Dependências:** Maven (com Maven Wrapper)
- **Cliente de Testes HTTP:** Postman
- **Controle de Versão:** Git & GitHub
- **IDE:** Visual Studio Code

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- **Java JDK 17** ou superior instalado.
- **Git** instalado.

### 1. Executando o Módulo Java Puro (`taskmanager`)
```bash
# A partir da raiz do repositório:
cd taskmanager/src
javac taskmanager/*.java
java taskmanager.Main
```

### 2. Executando a API REST (`task-manager-api`)
```powershell
# No Windows (PowerShell / CMD):
cd task-manager-api/task-manager-api
.\mvnw.cmd spring-boot:run
```

```bash
# No Linux / macOS:
cd task-manager-api/task-manager-api
./mvnw spring-boot:run
```

A API estará acessível em: `http://localhost:8080/tarefas`.

---

## ✅ Conclusão

Este projeto cumpre integralmente a proposta inicial de estudo: partir do Java puro, construir uma base sólida em orientação a objetos e padrões arquiteturais, e culminar na entrega de uma **API REST funcional, testada e documentada**. 🎓
