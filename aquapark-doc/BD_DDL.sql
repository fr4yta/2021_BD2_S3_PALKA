-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `type_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `user_type_idx` (`type_id` ASC) VISIBLE,
  CONSTRAINT `user_type`
    FOREIGN KEY (`type_id`)
    REFERENCES `mydb`.`user_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `mydb`.`price_lists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`price_lists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `valid_from` TIMESTAMP NOT NULL,
  `valid_to` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`price_item_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`price_item_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`ticket_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ticket_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `ticket_type` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `ticket_type_idx` (`ticket_type` ASC) VISIBLE,
  CONSTRAINT `ticket_type`
    FOREIGN KEY (`ticket_type`)
    REFERENCES `mydb`.`ticket_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`pass_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pass_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`passes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`passes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `pass_type` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `pass_type_idx` (`pass_type` ASC) VISIBLE,
  CONSTRAINT `pass_type`
    FOREIGN KEY (`pass_type`)
    REFERENCES `mydb`.`pass_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`price_items_on_price_lists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`price_items_on_price_lists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price_lists_id` INT NOT NULL,
  `price_item_type_id` INT NOT NULL,
  `price` DECIMAL(8,2) NOT NULL,
  `ticket_id` INT NOT NULL,
  `pass_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `price_lists_id_idx` (`price_lists_id` ASC) VISIBLE,
  INDEX `price_item_id_idx` (`price_item_type_id` ASC) VISIBLE,
  INDEX `ticket_id_idx` (`ticket_id` ASC) VISIBLE,
  INDEX `pass_id_idx` (`pass_id` ASC) VISIBLE,
  CONSTRAINT `price_lists_id`
    FOREIGN KEY (`price_lists_id`)
    REFERENCES `mydb`.`price_lists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `price_item_id`
    FOREIGN KEY (`price_item_type_id`)
    REFERENCES `mydb`.`price_item_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ticket_id`
    FOREIGN KEY (`ticket_id`)
    REFERENCES `mydb`.`tickets` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pass_id`
    FOREIGN KEY (`pass_id`)
    REFERENCES `mydb`.`passes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`purchases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`purchases` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `purchase_date` TIMESTAMP NOT NULL,
  `entry_date` TIMESTAMP NOT NULL,
  `user_id` INT NOT NULL,
  `price_item_on_price_list_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `price_lists` () VISIBLE,
  INDEX `price_item_lists_idx` (`price_item_on_price_list_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `price_item_lists`
    FOREIGN KEY (`price_item_on_price_list_id`)
    REFERENCES `mydb`.`price_items_on_price_lists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`schedules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`schedules` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `start_date_time` TIMESTAMP NOT NULL,
  `end_date_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
