-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Team` (
  `teamName` VARCHAR(45) NOT NULL,
  `teamMembers` VARCHAR(45) NOT NULL,
  `rank` INT NULL,
  PRIMARY KEY (`teamName`, `teamMembers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Player` (
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `handicap` INT NOT NULL,
  `score` INT NOT NULL,
  `rank` INT NOT NULL,
  `Team_teamName` VARCHAR(45) NOT NULL,
  `Team_teamMember` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`fName`, `lName`, `handicap`, `score`, `rank`, `Team_teamName`, `Team_teamMember`),
  INDEX `fk_Player_Team_idx` (`Team_teamName` ASC, `Team_teamMember` ASC),
  CONSTRAINT `fk_Player_Team`
    FOREIGN KEY (`Team_teamName` , `Team_teamMember`)
    REFERENCES `mydb`.`Team` (`teamName` , `teamMembers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
