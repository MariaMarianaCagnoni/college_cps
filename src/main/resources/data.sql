VALUES (40, 'Software', now(), 'Desenvolvimento de aplicações web com Angular', 'Angular', 3);
INSERT INTO curso (carga_horaria, categoria, data_cadastro, descricao, nome, professor_id)
VALUES (40, 'Software', now(), 'Desenvolvimento de aplicações web com NestJS', 'NestJS', 4);

-- Cria turmas
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T01', now(), '2022-12-01', 1);
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T02', now(), '2022-12-10', 2);
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T03', now(), '2022-12-01', 3);
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T04', now(), '2022-12-10', 4);

-- Cria alunos
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno1@email.com', now(), 'Aluno 01', 1);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno2@email.com', now(), 'Aluno 02', 1);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno3@email.com', now(), 'Aluno 03', 2);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno4@email.com', now(), 'Aluno 04', 2);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno5@email.com', now(), 'Aluno 05', 3);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno6@email.com', now(), 'Aluno 06', 3);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno7@email.com', now(), 'Aluno 07', 3);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno8@email.com', now(), 'Aluno 08', 4);VALUES (40, 'Software', now(), 'Desenvolvimento de aplicações web com Angular', 'Angular', 3);
INSERT INTO curso (carga_horaria, categoria, data_cadastro, descricao, nome, professor_id)
VALUES (40, 'Software', now(), 'Desenvolvimento de aplicações web com NestJS', 'NestJS', 4);

-- Cria turmas
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T01', now(), '2022-12-01', 1);
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T02', now(), '2022-12-10', 2);
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T03', now(), '2022-12-01', 3);
INSERT INTO turma (codigo, data_cadastro, data_inicio, curso)
VALUES ('T04', now(), '2022-12-10', 4);

-- Cria alunos
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno1@email.com', now(), 'Aluno 01', 1);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno2@email.com', now(), 'Aluno 02', 1);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno3@email.com', now(), 'Aluno 03', 2);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno4@email.com', now(), 'Aluno 04', 2);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno5@email.com', now(), 'Aluno 05', 3);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno6@email.com', now(), 'Aluno 06', 3);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno7@email.com', now(), 'Aluno 07', 3);
INSERT INTO aluno (contato, data_cadastro, nome, turma)
VALUES ('aluno8@email.com', now(), 'Aluno 08', 4);