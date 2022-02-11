https://dev.mysql.com/downloads/

Download MySQL Community Server

Últimas versões:
- 5.5
- 5.6
- 5.7
- 8.0.12 (atual)

DROP TABLE usuario;

CREATE TABLE banco.usuario (
  id INT NOT NULL AUTO_INCREMENT,
  nome_usuario VARCHAR(30) NOT NULL,
  avatar_usuario VARCHAR(50) NOT NULL,
  versao INT DEFAULT 0,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4;

INSERT INTO usuario(nome_usuario,  avatar_usuario)
VALUES('Douglas', 'img/foto_3x4.jpg');

INSERT INTO usuario(nome_usuario, avatar_usuario)
VALUES('Eduardo',  'img/img_3x4.jpg');
