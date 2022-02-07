
DROP TABLE produto;

CREATE TABLE sistemaqrcode.usuario (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(30) NOT NULL,
  cpfUsuario VARCHAR(11) NOT NULL,
  senhaUsuario varchar(8) not null,
  dtCadastro DATE NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

INSERT INTO sistemaqrcode.usuario(nome, cpfUsuario, senhaUsuario, dtCadastro)
VALUES('Douglas Barbosa','10173770738','196022', curdate());

INSERT INTO sistemaqrcode.usuario(nome, cpfUsuario, senhaUsuario, dtCadastro)
VALUES('Ellen Barbosa','07529530798','196022', curdate());

-- QrCode

CREATE TABLE sistemaqrcode.usuario (
  id INT(11) NOT NULL AUTO_INCREMENT,
  tituloProjeto VARCHAR(30) NOT NULL,
  imageQrCode VARCHAR(11) NOT NULL,
  dtCriacao DATE NOT NULL,
  idUsuario INT,
  FOREIGN KEY my_fk(idUsuario) 
  REFERENCES usuario(id) 
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  PRIMARY KEY (id)
);

CREATE TABLE child (
ID INT PRIMARY KEY, 
parent_ID INT, 
FOREIGN KEY my_fk (parent_id) 
REFERENCES parent(ID) 
ON UPDATE NO ACTION ON DELETE NO ACTION)

ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

INSERT INTO sistemaqrcode.usuario(nome, cpfUsuario, senhaUsuario, dtCadastro)
VALUES('Douglas Barbosa','10173770738','196022', curdate());

INSERT INTO sistemaqrcode.usuario(nome, cpfUsuario, senhaUsuario, dtCadastro)
VALUES('Ellen Barbosa','07529530798','196022', curdate());