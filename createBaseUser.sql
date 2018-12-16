-- MySQL Script generated by MySQL Workbench
-- ven. 14 déc. 2018 14:37:39 CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema m_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `m_db` ;

-- -----------------------------------------------------
-- Schema m_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `m_db` ;
USE `m_db` ;

-- -----------------------------------------------------
-- Table `m_db`.`conseiller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`conseiller` ;

CREATE TABLE IF NOT EXISTS `m_db`.`conseiller` (
  `idconseil` INT(11) NOT NULL AUTO_INCREMENT,
  `nom_conseil` VARCHAR(30) NOT NULL,
  `prenom_conseil` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idconseil`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`client` ;

CREATE TABLE IF NOT EXISTS `m_db`.`client` (
  `idclient` INT(11) NOT NULL AUTO_INCREMENT,
  `numagency` VARCHAR(15) NOT NULL,
  `nom_client` VARCHAR(45) NOT NULL,
  `prenom_client` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(100) NULL DEFAULT NULL,
  `tel` VARCHAR(10) NULL DEFAULT NULL,
  `tel_portable` VARCHAR(10) NULL DEFAULT NULL,
  `typeClient` VARCHAR(10) NULL DEFAULT NULL,
  `adresse` VARCHAR(150) NULL DEFAULT NULL,
  `conseiller_idconseil` INT(11) NOT NULL,
  `anneeArrive` DATE NOT NULL,
  PRIMARY KEY (`idclient`),
  INDEX `fk_client_conseiller1_idx` (`conseiller_idconseil` ASC) ,
  CONSTRAINT `fk_client_conseiller1`
    FOREIGN KEY (`conseiller_idconseil`)
    REFERENCES `m_db`.`conseiller` (`idconseil`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`alerte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`alerte` ;

CREATE TABLE IF NOT EXISTS `m_db`.`alerte` (
  `idalerte` INT(11) NOT NULL AUTO_INCREMENT,
  `dateAlerte` DATE NOT NULL,
  `titre` VARCHAR(30) NOT NULL,
  `descriptif` VARCHAR(100) NULL DEFAULT NULL,
  `typeEnvoi` VARCHAR(5) NOT NULL DEFAULT 'SMS',
  `client_idclient` INT(11) NOT NULL,
  PRIMARY KEY (`idalerte`),
  INDEX `fk_alerte_client1_idx` (`client_idclient` ASC) ,
  CONSTRAINT `fk_alerte_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `m_db`.`client` (`idclient`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`user_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`user_question` ;

CREATE TABLE IF NOT EXISTS `m_db`.`user_question` (
  `question_id` INT(11) NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`question_id`),
  UNIQUE INDEX `UK_UniqueQuestion` (`question` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`user_app`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`user_app` ;

CREATE TABLE IF NOT EXISTS `m_db`.`user_app` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `answer` VARCHAR(30) NULL DEFAULT NULL,
  `email` VARCHAR(30) NOT NULL,
  `first_name` VARCHAR(30) NOT NULL,
  `id_interne` INT(11) NULL DEFAULT NULL,
  `last_name` VARCHAR(30) NOT NULL,
  `nb_try` INT(11) NULL DEFAULT NULL,
  `password` VARCHAR(100) NOT NULL,
  `sso_id` VARCHAR(30) NOT NULL,
  `state` VARCHAR(30) NOT NULL,
  `user_question_question_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `UK_SSO_ID` (`sso_id` ASC) ,
  INDEX `fk_user_app_user_question1_idx` (`user_question_question_id` ASC) ,
  CONSTRAINT `fk_user_app_user_question1`
    FOREIGN KEY (`user_question_question_id`)
    REFERENCES `m_db`.`user_question` (`question_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`user_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`user_profile` ;

CREATE TABLE IF NOT EXISTS `m_db`.`user_profile` (
  `user_profile_id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`user_profile_id`),
  UNIQUE INDEX `UK_TypeRoleUnique` (`type` ASC) ,
  UNIQUE INDEX `UKk6d5iiad3vb5isxj1munty17o` (`type` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`app_user_user_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`app_user_user_profile` ;

CREATE TABLE IF NOT EXISTS `m_db`.`app_user_user_profile` (
  `user_id` INT(11) NOT NULL,
  `user_profile_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `user_profile_id`),
  INDEX `IDX_USER_PROFIL_ID` (`user_profile_id` ASC) ,
  CONSTRAINT `FK_APP_USER`
    FOREIGN KEY (`user_id`)
    REFERENCES `m_db`.`user_app` (`user_id`),
  CONSTRAINT `FK_USER_PROFILE`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `m_db`.`user_profile` (`user_profile_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`banque`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`banque` ;

CREATE TABLE IF NOT EXISTS `m_db`.`banque` (
  `idbanque` INT(11) NOT NULL AUTO_INCREMENT,
  `nom_banque` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idbanque`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`banque_client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`banque_client` ;

CREATE TABLE IF NOT EXISTS `m_db`.`banque_client` (
  `banque_idbanque` INT(11) NOT NULL,
  `client_idclient` INT(11) NOT NULL,
  PRIMARY KEY (`banque_idbanque`, `client_idclient`),
  INDEX `fk_banque_client_client1_idx` (`client_idclient` ASC) ,
  INDEX `fk_banque_has_client_banque1_idx` (`banque_idbanque` ASC) ,
  CONSTRAINT `fk_banque_has_client_banque1`
    FOREIGN KEY (`banque_idbanque`)
    REFERENCES `m_db`.`banque` (`idbanque`),
  CONSTRAINT `fk_banque_has_client_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `m_db`.`client` (`idclient`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`carte_bancaire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`carte_bancaire` ;

CREATE TABLE IF NOT EXISTS `m_db`.`carte_bancaire` (
  `id_carte` INT(11) NOT NULL AUTO_INCREMENT,
  `numcarte` VARCHAR(16) NOT NULL,
  `codecrypto` VARCHAR(3) NOT NULL,
  `echeance` DATETIME NOT NULL,
  `typecarte` VARCHAR(15) NOT NULL,
  `client_idclient` INT(11) NOT NULL,
  PRIMARY KEY (`id_carte`, `client_idclient`),
  UNIQUE INDEX `numcarte_UNIQUE` (`numcarte` ASC) ,
  UNIQUE INDEX `UKpyxgu0p8lke5vf133o6uvenyq` (`numcarte` ASC) ,
  INDEX `fk_carte_bancaire_client1_idx` (`client_idclient` ASC) ,
  CONSTRAINT `fk_carte_bancaire_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `m_db`.`client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`client_idclient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`client_idclient` ;

CREATE TABLE IF NOT EXISTS `m_db`.`client_idclient` (
  `client_idclient` INT(11) NULL DEFAULT NULL,
  `id_carte` INT(11) NOT NULL,
  PRIMARY KEY (`id_carte`),
  INDEX `FKcpautu3xdp5dg7ayixgpfx11r` (`client_idclient` ASC) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`infoCompte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`infoCompte` ;

CREATE TABLE IF NOT EXISTS `m_db`.`infoCompte` (
  `idinfoCompte` INT(11) NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(45) NOT NULL,
  `montantPlafond` INT(11) NOT NULL,
  `montantMinimum` INT(11) NOT NULL,
  `tauxInteret` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`idinfoCompte`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`compte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`compte` ;

CREATE TABLE IF NOT EXISTS `m_db`.`compte` (
  `idcompte` INT(11) NOT NULL AUTO_INCREMENT,
  `numecompte` INT(11) NOT NULL,
  `solde` DOUBLE NOT NULL,
  `typeCompte` VARCHAR(20) NOT NULL,
  `client_idclient` INT(11) NOT NULL,
  `infoCompte_idinfoCompte` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idcompte`),
  INDEX `fk_compte_client1_idx` (`client_idclient` ASC) ,
  INDEX `fk_compte_infoCompte1_idx` (`infoCompte_idinfoCompte` ASC) ,
  CONSTRAINT `fk_compte_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `m_db`.`client` (`idclient`),
  CONSTRAINT `fk_compte_infoCompte1`
    FOREIGN KEY (`infoCompte_idinfoCompte`)
    REFERENCES `m_db`.`infoCompte` (`idinfoCompte`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`compteTiers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`compteTiers` ;

CREATE TABLE IF NOT EXISTS `m_db`.`compteTiers` (
  `idcompteTiers` INT(11) NOT NULL,
  `codeActivation` VARCHAR(8) NULL DEFAULT NULL,
  `Actif` TINYINT(1) NOT NULL,
  `dateCreation` DATETIME NOT NULL,
  `libelle` VARCHAR(45) NOT NULL,
  `compte_idcompte` INT(11) NOT NULL,
  PRIMARY KEY (`idcompteTiers`),
  INDEX `fk_compteTiers_compte1_idx` (`compte_idcompte` ASC) ,
  CONSTRAINT `fk_compteTiers_compte1`
    FOREIGN KEY (`compte_idcompte`)
    REFERENCES `m_db`.`compte` (`idcompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`document`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`document` ;

CREATE TABLE IF NOT EXISTS `m_db`.`document` (
  `iddocument` INT(11) NOT NULL AUTO_INCREMENT,
  `client_idclient` INT(11) NOT NULL,
  `nom_doc` VARCHAR(45) NOT NULL,
  `emplacement` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`iddocument`),
  INDEX `fk_document_client1_idx` (`client_idclient` ASC) ,
  CONSTRAINT `fk_document_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `m_db`.`client` (`idclient`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `m_db`.`operation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`operation` ;

CREATE TABLE IF NOT EXISTS `m_db`.`operation` (
    `idoperation` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `numOperation` INT(11) NOT NULL,
    `dateOperation` DATETIME NOT NULL,
    `montant` DOUBLE NOT NULL,
    `typeOperation` VARCHAR(5) NOT NULL,
    `compte_idcompte` INT(11) NOT NULL,
    PRIMARY KEY (`idoperation` , `compte_idcompte`),
    INDEX `fk_operation_compte1_idx` (`compte_idcompte` ASC),
    CONSTRAINT `fk_operation_compte1` FOREIGN KEY (`compte_idcompte`)
        REFERENCES `m_db`.`compte` (`idcompte`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=LATIN1;


-- -----------------------------------------------------
-- Table `m_db`.`virement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `m_db`.`virement` ;

CREATE TABLE IF NOT EXISTS `m_db`.`virement` (
  `idvirement` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `client_idclient` INT(11) NOT NULL,
  `dateCreation` DATETIME NOT NULL,
  `typeVirement` VARCHAR(5) NOT NULL,
  `dateEcheance` DATETIME NOT NULL,
  `compte_Crediteur` INT(11) NOT NULL,
  `compte_Debiteur` INT(11) NOT NULL,
  `montant` DOUBLE NOT NULL,
  PRIMARY KEY (`idvirement`),
  INDEX `fk_virement_client1_idx` (`client_idclient` ASC) ,
  INDEX `fk_virement_compteCredit_idx` (`compte_Crediteur` ASC) ,
  INDEX `fk_virement_compteDebit_idx` (`compte_Debiteur` ASC) ,
  CONSTRAINT `fk_virement_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `m_db`.`client` (`idclient`),
  CONSTRAINT `fk_virement_compte1`
    FOREIGN KEY (`compte_Crediteur`)
    REFERENCES `m_db`.`compte` (`idcompte`),
  CONSTRAINT `fk_virement_compte2`
    FOREIGN KEY (`compte_Debiteur`)
    REFERENCES `m_db`.`compte` (`idcompte`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;