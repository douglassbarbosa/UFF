
DROP TABLE usuario;
DROP TABLE tarefa;

CREATE TABLE banco.usuario (
  id INT NOT NULL AUTO_INCREMENT,
  nome_usuario VARCHAR(30) NOT NULL,
  avatar_usuario VARCHAR(50) NOT NULL,
  versao INT DEFAULT 0,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4;

CREATE TABLE banco.categoria (
  id INT NOT NULL AUTO_INCREMENT,
  nome_categoria VARCHAR(50) NOT NULL,
  cor_categoria VARCHAR(300) DEFAULT '',
  status BOOLEAN DEFAULT 0,
  usuario_id	INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT USUARIO_CATEGORIA_FK 
  FOREIGN KEY my_fk(usuario_id)
  REFERENCES banco.usuario(id) 
  ON DELETE NO ACTION ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4;

CREATE TABLE banco.tarefa (
  id INT NOT NULL AUTO_INCREMENT,
  titulo_tarefa VARCHAR(50) NOT NULL,
  descricao_tarefa VARCHAR(300) DEFAULT '',
  STATUS_TAREFA INT DEFAULT 1,
  usuario_id	INT NOT NULL,
  categoria_id	INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT USUARIO_TAREFA_FK 
  FOREIGN KEY my_fk(usuario_id)
  REFERENCES banco.usuario(id) 
  ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT CATEGORIA_TAREFA_FK 
  FOREIGN KEY my_fk(categoria_id)
  REFERENCES banco.categoria(id) 
  ON DELETE NO ACTION ON UPDATE RESTRICT
)
ENGINE = INNODB
CHARACTER SET utf8mb4;

INSERT INTO usuario(nome_usuario,  avatar_usuario)
VALUES('Eduardo', 'img/Edu_foto_3x4.jpg'),
('Lucas',  'img/Luk_img_3x4.jpg');

INSERT INTO categoria(nome_categoria, cor_categoria, usuario_id) VALUES
('Mês todo', "verde", 1),
('Diária', "roxosa", 2),
('Escola', "azul", 1),
('Pets', "rosa", 2);

INSERT INTO TAREFA(TITULO_TAREFA, DESCRICAO_TAREFA, STATUS_TAREFA, USUARIO_ID, CATEGORIA_ID) VALUES
('Dever de Casa', 'Fazer a atividade da escola atribuida para casa',1,1, 3),
('Arrumar quarto', 'Arrumar o quarto todos os dias antes do jantar',1,1, 1),
('Lavar louça', 'Manter a pia sem louças',1,2, 2),
('Limpar caixa dos Gatos', 'Fazer a limpeza diária da caixa dos gatos',1,2, 4);


