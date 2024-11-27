CREATE TABLE pessoas
(
    id              SERIAL PRIMARY KEY,
    nome            VARCHAR(255) NOT NULL,
    sobrenome       VARCHAR(255),
    cpf             VARCHAR(15)  NOT NULL,
    email           VARCHAR(255) NOT NULL,
    numerocelular   VARCHAR(15),
    dataaniversario DATE,
    dataintegracao  DATE         NOT NULL,
    curso           VARCHAR(50)  NOT NULL
);