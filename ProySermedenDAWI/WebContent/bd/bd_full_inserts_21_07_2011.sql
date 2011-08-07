﻿-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: bdsermeden
-- ------------------------------------------------------
-- Server version	5.5.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `bdsermeden`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bdsermeden` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bdsermeden`;

--
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acceso` (
  `idFuncionalidad` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idFuncionalidad`,`idPerfil`),
  KEY `fk_Acceso_perfil1` (`idPerfil`),
  CONSTRAINT `fk_Acceso_funcionalidad1` FOREIGN KEY (`idFuncionalidad`) REFERENCES `funcionalidad` (`idFuncionalidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acceso_perfil1` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` (`idFuncionalidad`, `idPerfil`) VALUES (4,0),(5,0),(9,0),(1,1),(2,1),(6,2),(9,2),(11,2),(3,3),(4,3),(5,3),(9,3),(9,4),(7,5),(8,5),(9,5),(9,6),(11,5),(12,4),(13,6),(14,2);
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cita` (
  `idCita` int(11) NOT NULL AUTO_INCREMENT,
  `idFicha` int(11) NOT NULL,
  `fechaCita` datetime DEFAULT NULL,
  `HoraCita` int(11) DEFAULT NULL,
  `NroConsultorio` int(11) DEFAULT NULL,
  `idMedico` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCita`,`idFicha`),
  KEY `fk_Cita_Ficha1` (`idFicha`),
  CONSTRAINT `fk_Cita_Ficha1` FOREIGN KEY (`idFicha`) REFERENCES `ficha` (`idFicha`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datosmedicospersona`
--

DROP TABLE IF EXISTS `datosmedicospersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE  TABLE IF NOT EXISTS `bdsermeden`.`DatosMedicosPersona` (

  `idPersona` INT NOT NULL ,

  `Cefalea` INT NULL ,

  `Asma` INT NULL ,

  `Alergia` INT NULL ,

  `Otros` INT NULL ,

  `Especificacion` VARCHAR(254) NULL ,

  `Peso` VARCHAR(15) NULL ,

  `Talla` VARCHAR(15) NULL ,

  `PresionArterial` VARCHAR(50) NULL ,

  `GrupoSanguineo` VARCHAR(45) NULL ,

  `Observaciones` VARCHAR(254) NULL ,

  `idDMPaciente` INT NOT NULL AUTO_INCREMENT ,

  PRIMARY KEY (`idDMPaciente`, `idPersona`) ,

  CONSTRAINT `fk_DatosMédicos_persona1`

    FOREIGN KEY (`idPersona` )

    REFERENCES `bdsermeden`.`persona` (`idPersona` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datosmedicospersona`
--

LOCK TABLES `datosmedicospersona` WRITE;
/*!40000 ALTER TABLE `datosmedicospersona` DISABLE KEYS */;
insert into `datosmedicospersona` values(8,0,0,0,0,'','','','','','',null);
insert into `datosmedicospersona` values(9,0,0,0,0,'','','','','','',null);
/*!40000 ALTER TABLE `datosmedicospersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidad` (
  `idEspecialidad` int(11) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEspecialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` (`idEspecialidad`, `Descripcion`) VALUES (0,'ninguna'),(1,'Odontopediatría'),(2,'Endodoncia'),(3,'Cirugía Oral'),(4,'Ortodoncia'),(5,'Periodoncia'),(6,'Prótesis Dental');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ficha`
--

DROP TABLE IF EXISTS `ficha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ficha` (
  `idFicha` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) NOT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `Observaciones` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idFicha`,`idPersona`),
  KEY `fk_Ficha_persona1` (`idPersona`),
  CONSTRAINT `fk_Ficha_persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ficha`
--

LOCK TABLES `ficha` WRITE;
/*!40000 ALTER TABLE `ficha` DISABLE KEYS */;
/*!40000 ALTER TABLE `ficha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionalidad`
--

DROP TABLE IF EXISTS `funcionalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionalidad` (
  `idFuncionalidad` int(11) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `enlace` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFuncionalidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionalidad`
--

LOCK TABLES `funcionalidad` WRITE;
/*!40000 ALTER TABLE `funcionalidad` DISABLE KEYS */;
INSERT INTO `funcionalidad` (`idFuncionalidad`, `descripcion`, `enlace`) VALUES (1,'Nuevo Usuario','NuevoUsuarioAction'),(2,'Modificar Usuario','ListadoAction'),(3,'Registrar Paciente','a_registrarPaciente'),(4,'Registrar Cita','a_registrarCita'),(5,'Buscar Cita','a_listarCitas'),(6,'Actualizar Datos Medicos Paciente','a_ActualizarDMPaciente'),(7,'Actualizar Cita','a_ActualizarCita'),(8,'Registrar Interconsulta','a_registrarInterconsulta'),(9,'Editar Mis Datos','a_MisDatos'),(10,'Buscar Historial Clinico','a_ListaHC'),(11,'Registrar Ficha','a_registrarFicha'),(12,'Cargar Imagenes','a_cargarImagenes'),(14,'Generar Odontograma','a_odontograma');
/*!40000 ALTER TABLE `funcionalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `idPerfil` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPerfil`),
  KEY `fk_Perfil_rol1` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`idPerfil`, `descripcion`) VALUES (0,'Paciente'),(1,'Administrador del Sistema'),(2,'Auxiliar'),(3,'Recepcionista'),(4,'Técnico Imágenes'),(5,'Médico Tratante'),(6,'Médico Especialista');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) DEFAULT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apepat` varchar(60) DEFAULT NULL,
  `apemat` varchar(60) DEFAULT NULL,
  `fechanac` datetime DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fijo` varchar(7) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `observaciones` varchar(500) DEFAULT NULL,
  `idEspecialidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_persona_especialidad1` (`idEspecialidad`),
  CONSTRAINT `fk_persona_especialidad1` FOREIGN KEY (`idEspecialidad`) REFERENCES `especialidad` (`idEspecialidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'44853428','Rhandy','Muguruza','Vega','1986-03-11 00:00:00','H','freddy_16512@hotmail.com','6554305','972703720','Calle 3 Lote 9 Los Olivos','Observando todo',0),(2,'43567823','Juan','Perez','Casas','2011-02-11 00:00:00','H','jperez@hotmail.com','6547812','978978789','Av Alisos 543','Nuevo, llegado de Argentina',0),(3,'23541452','Giuliana','Salas','Mendoza','1984-06-19 00:00:00','M','gsalas@gmail.com','7847711','963358475','Av Alcazar 789 - Rimac','Se encuentra haciendo Serum',0),(4,'15442388','Marcos','Arce','Ortiz','1974-10-08 00:00:00','H','marce@yahoo,com','7874857','977893211','Av Izaguirre 784 - Los Olivos','',0),(5,'77441544','Fiorella','Flores','Suarez','1971-08-12 00:00:00','M','fflores@msn.com','1452789','999332561','Av Palmeras 987 - Los Olivos','',0),(6,'69358666','Rosa','Luna','Campos','1987-04-15 00:00:00','M','rluna@sermeden.com','7845968','879881125','Av Universitaria 1457 - SMP','Practicante',0),(7,'46342251','Ivett','Cisneros','Manrique','1981-12-27 00:00:00','M','icisneros@sermeden.com','7418596','964159822','Av Saenz Pea 5487 - Callao','Tiempo Completo',0),(8,'88888888','Yennsy','Correa','Carhuas','1970-09-17 00:00:00','M','juana0565@hotmail.com','6667777','999887766','Av Su casa 777','ninguna',0),(9,'99999999','Jaime','Moreno','Nosequemas','2011-04-27 00:00:00','H','jmoreno@gmail.com','3231452','785412369','Av Tupac Amaru 8789 - Comas','Todasssss',0),(10,'54789636','Maria','Cervantes','Aquino','1987-01-16 00:00:00','M','mcervantes@yahoo.com','8795412','888756324','Av Canta  Callao 9877 - Callao','',0),(11,'89626967','Paola','Muguruza','Vega','1989-11-16 00:00:00','M','pmuguruza@hotmail.com','2564132','969112458','Calle 3 C Lote 9 - Los Olivos','juazzzzz',0);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `idTurno` int(11) NOT NULL AUTO_INCREMENT,
  `Dia` varchar(20) DEFAULT NULL,
  `HoraInicio` int(11) DEFAULT NULL,
  `HoraFin` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTurno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` (`idTurno`, `Dia`, `HoraInicio`, `HoraFin`) VALUES (1,'Lunes',8,14),(2,'Lunes',14,20),(3,'Martes',8,14),(4,'Martes',14,20),(5,'Miercoles',8,14),(6,'Miercoles',14,20),(7,'Jueves',8,14),(8,'Jueves',14,20),(9,'Viernes',8,14),(10,'Viernes',14,20),(11,'Sabado',8,14),(12,'Sabado',14,20);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnoxmtratante`
--

DROP TABLE IF EXISTS `turnoxmtratante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnoxmtratante` (
  `idTurno` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  PRIMARY KEY (`idTurno`,`idPersona`),
  KEY `fk_TurnoxPersona_persona1` (`idPersona`),
  CONSTRAINT `fk_TurnoxPersona_Turno1` FOREIGN KEY (`idTurno`) REFERENCES `turno` (`idTurno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TurnoxPersona_persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnoxmtratante`
--

LOCK TABLES `turnoxmtratante` WRITE;
/*!40000 ALTER TABLE `turnoxmtratante` DISABLE KEYS */;
INSERT INTO `turnoxmtratante` (`idTurno`, `idPersona`) VALUES (1,2),(5,2),(9,2),(2,3),(6,3),(10,3),(3,4),(7,4),(11,4),(4,5),(8,5),(12,5);
/*!40000 ALTER TABLE `turnoxmtratante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `user` varchar(45) DEFAULT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `idPersona` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idPersona`,`idPerfil`),
  KEY `fk_Usuario_persona` (`idPersona`),
  KEY `fk_usuario_perfil1` (`idPerfil`),
  CONSTRAINT `fk_usuario_perfil1` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`user`, `contrasena`, `estado`, `idPersona`, `idPerfil`) VALUES ('rhandy','12345',1,1,1),('43567823','43567823',1,2,5),('23541452','23541452',1,3,5),('15442388','15442388',1,4,5),('77441544','77441544',1,5,5),('69358666','69358666',1,6,3),('46342251','46342251',1,7,3),('88888888','88888888',1,8,0),('99999999','99999999',1,9,0),('54789636','54789636',1,10,2),('89626967','89626967',1,11,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-07-21  3:15:58