CREATE TABLE DATASOURCECONFIG (
	id IDENTITY PRIMARY KEY,
	driverclassname VARCHAR(255),
	url VARCHAR(255),
	name VARCHAR(255),
	username VARCHAR(255),
	password VARCHAR(255),
	initialize BOOLEAN
);

--
-- Table structure for table colaborador
--
CREATE TABLE colaborador (
  cpf IDENTITY PRIMARY KEY,
  cartao varchar(50),
  nome varchar(50),
  nome_mae varchar(100),
  nome_pai varchar(100),
  num_carteira_trabalho varchar(6),
  pis varchar(11),
  rg varchar(11),
  sobrenome varchar(100),
  idlogradouro int(11)
);

--
-- Table structure for table contrato_trabalho
--

CREATE TABLE contrato_trabalho (
  idmatricula int auto_increment primary key,
  carga_horaria int(11),
  dt_admissao date,
  endereco_trabalho varchar(100),
  modalidade_contratacao int(11),
  salario_base decimal(19,0),
  cpf varchar(11),
  cnpj varchar(20)
);

--
-- Table structure for table empresa
--

CREATE TABLE empresa (
  cnpj IDENTITY PRIMARY KEY,
  cnae int(11),
  idnaturezajuridica INT(11),
  nome_fantasia varchar(150),
  razao_social varchar(150),
  idenquadramento int(11),
  idlogradouro int(11)
);

--
-- Table structure for table empresa_imposto
--

CREATE TABLE empresa_imposto (
  cnpj varchar(20),
  idimposto int(11),
  PRIMARY KEY (cnpj, idimposto)
); 

CREATE TABLE enquadramento_tributario (
  idenquadramento IDENTITY PRIMARY KEY AUTO_INCREMENT,
  aliquota double,
  descricao varchar(100)
);

CREATE TABLE imposto (
  idimposto IDENTITY PRIMARY KEY AUTO_INCREMENT,
  descricao varchar(100),
  dt_pagamento date,
  valor double
);

CREATE TABLE logradouro (
  idlogradouro IDENTITY PRIMARY KEY AUTO_INCREMENT,
  bairro varchar(100),
  cep varchar(8),
  cidade varchar(100),
  estado varchar(100),
  municipio varchar(150),
  pais varchar(75),
  rua varchar(150)
);


