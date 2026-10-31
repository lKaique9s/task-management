# Task Manager API

Projeto desenvolvido em Java com o objetivo de praticar e consolidar conhecimentos em Programação Orientada a Objetos, boas práticas de desenvolvimento e construção de APIs REST.

A proposta é desenvolver um gerenciador de tarefas, começando com Java puro e evoluindo gradualmente para uma aplicação capaz de disponibilizar suas funcionalidades por meio de uma API HTTP.

## Objetivos

- Consolidar conceitos de Java e Programação Orientada a Objetos.
- Desenvolver maior autonomia na modelagem e implementação de software.
- Aplicar princípios SOLID e Clean Code.
- Aprender a desenvolver APIs REST.
- Trabalhar com testes automatizados e persistência de dados.

## Funcionalidades planejadas

- [ ] Criar tarefas.
- [ ] Listar todas as tarefas.
- [ ] Buscar tarefa por ID.
- [ ] Atualizar informações de uma tarefa.
- [ ] Excluir tarefas.
- [ ] Alterar o estado de uma tarefa.
- [ ] Disponibilizar operações por meio de uma API REST.
- [ ] Implementar persistência em banco de dados.
- [ ] Desenvolver testes automatizados.

## Tecnologias e ferramentas

- Java 21
- Visual Studio Code
- Git e GitHub
- Spring Boot (etapa futura)
- Banco de dados (etapa futura)

## Modelo inicial

Cada tarefa será representada por uma entidade `Tarefa`, com os seguintes atributos:

| Atributo | Descrição |
|---|---|
| `id` | Identificador único e imutável |
| `titulo` | Título obrigatório da tarefa |
| `conteudo` | Descrição ou detalhes da tarefa |
| `estado` | Situação atual da tarefa |

Os estados serão representados pelo enum `StatusTarefa`:

- `PENDENTE`
- `EM_ANDAMENTO`
- `CONCLUIDA`

Toda tarefa será criada inicialmente com o estado `PENDENTE`.

## Estrutura inicial

```text
task-manager/
├── src/
│   └── taskmanager/
│       ├── Tarefa.java
│       └── StatusTarefa.java
└── README.md
```

## Desenvolvimento

O projeto será desenvolvido incrementalmente. A implementação inicial utilizará Java puro, incorporando novas tecnologias e conceitos conforme a evolução da aplicação.

O foco é desenvolver não apenas uma aplicação funcional, mas também autonomia para projetar, implementar, testar e organizar soluções de software.

---

**Status:** Em desenvolvimento 🚧