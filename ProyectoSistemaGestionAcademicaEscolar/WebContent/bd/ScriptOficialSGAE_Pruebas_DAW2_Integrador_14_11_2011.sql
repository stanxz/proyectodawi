SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `bd_proy_SGAE` DEFAULT CHARACTER SET latin1 ;
USE `bd_proy_SGAE` ;

-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`calendarioacademico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`calendarioacademico` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`calendarioacademico` (
  `CODCALENDARIO` CHAR(4) NOT NULL DEFAULT '' ,
  PRIMARY KEY (`CODCALENDARIO`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`actividad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`actividad` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`actividad` (
  `CODACTIVIDAD` INT NOT NULL AUTO_INCREMENT ,
  `CODCALENDARIO` CHAR(4) NULL DEFAULT NULL ,
  `NOMBREACTIVIDAD` VARCHAR(30) NULL DEFAULT NULL ,
  `FECHAINI` DATE NULL DEFAULT NULL ,
  `FECHAFIN` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`CODACTIVIDAD`) ,
  INDEX `FK_actividad_calendario` (`CODCALENDARIO` ASC) ,
  CONSTRAINT `FK_actividad_calendario`
    FOREIGN KEY (`CODCALENDARIO` )
    REFERENCES `bd_proy_SGAE`.`calendarioacademico` (`CODCALENDARIO` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`persona` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`persona` (
  `CODPERSONA` INT(11) NOT NULL AUTO_INCREMENT ,
  `NOMBRES` VARCHAR(80) NULL DEFAULT NULL ,
  `APELLIDOPAT` VARCHAR(80) NULL DEFAULT NULL ,
  `APELLIDOMAT` VARCHAR(80) NULL DEFAULT NULL ,
  `DIRECCION` VARCHAR(60) NULL DEFAULT NULL ,
  `EMAIL` VARCHAR(80) NULL DEFAULT NULL ,
  `TELEFONO` VARCHAR(10) NULL DEFAULT NULL ,
  `CELULAR` VARCHAR(15) NULL DEFAULT NULL ,
  `SEXO` INT NULL DEFAULT NULL ,
  PRIMARY KEY (`CODPERSONA`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`apoderado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`apoderado` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`apoderado` (
  `CODAPODERADO` INT(11) NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`CODAPODERADO`) ,
  CONSTRAINT `APODERADO_PERSONA_FK`
    FOREIGN KEY (`CODAPODERADO` )
    REFERENCES `bd_proy_SGAE`.`persona` (`CODPERSONA` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`alumno` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`alumno` (
  `CODALUMNO` INT(11) NOT NULL AUTO_INCREMENT ,
  `CODAPODERADO` INT(11) NOT NULL ,
  `NOMBRES` VARCHAR(40) NULL DEFAULT NULL ,
  `APELLIDOPAT` VARCHAR(20) NULL DEFAULT NULL ,
  `APELLIDOMAT` VARCHAR(20) NULL DEFAULT NULL ,
  `EDAD` INT(11) NULL DEFAULT NULL ,
  `GRADO` INT(11) NULL DEFAULT NULL ,
  `SECCION` CHAR(1) NULL DEFAULT NULL ,
  `ANOACADEMICO` CHAR(4) NULL DEFAULT NULL ,
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  `CODCALENDARIO` CHAR(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODALUMNO`) ,
  INDEX `ALUMNO_APODERADO_FK` (`CODAPODERADO` ASC) ,
  INDEX `FK_alumno_calendario` (`CODCALENDARIO` ASC) ,
  CONSTRAINT `ALUMNO_APODERADO_FK`
    FOREIGN KEY (`CODAPODERADO` )
    REFERENCES `bd_proy_SGAE`.`apoderado` (`CODAPODERADO` ),
  CONSTRAINT `FK_alumno_calendario`
    FOREIGN KEY (`CODCALENDARIO` )
    REFERENCES `bd_proy_SGAE`.`calendarioacademico` (`CODCALENDARIO` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`asignatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`asignatura` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`asignatura` (
  `CODASIGNATURA` INT(11) NOT NULL AUTO_INCREMENT ,
  `NOMBRE` VARCHAR(30) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODASIGNATURA`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`asistentasocial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`asistentasocial` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`asistentasocial` (
  `CODASISTENTASOCIAL` INT(11) NOT NULL AUTO_INCREMENT ,
  `CONSULTORIO` CHAR(3) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODASISTENTASOCIAL`) ,
  CONSTRAINT `ASISTENTASOCIAL_PERSONA_FK`
    FOREIGN KEY (`CODASISTENTASOCIAL` )
    REFERENCES `bd_proy_SGAE`.`persona` (`CODPERSONA` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`boletapago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`boletapago` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`boletapago` (
  `CODBOLETA` CHAR(8) NOT NULL DEFAULT '' ,
  `CODAPODERADO` INT(11) NOT NULL DEFAULT '0' ,
  `FECHAREGISTRO` DATE NULL DEFAULT NULL ,
  `MONTO` DOUBLE NULL DEFAULT NULL ,
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODBOLETA`) ,
  INDEX `FK_boletapago_apoderado` (`CODAPODERADO` ASC) ,
  CONSTRAINT `FK_boletapago_apoderado`
    FOREIGN KEY (`CODAPODERADO` )
    REFERENCES `bd_proy_SGAE`.`apoderado` (`CODAPODERADO` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`disponibilidadasistentasocial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`disponibilidadasistentasocial` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`disponibilidadasistentasocial` (
  `FECHAREGISTRO` DATE NULL ,
  `HORAINICIO` VARCHAR(8) NOT NULL DEFAULT '' ,
  `HORAFIN` VARCHAR(8) NOT NULL DEFAULT '' ,
  `CODDISPONIBILIDADAS` CHAR(4) NOT NULL DEFAULT '' ,
  PRIMARY KEY (`CODDISPONIBILIDADAS`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`horario` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`horario` (
  `CODASISTENTASOCIAL` INT(11) NOT NULL AUTO_INCREMENT ,
  `CODDISPONIBILIDADAS` CHAR(4) NOT NULL DEFAULT '' ,
  `ESTADO` VARCHAR(15) NOT NULL DEFAULT '' ,
  PRIMARY KEY (`CODASISTENTASOCIAL`, `CODDISPONIBILIDADAS`) ,
  INDEX `HORARIO_DISPONIBILIDAD` (`CODDISPONIBILIDADAS` ASC) ,
  CONSTRAINT `HORARIO_ASISTENTA`
    FOREIGN KEY (`CODASISTENTASOCIAL` )
    REFERENCES `bd_proy_SGAE`.`asistentasocial` (`CODASISTENTASOCIAL` ),
  CONSTRAINT `HORARIO_DISPONIBILIDAD`
    FOREIGN KEY (`CODDISPONIBILIDADAS` )
    REFERENCES `bd_proy_SGAE`.`disponibilidadasistentasocial` (`CODDISPONIBILIDADAS` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`tiposervicioas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`tiposervicioas` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`tiposervicioas` (
  `CODTIPOSERVICIO` INT(11) NOT NULL ,
  `NOMBRE` VARCHAR(25) NULL DEFAULT NULL ,
  `DESCRIPCION` VARCHAR(150) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODTIPOSERVICIO`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`cita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`cita` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`cita` (
  `CODCITA` INT(11) NOT NULL AUTO_INCREMENT ,
  `CODALUMNO` INT(11) NOT NULL ,
  `CODTIPOSERVICIO` INT(11) NOT NULL ,
  `CODASISTENTASOCIAL` INT(11) NOT NULL DEFAULT '0' ,
  `CORREOPERSONAL` VARCHAR(60) NULL DEFAULT NULL ,
  `TLFFIJO` CHAR(7) NULL DEFAULT NULL ,
  `TLFCELULAR` CHAR(9) NULL DEFAULT NULL ,
  `FECHAREGISTRO` DATE NULL DEFAULT NULL ,
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  `CODDISPONIBILIDADAS` CHAR(4) NOT NULL DEFAULT '' ,
  PRIMARY KEY (`CODCITA`) ,
  INDEX `CITA_TIPOSERVICIOAS_FK` (`CODTIPOSERVICIO` ASC) ,
  INDEX `CITA_ALUMNO_FK` (`CODALUMNO` ASC) ,
  INDEX `CITA_ASISTENTASOCIAL_FK` (`CODASISTENTASOCIAL` ASC) ,
  INDEX `CITA_HORARIO` (`CODASISTENTASOCIAL` ASC) ,
  INDEX `CITA_HORARIO_FK` (`CODASISTENTASOCIAL` ASC, `CODDISPONIBILIDADAS` ASC) ,
  CONSTRAINT `CITA_ALUMNO_FK`
    FOREIGN KEY (`CODALUMNO` )
    REFERENCES `bd_proy_SGAE`.`alumno` (`CODALUMNO` ),
  CONSTRAINT `CITA_HORARIO_FK`
    FOREIGN KEY (`CODASISTENTASOCIAL` , `CODDISPONIBILIDADAS` )
    REFERENCES `bd_proy_SGAE`.`horario` (`CODASISTENTASOCIAL` , `CODDISPONIBILIDADAS` ),
  CONSTRAINT `CITA_TIPOSERVICIOAS_FK`
    FOREIGN KEY (`CODTIPOSERVICIO` )
    REFERENCES `bd_proy_SGAE`.`tiposervicioas` (`CODTIPOSERVICIO` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`certificadoas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`certificadoas` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`certificadoas` (
  `CODCERTIFICADO` INT(11) NOT NULL AUTO_INCREMENT ,
  `CODCITA` INT(11) NOT NULL DEFAULT '0' ,
  `OBSERVACION` VARCHAR(200) NULL DEFAULT NULL ,
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODCERTIFICADO`) ,
  INDEX `CERTIFICADOAS_CITA_FK` (`CODCITA` ASC) ,
  CONSTRAINT `CERTIFICADOAS_CITA_FK`
    FOREIGN KEY (`CODCITA` )
    REFERENCES `bd_proy_SGAE`.`cita` (`CODCITA` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`detalleasignatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`detalleasignatura` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`detalleasignatura` (
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  `CODASIGNATURA` INT(11) NOT NULL ,
  `CODALUMNO` INT(11) NOT NULL ,
  PRIMARY KEY (`CODASIGNATURA`, `CODALUMNO`) ,
  INDEX `DETALLEASIGNATURA_ALUMNO_FK` (`CODALUMNO` ASC) ,
  CONSTRAINT `DETALLEASIGNATURA_ALUMNO_FK`
    FOREIGN KEY (`CODALUMNO` )
    REFERENCES `bd_proy_SGAE`.`alumno` (`CODALUMNO` ),
  CONSTRAINT `DETALLEASIGNATURA_ASIGNATURA_FK`
    FOREIGN KEY (`CODASIGNATURA` )
    REFERENCES `bd_proy_SGAE`.`asignatura` (`CODASIGNATURA` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`motivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`motivo` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`motivo` (
  `CODMOTIVO` INT NOT NULL AUTO_INCREMENT ,
  `NOMBRE` VARCHAR(60) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODMOTIVO`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`detallemotivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`detallemotivo` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`detallemotivo` (
  `CODMOTIVO` INT NOT NULL AUTO_INCREMENT ,
  `CODCERTIFICADO` INT(11) NOT NULL ,
  `DESCOTROS` VARCHAR(60) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODMOTIVO`, `CODCERTIFICADO`) ,
  INDEX `DETALLEMOTIVO_CERTIFICADOAS_FK` (`CODCERTIFICADO` ASC) ,
  CONSTRAINT `DETALLEMOTIVO_CERTIFICADOAS_FK`
    FOREIGN KEY (`CODCERTIFICADO` )
    REFERENCES `bd_proy_SGAE`.`certificadoas` (`CODCERTIFICADO` ),
  CONSTRAINT `DETALLEMOTIVO_MOTIVO_FK`
    FOREIGN KEY (`CODMOTIVO` )
    REFERENCES `bd_proy_SGAE`.`motivo` (`CODMOTIVO` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`perfil` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`perfil` (
  `CODPERFIL` CHAR(4) NOT NULL ,
  `NOMBRE` VARCHAR(20) NULL DEFAULT NULL ,
  `DESCRIPCION` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODPERFIL`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`permiso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`permiso` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`permiso` (
  `CODPERMISO` CHAR(4) NOT NULL ,
  `NOMBRE` VARCHAR(80) NULL DEFAULT NULL ,
  `DESCRIPCION` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODPERMISO`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`detalleperfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`detalleperfil` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`detalleperfil` (
  `CODPERMISO` CHAR(4) NOT NULL ,
  `CODPERFIL` CHAR(4) NOT NULL ,
  PRIMARY KEY (`CODPERMISO`, `CODPERFIL`) ,
  INDEX `DETALLEPERFIL_PERFIL_FK` (`CODPERFIL` ASC) ,
  CONSTRAINT `DETALLEPERFIL_PERFIL_FK`
    FOREIGN KEY (`CODPERFIL` )
    REFERENCES `bd_proy_SGAE`.`perfil` (`CODPERFIL` ),
  CONSTRAINT `DETALLEPERFIL_PERMISO_FK`
    FOREIGN KEY (`CODPERMISO` )
    REFERENCES `bd_proy_SGAE`.`permiso` (`CODPERMISO` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`restriccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`restriccion` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`restriccion` (
  `CODRESTRICCION` INT(11) NOT NULL DEFAULT '0' ,
  `NOMBRE` VARCHAR(45) NULL DEFAULT NULL ,
  `DESCRIPCION` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODRESTRICCION`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`detallerestriccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`detallerestriccion` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`detallerestriccion` (
  `CODALUMNO` INT(11) NOT NULL DEFAULT '0' ,
  `CODRESTRICION` INT(11) NOT NULL DEFAULT '0' ,
  `FECHAINI` DATE NULL DEFAULT NULL ,
  `FECHAFIN` DATE NULL DEFAULT NULL ,
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODALUMNO`, `CODRESTRICION`) ,
  INDEX `FK_detallerestriccion_restriccion` (`CODRESTRICION` ASC) ,
  CONSTRAINT `FK_detallerestriccion_alumno`
    FOREIGN KEY (`CODALUMNO` )
    REFERENCES `bd_proy_SGAE`.`alumno` (`CODALUMNO` ),
  CONSTRAINT `FK_detallerestriccion_restriccion`
    FOREIGN KEY (`CODRESTRICION` )
    REFERENCES `bd_proy_SGAE`.`restriccion` (`CODRESTRICCION` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`secretaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`secretaria` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`secretaria` (
  `CODSECRETARIA` INT(11) NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`CODSECRETARIA`) ,
  CONSTRAINT `SECRETARIA_PERSONA_FK`
    FOREIGN KEY (`CODSECRETARIA` )
    REFERENCES `bd_proy_SGAE`.`persona` (`CODPERSONA` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`solicitudexoneracion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`solicitudexoneracion` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`solicitudexoneracion` (
  `CODSOLICITUDEXONERACION` CHAR(4) NOT NULL ,
  `CODALUMNO` INT(11) NOT NULL ,
  `DOCSUSTENTATORIO` MEDIUMBLOB NULL DEFAULT NULL ,
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  `FECHAREGISTRO` DATE NULL ,
  `CODASIGNATURA` INT(11) NULL DEFAULT NULL ,
  `OBSERVACION` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODSOLICITUDEXONERACION`) ,
  INDEX `SOLICITUDEXONERACION_ALUMNO_FK` (`CODALUMNO` ASC) ,
  INDEX `SOLICITUDEXONERACION_ASIGNATURA_FK` (`CODASIGNATURA` ASC) ,
  CONSTRAINT `SOLICITUDEXONERACION_ALUMNO_FK`
    FOREIGN KEY (`CODALUMNO` )
    REFERENCES `bd_proy_SGAE`.`alumno` (`CODALUMNO` ),
  CONSTRAINT `SOLICITUDEXONERACION_ASIGNATURA_FK`
    FOREIGN KEY (`CODASIGNATURA` )
    REFERENCES `bd_proy_SGAE`.`asignatura` (`CODASIGNATURA` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`solicitudretiro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`solicitudretiro` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`solicitudretiro` (
  `CODSOLICITUDRETIRO` CHAR(4) NOT NULL ,
  `CODALUMNO` INT(11) NOT NULL ,
  `DOCSUSTENTATORIO` MEDIUMBLOB NULL DEFAULT NULL ,
  `MOTIVO` VARCHAR(25) NULL DEFAULT NULL ,
  `ESTADO` VARCHAR(15) NULL DEFAULT NULL ,
  `FECHAREGISTRO` DATE NULL ,
  `CODCERTIFICADO` INT(11) NULL DEFAULT NULL ,
  `OBSERVACION` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`CODSOLICITUDRETIRO`) ,
  INDEX `SOLICITUDRETIRO_ALUMNO_FK` (`CODALUMNO` ASC) ,
  INDEX `SOLICITUDRETIRO_CERTIFICADOAS_FK` (`CODCERTIFICADO` ASC) ,
  CONSTRAINT `SOLICITUDRETIRO_ALUMNO_FK`
    FOREIGN KEY (`CODALUMNO` )
    REFERENCES `bd_proy_SGAE`.`alumno` (`CODALUMNO` ),
  CONSTRAINT `SOLICITUDRETIRO_CERTIFICADOAS_FK`
    FOREIGN KEY (`CODCERTIFICADO` )
    REFERENCES `bd_proy_SGAE`.`certificadoas` (`CODCERTIFICADO` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_proy_SGAE`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_proy_SGAE`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `bd_proy_SGAE`.`usuario` (
  `IDLOGIN` INT NOT NULL AUTO_INCREMENT ,
  `CODPERSONA` INT(11) NOT NULL ,
  `CODPERFIL` CHAR(4) NOT NULL ,
  `CONTRASENA` VARCHAR(12) CHARACTER SET 'latin1' COLLATE 'latin1_bin' NULL DEFAULT NULL ,
  PRIMARY KEY (`IDLOGIN`) ,
  INDEX `USUARIO_PERFIL_FK` (`CODPERFIL` ASC) ,
  INDEX `USUARIO_PERSONA_FK` (`CODPERSONA` ASC) ,
  CONSTRAINT `USUARIO_PERFIL_FK`
    FOREIGN KEY (`CODPERFIL` )
    REFERENCES `bd_proy_SGAE`.`perfil` (`CODPERFIL` ),
  CONSTRAINT `USUARIO_PERSONA_FK`
    FOREIGN KEY (`CODPERSONA` )
    REFERENCES `bd_proy_SGAE`.`persona` (`CODPERSONA` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
