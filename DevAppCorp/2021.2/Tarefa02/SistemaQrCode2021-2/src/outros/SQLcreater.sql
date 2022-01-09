
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

