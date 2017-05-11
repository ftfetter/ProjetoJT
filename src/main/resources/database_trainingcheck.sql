CREATE DATABASE trainingcheckdb;
USE trainingcheckdb;

create table aluno
(
  id int not null auto_increment,
  nome varchar(64) not null,
  cpf varchar(15) not null,
  telefone varchar(15) null,
  email varchar(50) null,
  peso float null,
  altura float null,
  gordura float null,
  treinador_id int not null,
  primary key (id, treinador_id)
)
;

create index fk_aluno_treinador1_idx
  on aluno (treinador_id)
;

create table exercicio
(
  id int not null auto_increment
    primary key,
  nome varchar(45) not null,
  descricao varchar(200) null
)
;

create table treinador
(
  id int not null auto_increment
    primary key,
  nome varchar(64) not null,
  cpf varchar(15) not null,
  telefone varchar(15) null,
  email varchar(32) null
)
;

alter table aluno
  add constraint fk_aluno_treinador1
foreign key (treinador_id) references trainingcheckdb.treinador (id)
;

create table treino
(
  exercicio_id int not null,
  aluno_id int not null,
  repeticao int null,
  carga int null,
  id int not null auto_increment,
  primary key (id, exercicio_id, aluno_id),
  constraint fk_exercicio_has_aluno_exercicio1
  foreign key (exercicio_id) references trainingcheckdb.exercicio (id),
  constraint fk_exercicio_has_aluno_aluno1
  foreign key (aluno_id) references trainingcheckdb.aluno (id)
)
;

create index fk_exercicio_has_aluno_aluno1_idx
  on treino (aluno_id)
;

create index fk_exercicio_has_aluno_exercicio1_idx
  on treino (exercicio_id)
;

create table usuario
(
  id int not null auto_increment
    primary key,
  usuario varchar(32) not null,
  senha varchar(32) not null,
  tipo int not null,
  usuario_id int not null
)
;

INSERT INTO treinador(nome,cpf,telefone,email) 
  VALUES ('Bodybuilder Bambam','123.456.789-10','(13)131313131','bambam@bodybuilder.com'); 

INSERT INTO usuario(usuario,senha,tipo,usuario_id)
  VALUES ('bambam','13memo',1,1);