-- MySQL Workbench Synchronization
-- Generated: 2016-11-20 18:06
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Marlon

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER TABLE `controle`.`marca` 
CHANGE COLUMN `idmarca` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `descricao` `descricao` VARCHAR(45) NOT NULL ;

ALTER TABLE `controle`.`usuario` 
CHANGE COLUMN `idusuario` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `nome` `nome` VARCHAR(60) NOT NULL ,
CHANGE COLUMN `phone` `phone` VARCHAR(20) NOT NULL ,
CHANGE COLUMN `cpf` `cpf` VARCHAR(11) NOT NULL ,
CHANGE COLUMN `sexo` `sexo` ENUM('M', 'F') NOT NULL ,
CHANGE COLUMN `login` `login` VARCHAR(60) NOT NULL ,
CHANGE COLUMN `senha` `senha` VARCHAR(120) NOT NULL ,
CHANGE COLUMN `logradouro` `logradouro` VARCHAR(60) NOT NULL ,
CHANGE COLUMN `cep` `cep` VARCHAR(8) NOT NULL ,
CHANGE COLUMN `bairro` `bairro` VARCHAR(45) NOT NULL ;

ALTER TABLE `controle`.`produto` 
CHANGE COLUMN `idproduto` `id` INT(11) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `descricao` `descricao` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `preco` `preco` FLOAT(11) NOT NULL ;

ALTER TABLE `controle`.`fornecedor` 
CHANGE COLUMN `idfornecedor` `id` INT(11) NOT NULL ,
CHANGE COLUMN `nome` `nome` VARCHAR(60) NOT NULL ,
CHANGE COLUMN `email` `email` VARCHAR(60) NOT NULL ,
CHANGE COLUMN `phone` `phone` VARCHAR(20) NOT NULL ,
CHANGE COLUMN `cnpj` `cnpj` VARCHAR(14) NOT NULL ,
CHANGE COLUMN `logradouro` `logradouro` VARCHAR(60) NOT NULL ,
CHANGE COLUMN `cep` `cep` VARCHAR(8) NOT NULL ,
CHANGE COLUMN `bairro` `bairro` VARCHAR(45) NOT NULL ;

ALTER TABLE `controle`.`estoque` 
CHANGE COLUMN `idestoque` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `controle`.`cidade` 
CHANGE COLUMN `nome` `nome` VARCHAR(60) NOT NULL ;

ALTER TABLE `controle`.`estado` 
CHANGE COLUMN `idestado` `idestado` INT(11) NOT NULL ,
CHANGE COLUMN `nome` `nome` VARCHAR(45) NOT NULL ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
