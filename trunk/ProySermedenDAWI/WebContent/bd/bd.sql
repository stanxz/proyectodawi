SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `bdsermeden` ;
CREATE SCHEMA IF NOT EXISTS `bdsermeden` DEFAULT CHARACTER SET latin1 ;
USE `bdsermeden` ;

-- -----------------------------------------------------
-- Table `bdsermeden`.`funcionalidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdsermeden`.`funcionalidad` ;

CREATE  TABLE IF NOT EXISTS `bdsermeden`.`funcionalidad` (
  `idFuncionalidad` INT(11) NOT NULL ,
  `descripcion` VARCHAR(80) NULL DEFAULT NULL ,
  `enlace` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idFuncionalidad`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bdsermeden`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdsermeden`.`perfil` ;

CREATE  TABLE IF NOT EXISTS `bdsermeden`.`perfil` (
  `idPerfil` INT(11) NOT NULL ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPerfil`) ,
  INDEX `fk_Perfil_rol1` (`idPerfil` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bdsermeden`.`acceso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdsermeden`.`acceso` ;

CREATE  TABLE IF NOT EXISTS `bdsermeden`.`acceso` (
  `idFuncionalidad` INT(11) NOT NULL ,
  `idPerfil` INT(11) NOT NULL ,
  PRIMARY KEY (`idFuncionalidad`, `idPerfil`) ,
  INDEX `fk_Acceso_perfil1` (`idPerfil` ASC) ,
  CONSTRAINT `fk_Acceso_funcionalidad1`
    FOREIGN KEY (`idFuncionalidad` )
    REFERENCES `bdsermeden`.`funcionalidad` (`idFuncionalidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acceso_perfil1`
    FOREIGN KEY (`idPerfil` )
    REFERENCES `bdsermeden`.`perfil` (`idPerfil` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bdsermeden`.`especialidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdsermeden`.`especialidad` ;

CREATE  TABLE IF NOT EXISTS `bdsermeden`.`especialidad` (
  `idEspecialidad` INT(11) NOT NULL ,
  `Descripcion` VARCHAR(50) NULL DEFAULT NULL ,
  PRIMARY KEY (`idEspecialidad`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bdsermeden`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdsermeden`.`persona` ;

CREATE  TABLE IF NOT EXISTS `bdsermeden`.`persona` (
  `idPersona` INT(11) NOT NULL ,
  `dni` VARCHAR(8) NULL DEFAULT NULL ,
  `nombre` VARCHAR(60) NULL DEFAULT NULL ,
  `apepat` VARCHAR(60) NULL DEFAULT NULL ,
  `apemat` VARCHAR(60) NULL DEFAULT NULL ,
  `fechanac` DATETIME NULL DEFAULT NULL ,
  `sexo` CHAR(1) NULL DEFAULT NULL ,
  `email` VARCHAR(100) NULL DEFAULT NULL ,
  `fijo` VARCHAR(7) NULL DEFAULT NULL ,
  `celular` VARCHAR(15) NULL DEFAULT NULL ,
  `direccion` VARCHAR(100) NULL DEFAULT NULL ,
  `observaciones` VARCHAR(500) NULL DEFAULT NULL ,
  `idEspecialidad` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPersona`) ,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) ,
  INDEX `fk_persona_especialidad1` (`idEspecialidad` ASC) ,
  CONSTRAINT `fk_persona_especialidad1`
    FOREIGN KEY (`idEspecialidad` )
    REFERENCES `bdsermeden`.`especialidad` (`idEspecialidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bdsermeden`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdsermeden`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `bdsermeden`.`usuario` (
  `user` VARCHAR(45) NULL DEFAULT NULL ,
  `contrasena` VARCHAR(45) NULL DEFAULT NULL ,
  `estado` INT(11) NULL DEFAULT NULL ,
  `idPersona` INT(11) NOT NULL ,
  `idPerfil` INT(11) NOT NULL ,
  PRIMARY KEY (`idPersona`, `idPerfil`) ,
  INDEX `fk_Usuario_persona` (`idPersona` ASC) ,
  INDEX `fk_usuario_perfil1` (`idPerfil` ASC) ,
  CONSTRAINT `fk_usuario_perfil1`
    FOREIGN KEY (`idPerfil` )
    REFERENCES `bdsermeden`.`perfil` (`idPerfil` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_persona`
    FOREIGN KEY (`idPersona` )
    REFERENCES `bdsermeden`.`persona` (`idPersona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
