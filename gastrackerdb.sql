-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gastrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gastrackerdb` ;

-- -----------------------------------------------------
-- Schema gastrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gastrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `gastrackerdb` ;

-- -----------------------------------------------------
-- Table `gas_tracker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gas_tracker` ;

CREATE TABLE IF NOT EXISTS `gas_tracker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `num_gallons` DOUBLE NULL,
  `price_per_gallon` DOUBLE NULL,
  `miles_driven` DOUBLE NULL,
  `miles_per_gallon` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO gas@localhost;
 DROP USER gas@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'gas'@'localhost' IDENTIFIED BY 'gas';

GRANT ALL ON * TO 'gas'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `gas_tracker`
-- -----------------------------------------------------
START TRANSACTION;
USE `gastrackerdb`;
INSERT INTO `gas_tracker` (`id`, `num_gallons`, `price_per_gallon`, `miles_driven`, `miles_per_gallon`) VALUES (1, 10, 3.50, 100, 50);
INSERT INTO `gas_tracker` (`id`, `num_gallons`, `price_per_gallon`, `miles_driven`, `miles_per_gallon`) VALUES (2, 20, 2.50, 200, 15);

COMMIT;
