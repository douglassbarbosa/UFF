-- -- Tabela Usuario -----------

-- DROP TABLE usuario;

CREATE TABLE sys.usuario (
  id  INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  cpfUsuario VARCHAR(15) NOT NULL,
  senhaUsuario varchar(12),
  dtCadastro DATE NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8
COLLATE utf8_general_ci;

INSERT INTO sys.usuario(nome, cpfUsuario, senhaUsuario, dtCadastro)
VALUES('Douglas Barbosa','10173770738','196022', curdate());

INSERT INTO sys.usuario(nome, cpfUsuario, senhaUsuario, dtCadastro)
VALUES('Ellen Barbosa','07529530798','196022', curdate());

-- ALTER TABLE sys.USUARIO MODIFY nome varchar(120)  ;

-- -- Tabela QrCode -------------

-- SELECT * FROM sys.qrcode;

-- ALTER TABLE sys.qrcode MODIFY imageQrCode  ;



CREATE TABLE sys.qrCode (
  id INT(11) NOT NULL AUTO_INCREMENT,
  tituloProjeto VARCHAR(120) NOT NULL,
  imageQrCode VARCHAR(30) NULL,
  idUsuario INT,
  FOREIGN KEY my_fk(idUsuario) 
  REFERENCES usuario(id) 
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

INSERT INTO sys.qrcode(tituloProjeto, imageQrCode,  idUsuario)
VALUES('Casa de Praia','..\qrcodeCriados\img0001.png',1);

INSERT INTO sys.qrcode(tituloProjeto, imageQrCode, idUsuario)
VALUES('Kit Bikines','..\qrcodeCriados\img0002.png',2);

-- ---- Conteúdo ---

DROP TABLE sys.conteudo;

CREATE TABLE sys.conteudo (
  id INT(11) NOT NULL AUTO_INCREMENT,
  tituloProjeto VARCHAR(200) NOT NULL,
  descricaoConteudo LONGTEXT,
  imgConteudo  varchar(200),
  linkConteudo varchar(200),
  idQrcode INT,
  FOREIGN KEY my_fk(idQrCode) 
  REFERENCES qrcode(id) 
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

INSERT INTO sys.conteudo(
tituloProjeto, 
descricaoConteudo, 
imgConteudo,
linkConteudo,
idQrcode
)
VALUES('Sistema Ar Condicionado',
'<p>Para usar o Arcondicionado é necessário ligar o Interruptor de Enegia no Quadro de Luz</p>'
,'c:\img','www.google',1
);

INSERT INTO sys.conteudo(
tituloProjeto, 
descricaoConteudo, 
imgConteudo,
linkConteudo,
idQrcode
)
VALUES('Bolsa Conjuntos Novos',
'<p>Partes de cima separaas das de Baixo, sugestões de combinações nas imagens</p>',
'C:\nikinis.jpg','bikinisdamoda.com',2
);


-- -------------------------
-- -------------------------
-- -- Tabela Período

/*
DROP TABLE sistemaqrcode.periodo;

CREATE TABLE sistemaqrcode.periodo (
  id INT(11) NOT NULL AUTO_INCREMENT,
  dtOn DATE NOT NULL,
  dtOff DATE NOT NULL,
  horaOn time,
  horaOff time,
  repeteDia varchar(1000) NOT NULL,
  idConteudo INT,
  FOREIGN KEY my_fk(idConteudo) 
  REFERENCES conteudo(id) 
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

INSERT INTO sistemaqrcode.periodo(dtOn, dtOff, horaOn, horaOff,
repeteDia,
idConteudo
)
VALUES('2022-01-01','2022-11-01','10:00:00','17:59:59',
'0',1);
*/