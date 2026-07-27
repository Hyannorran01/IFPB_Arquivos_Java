CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    matricula VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO aluno(nome, matricula)
VALUES
    ('MARIA','00001'),
    ('JOÃO','00002'),
    ('MARIO','00003'),
    ('FELIPE','00004'),
    ('JOSÉ','00005'),
    ('ANA','00006'),
    ('MARIA SILVA','00007');


CREATE TABLE endereco (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          rua VARCHAR(255) NOT NULL,
                          cidade VARCHAR(100) NOT NULL,
                          aluno_id BIGINT NOT NULL, -- Chave estrangeira
                          FOREIGN KEY (aluno_id) REFERENCES aluno(id) -- Define o relacionamento
);


INSERT INTO endereco(RUA, CIDADE, ALUNO_ID)
VALUES
    ('TESTE','CAMPINA GRANDE',1),
    ('TESTE IFPB','CAMPINA GRANDE',2);

CREATE TABLE turma (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL

     );
INSERT INTO TURMA(nome)
VALUES
    ('turma 1')
