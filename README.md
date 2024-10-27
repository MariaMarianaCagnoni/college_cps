# Projeto: Sistema de Faculdade

## Resumo

Sistema de gerenciamento de cursos, com professores, alunos e turmas.

### Professor

Professores são cadastrados no sistema e associados aos vários cursos que podem ministrar.

#### Entity

- id
- nome
- data de cadastro (LocalDateTime) *
- ativo (se o cadastro está ativo)

#### API

- GET /api/professores (todos e por nome) /api/professores?nome=*nome*
- GET /api/professores/:id/cursos
- POST /api/professores (CreateProfessorDTO)
- PUT /api/professores/:id
- DELETE /api/professores/:id (Não deixar deletar se tiver cursos associados)

### Cursos

Cursos sempre terão um professor responsável e podem ter várias turmas.

#### Entity

- id
- nome
- descricao
- categoria
- carga horaria
- data de cadastro (LocalDateTime) *
- **professor**

#### API

- GET /api/cursos (todos e por nome) - CursoDTO
- GET /api/cursos/:id/turmas
- POST /api/cursos
- PUT /api/cursos/:id - UpdateCursoDTO
- DELETE /api/cursos/:id (Não deixa deletar se tiver turmas associadas)

### Turma

As turmas de um curso têm vários alunos inscritos.

#### Entity

- id
- codigo
- data inicio
- data de cadastro (LocalDateTime) *
- **curso**

#### API

- GET /api/turmas
- GET /api/turmas/:id/alunos
- POST /api/turmas
- PUT /api/turmas/:id
- DELETE /api/turmas/:id (Ao deletar, remover associação do Aluno)

### Aluno

Os alunos  pertencem somente a uma turma.

#### Entity

- id
- nome
- contato
- data de cadastro (LocalDateTime) *
- **turma**

#### API

- GET /api/alunos
- POST /api/alunos
- PUT /api/alunos/:id
- DELETE /api/alunos/:id

## Arquitetura

Monolito MVC


HTTP -> DTO <-> Controller <-> Mapper (DTO/Entity) <-> Service <-> Repository


## Model Mapper
utilizado para mapeat DTO para Entity e vs.

http://modelmapper.org/

## DER

![DER](C:\Users\maria\OneDrive\Desktop\projeto-final-spring-boot-main\MER.png)