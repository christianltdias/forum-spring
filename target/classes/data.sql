INSERT INTO USUARIOS(nome, sobrenome, login, email, senha, flg_ativo) VALUES('Christian', 'Leite Dias', 'chris', 'christianltdias@email.com', '$2a$10$HwoTVTWQaJ1aLT9EzL5Bk.wFbjkFxoJqPZPKyNYGJSlTLx3qzrGaW', true);
INSERT INTO USUARIOS(nome, login, senha, flg_ativo) VALUES('Moderador', 'moderador',  '$2a$10$HwoTVTWQaJ1aLT9EzL5Bk.wFbjkFxoJqPZPKyNYGJSlTLx3qzrGaW', true);

INSERT INTO PERFIS(nome) VALUES('ROLE_ALUNO');
INSERT INTO PERFIS(nome) VALUES('ROLE_MODERADOR');

INSERT INTO USUARIOS_PERFIS(usuario_id, perfis_id_perfil) VALUES (1,1);
INSERT INTO USUARIOS_PERFIS(usuario_id, perfis_id_perfil) VALUES (2,2);

INSERT INTO CURSOS(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSOS(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPICOS(titulo, mensagem, data_criacao, status, id_autor, id_curso) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICOS(titulo, mensagem, data_criacao, status, id_autor, id_curso) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICOS(titulo, mensagem, data_criacao, status, id_autor, id_curso) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);