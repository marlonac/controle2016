/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Marlon
 * Created: 08/11/2016
 */

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema controle
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema controle
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `controle` DEFAULT CHARACTER SET utf8 ;
USE `controle` ;

-- -----------------------------------------------------
-- Table `controle`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle`.`marca` (
  `idmarca` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle`.`estado` (
  `idestado` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle`.`cidade` (
  `idcidade` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `idestado` INT NOT NULL,
  PRIMARY KEY (`idcidade`),
  INDEX `fk_cidade_estado1_idx` (`idestado` ASC),
  CONSTRAINT `fk_cidade_estado1`
    FOREIGN KEY (`idestado`)
    REFERENCES `controle`.`estado` (`idestado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `sexo` ENUM('M', 'F') NOT NULL,
  `login` VARCHAR(60) NOT NULL,
  `senha` VARCHAR(120) NOT NULL,
  `logradouro` VARCHAR(60) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `idcidade` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  INDEX `fk_usuario_cidade1_idx` (`idcidade` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `fk_usuario_cidade1`
    FOREIGN KEY (`idcidade`)
    REFERENCES `controle`.`cidade` (`idcidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle`.`fornecedor` (
  `idfornecedor` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  `logradouro` VARCHAR(60) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `idcidade` INT NOT NULL,
  PRIMARY KEY (`idfornecedor`),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC),
  INDEX `fk_fornecedor_cidade1_idx` (`idcidade` ASC),
  CONSTRAINT `fk_fornecedor_cidade1`
    FOREIGN KEY (`idcidade`)
    REFERENCES `controle`.`cidade` (`idcidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle`.`produto` (
  `idproduto` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `marca_idmarca` INT NOT NULL,
  `preco` DECIMAL(12,2) NOT NULL,
  `quanidade` INT NOT NULL,
  `dataCadastro` DATETIME NOT NULL,
  `fornecedor_idfornecedor` INT NOT NULL,
  PRIMARY KEY (`idproduto`),
  INDEX `fk_produto_marca_idx` (`marca_idmarca` ASC),
  INDEX `fk_produto_fornecedor1_idx` (`fornecedor_idfornecedor` ASC),
  CONSTRAINT `fk_produto_marca`
    FOREIGN KEY (`marca_idmarca`)
    REFERENCES `controle`.`marca` (`idmarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `controle`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `controle`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle`.`estoque` (
  `idestoque` INT NOT NULL AUTO_INCREMENT,
  `quantMin` INT NOT NULL,
  `quantMax` INT NOT NULL,
  `quantEsto` INT NOT NULL,
  `dataEntrada` DATE NULL,
  `produto_idproduto` INT NOT NULL,
  PRIMARY KEY (`idestoque`),
  INDEX `fk_estoque_produto1_idx` (`produto_idproduto` ASC),
  CONSTRAINT `fk_estoque_produto1`
    FOREIGN KEY (`produto_idproduto`)
    REFERENCES `controle`.`produto` (`idproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
