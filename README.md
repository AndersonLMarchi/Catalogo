# Catalogo

<h3><b>Tecnologias:</b></h3>

* Banco de Dados: PostgreSQL 13
* Servidor de Aplicação: Apache Tomcat 9.0
* Linguagem de Programação: Java 8 - JDK 15.0.1
* IDE: Apache NetBeans IDE 12.0

<h3><b>Scripts:</b></h3>

* Banco de dados:
  
```
CREATE DATABASE loja
  WITH OWNER = postgres
  ENCODING = 'UTF8'
  LC_COLLATE = 'Portuguese_Brazil.1252'
  LC_CTYPE = 'Portuguese_Brazil.1252'
  TABLESPACE = pg_default;
```

* Schema:

```CREATE SCHEMA app AUTHORIZATION postgres;```

* Tabela:

```
CREATE TABLE app.produtos (
    prodcodigo integer not null,
    prodnome varchar(200) not null,
    prodveiculo varchar(200),
    proddatainclusao date default current_date,
    prodpesoliquido numeric(15,2) not null,
    prodpesobruto numeric(15,2) not null,
    CONSTRAINT check_peso_produtos CHECK (prodpesoliquido <= prodpesobruto),
    CONSTRAINT pk_produtos PRIMARY KEY (prodcodigo)
);
```
