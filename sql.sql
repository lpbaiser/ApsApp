DROP TABLE IF EXISTS Score CASCADE;
DROP TABLE IF EXISTS Player;


CREATE DATABASE IF NOT EXISTS JogoApp;
USE JogoApp ;


CREATE TABLE IF NOT EXISTS Player(
  idPlayer INT NOT NULL AUTO_INCREMENT,
  namePlayer VARCHAR(45) NOT NULL,
  CONSTRAINT pk_pPlayerlayer PRIMARY KEY (idPlayer))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS Score (
  tempo INT NOT NULL,
  numTentativas INT NOT NULL,
  acertoConsecutivo INT NOT NULL,
  pontos FLOAT NOT NULL,
  idPlayer INT NOT NULL,
  CONSTRAINT pk_score PRIMARY KEY (acertoConsecutivo, tempo, numTentativas, pontos),
  CONSTRAINT fk_Score_Player
    FOREIGN KEY (idPlayer)
    REFERENCES Player (idPlayer)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

