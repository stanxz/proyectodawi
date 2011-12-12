-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: bd_proy_sgae
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
-- Current Database: `bd_proy_sgae`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bd_proy_sgae` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bd_proy_sgae`;

--
-- Table structure for table `aca`
--

DROP TABLE IF EXISTS `aca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aca` (
  `CODPERSONA` varchar(11) NOT NULL,
  PRIMARY KEY (`CODPERSONA`),
  CONSTRAINT `fk_ACA_persona1` FOREIGN KEY (`CODPERSONA`) REFERENCES `persona` (`CODPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aca`
--

LOCK TABLES `aca` WRITE;
/*!40000 ALTER TABLE `aca` DISABLE KEYS */;
/*!40000 ALTER TABLE `aca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad` (
  `CODACTIVIDAD` int(11) NOT NULL AUTO_INCREMENT,
  `CODCALENDARIO` char(4) DEFAULT NULL,
  `NOMBREACTIVIDAD` varchar(30) DEFAULT NULL,
  `FECHAINI` date DEFAULT NULL,
  `FECHAFIN` date DEFAULT NULL,
  PRIMARY KEY (`CODACTIVIDAD`),
  KEY `FK_actividad_calendario` (`CODCALENDARIO`),
  CONSTRAINT `FK_actividad_calendario` FOREIGN KEY (`CODCALENDARIO`) REFERENCES `calendarioacademico` (`CODCALENDARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ada`
--

DROP TABLE IF EXISTS `ada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ada` (
  `CODPERSONA` varchar(11) NOT NULL,
  PRIMARY KEY (`CODPERSONA`),
  CONSTRAINT `fk_evaluador_persona1` FOREIGN KEY (`CODPERSONA`) REFERENCES `persona` (`CODPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ada`
--

LOCK TABLES `ada` WRITE;
/*!40000 ALTER TABLE `ada` DISABLE KEYS */;
/*!40000 ALTER TABLE `ada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `CODALUMNO` varchar(11) NOT NULL,
  `CODAPODERADO` varchar(11) NOT NULL,
  `NOMBRES` varchar(40) DEFAULT NULL,
  `APELLIDOPAT` varchar(20) DEFAULT NULL,
  `APELLIDOMAT` varchar(20) DEFAULT NULL,
  `FECNAC` datetime DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  `SEXO` int(11) DEFAULT NULL,
  `DNI` int(8) DEFAULT NULL,
  `IDDISTRITO` int(11) NOT NULL,
  PRIMARY KEY (`CODALUMNO`),
  KEY `ALUMNO_APODERADO_FK` (`CODAPODERADO`),
  KEY `fk_alumno_distrito1` (`IDDISTRITO`),
  CONSTRAINT `ALUMNO_APODERADO_FK` FOREIGN KEY (`CODAPODERADO`) REFERENCES `apoderado` (`CODAPODERADO`),
  CONSTRAINT `fk_alumno_distrito1` FOREIGN KEY (`IDDISTRITO`) REFERENCES `distrito` (`iddistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`CODALUMNO`, `CODAPODERADO`, `NOMBRES`, `APELLIDOPAT`, `APELLIDOMAT`, `FECNAC`, `ESTADO`, `SEXO`, `DNI`, `IDDISTRITO`) VALUES ('AL-30303030','PE-18181818','Lionelo','Messi','Caraccitti','2011-11-25 00:00:00','MATRICULADO',1,30303030,2);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apoderado`
--

DROP TABLE IF EXISTS `apoderado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apoderado` (
  `CODAPODERADO` varchar(11) NOT NULL,
  PRIMARY KEY (`CODAPODERADO`),
  CONSTRAINT `APODERADO_PERSONA_FK` FOREIGN KEY (`CODAPODERADO`) REFERENCES `persona` (`CODPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apoderado`
--

LOCK TABLES `apoderado` WRITE;
/*!40000 ALTER TABLE `apoderado` DISABLE KEYS */;
INSERT INTO `apoderado` (`CODAPODERADO`) VALUES ('PE-10101010'),('PE-11111111'),('PE-18181818'),('PE-44853428'),('PE-33333333'),('PE-88888888');
/*!40000 ALTER TABLE `apoderado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignatura` (
  `CODASIGNATURA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `ESTADO` varchar(45) DEFAULT NULL,
  `GRADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODASIGNATURA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` (`CODASIGNATURA`, `NOMBRE`, `ESTADO`, `GRADO`) VALUES (1,'Matematica 1','Deshabilitado',3);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistentasocial`
--

DROP TABLE IF EXISTS `asistentasocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistentasocial` (
  `CODASISTENTASOCIAL` varchar(11) NOT NULL,
  `CONSULTORIO` char(3) DEFAULT NULL,
  PRIMARY KEY (`CODASISTENTASOCIAL`),
  CONSTRAINT `ASISTENTASOCIAL_PERSONA_FK` FOREIGN KEY (`CODASISTENTASOCIAL`) REFERENCES `persona` (`CODPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistentasocial`
--

LOCK TABLES `asistentasocial` WRITE;
/*!40000 ALTER TABLE `asistentasocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistentasocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletapago`
--

DROP TABLE IF EXISTS `boletapago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletapago` (
  `CODBOLETA` char(8) NOT NULL DEFAULT '',
  `CODAPODERADO` varchar(11) NOT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `MONTO` double DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`CODBOLETA`),
  KEY `FK_boletapago_apoderado` (`CODAPODERADO`),
  CONSTRAINT `FK_boletapago_apoderado` FOREIGN KEY (`CODAPODERADO`) REFERENCES `apoderado` (`CODAPODERADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletapago`
--

LOCK TABLES `boletapago` WRITE;
/*!40000 ALTER TABLE `boletapago` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletapago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendarioacademico`
--

DROP TABLE IF EXISTS `calendarioacademico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendarioacademico` (
  `CODCALENDARIO` char(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`CODCALENDARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendarioacademico`
--

LOCK TABLES `calendarioacademico` WRITE;
/*!40000 ALTER TABLE `calendarioacademico` DISABLE KEYS */;
INSERT INTO `calendarioacademico` (`CODCALENDARIO`) VALUES ('2011');
/*!40000 ALTER TABLE `calendarioacademico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificadoas`
--

DROP TABLE IF EXISTS `certificadoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificadoas` (
  `CODCERTIFICADO` int(11) NOT NULL AUTO_INCREMENT,
  `CODCITA` int(11) NOT NULL,
  `OBSERVACION` varchar(200) DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`CODCERTIFICADO`),
  KEY `CERTIFICADOAS_CITA_FK` (`CODCITA`),
  CONSTRAINT `CERTIFICADOAS_CITA_FK` FOREIGN KEY (`CODCITA`) REFERENCES `cita` (`CODCITA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificadoas`
--

LOCK TABLES `certificadoas` WRITE;
/*!40000 ALTER TABLE `certificadoas` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificadoas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cita` (
  `CODCITA` int(11) NOT NULL,
  `CODALUMNO` varchar(11) NOT NULL,
  `CODTIPOSERVICIO` int(11) NOT NULL,
  `CODASISTENTASOCIAL` varchar(11) NOT NULL,
  `CORREOPERSONAL` varchar(60) DEFAULT NULL,
  `TLFFIJO` char(8) DEFAULT NULL,
  `TLFCELULAR` char(9) DEFAULT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  `CODDISPONIBILIDADAS` char(4) NOT NULL,
  PRIMARY KEY (`CODCITA`),
  KEY `CITA_TIPOSERVICIOAS_FK` (`CODTIPOSERVICIO`),
  KEY `CITA_ALUMNO_FK` (`CODALUMNO`),
  KEY `CITA_ASISTENTASOCIAL_FK` (`CODASISTENTASOCIAL`),
  KEY `CITA_HORARIO` (`CODASISTENTASOCIAL`),
  KEY `CITA_HORARIO_FK` (`CODASISTENTASOCIAL`,`CODDISPONIBILIDADAS`),
  CONSTRAINT `CITA_ALUMNO_FK` FOREIGN KEY (`CODALUMNO`) REFERENCES `alumno` (`CODALUMNO`),
  CONSTRAINT `CITA_HORARIO_FK` FOREIGN KEY (`CODASISTENTASOCIAL`, `CODDISPONIBILIDADAS`) REFERENCES `horario` (`CODASISTENTASOCIAL`, `CODDISPONIBILIDADAS`),
  CONSTRAINT `CITA_TIPOSERVICIOAS_FK` FOREIGN KEY (`CODTIPOSERVICIO`) REFERENCES `tiposervicioas` (`CODTIPOSERVICIO`)
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
-- Table structure for table `detallemotivo`
--

DROP TABLE IF EXISTS `detallemotivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallemotivo` (
  `CODMOTIVO` int(11) NOT NULL AUTO_INCREMENT,
  `CODCERTIFICADO` int(11) NOT NULL,
  `DESCOTROS` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`CODMOTIVO`,`CODCERTIFICADO`),
  KEY `DETALLEMOTIVO_CERTIFICADOAS_FK` (`CODCERTIFICADO`),
  CONSTRAINT `DETALLEMOTIVO_CERTIFICADOAS_FK` FOREIGN KEY (`CODCERTIFICADO`) REFERENCES `certificadoas` (`CODCERTIFICADO`),
  CONSTRAINT `DETALLEMOTIVO_MOTIVO_FK` FOREIGN KEY (`CODMOTIVO`) REFERENCES `motivo` (`CODMOTIVO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallemotivo`
--

LOCK TABLES `detallemotivo` WRITE;
/*!40000 ALTER TABLE `detallemotivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallemotivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleperfil`
--

DROP TABLE IF EXISTS `detalleperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleperfil` (
  `CODPERMISO` char(4) NOT NULL,
  `CODPERFIL` char(4) NOT NULL,
  PRIMARY KEY (`CODPERMISO`,`CODPERFIL`),
  KEY `DETALLEPERFIL_PERFIL_FK` (`CODPERFIL`),
  CONSTRAINT `DETALLEPERFIL_PERFIL_FK` FOREIGN KEY (`CODPERFIL`) REFERENCES `perfil` (`CODPERFIL`),
  CONSTRAINT `DETALLEPERFIL_PERMISO_FK` FOREIGN KEY (`CODPERMISO`) REFERENCES `permiso` (`CODPERMISO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleperfil`
--

LOCK TABLES `detalleperfil` WRITE;
/*!40000 ALTER TABLE `detalleperfil` DISABLE KEYS */;
INSERT INTO `detalleperfil` (`CODPERMISO`, `CODPERFIL`) VALUES ('pm01','pf01'),('pm02','pf01'),('pm03','pf01'),('pm04','pf02'),('pm07','pf03'),('pm09','pf03'),('pm10','pf05'),('pm07','pf06'),('pm08','pf06'),('pm09','pf06'),('pm06','pf07'),('pm05','pf08');
/*!40000 ALTER TABLE `detalleperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallerestriccion`
--

DROP TABLE IF EXISTS `detallerestriccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallerestriccion` (
  `CODALUMNO` varchar(11) NOT NULL DEFAULT '0',
  `CODRESTRICION` int(11) NOT NULL DEFAULT '0',
  `FECHAINI` date DEFAULT NULL,
  `FECHAFIN` date DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`CODALUMNO`,`CODRESTRICION`),
  KEY `FK_detallerestriccion_restriccion` (`CODRESTRICION`),
  CONSTRAINT `FK_detallerestriccion_alumno` FOREIGN KEY (`CODALUMNO`) REFERENCES `alumno` (`CODALUMNO`),
  CONSTRAINT `FK_detallerestriccion_restriccion` FOREIGN KEY (`CODRESTRICION`) REFERENCES `restriccion` (`CODRESTRICCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallerestriccion`
--

LOCK TABLES `detallerestriccion` WRITE;
/*!40000 ALTER TABLE `detallerestriccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallerestriccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disponibilidadasistentasocial`
--

DROP TABLE IF EXISTS `disponibilidadasistentasocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disponibilidadasistentasocial` (
  `FECHAREGISTRO` date DEFAULT NULL,
  `HORAINICIO` varchar(8) NOT NULL DEFAULT '',
  `HORAFIN` varchar(8) NOT NULL DEFAULT '',
  `CODDISPONIBILIDADAS` char(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`CODDISPONIBILIDADAS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disponibilidadasistentasocial`
--

LOCK TABLES `disponibilidadasistentasocial` WRITE;
/*!40000 ALTER TABLE `disponibilidadasistentasocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `disponibilidadasistentasocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `iddistrito` int(11) NOT NULL,
  `nombreDis` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`iddistrito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` (`iddistrito`, `nombreDis`) VALUES (1,'Cercado'),(2,'Ancon'),(3,'Ate'),(4,'Barranco'),(5,'BreÃ±a'),(6,'Carabayllo'),(7,'Comas'),(8,'Chaclacayo'),(9,'Chorrillos'),(10,'El Agustino'),(11,'Jesus Maria'),(12,'La Molina'),(13,'La Victoria'),(14,'Lince'),(15,'Lurigancho'),(16,'Lurin'),(17,'Magdalena'),(18,'Miraflores'),(19,'Pachacamac'),(20,'Pucusana'),(21,'Pueblo Libre'),(22,'Puente Piedra'),(23,'Punta Negra'),(24,'Punta Hermosa'),(25,'Rimac'),(26,'San Bartolo'),(27,'San Isidro'),(28,'Independencia'),(29,'San Juan De Miraflores'),(30,'San Luis'),(31,'San Martin De Porres'),(32,'San Miguel'),(33,'Santiago De Surco'),(34,'Surquillo'),(35,'Villa Maria Del Triunfo'),(36,'San Juan De Lurigancho'),(37,'Santa Maria Del Mar'),(38,'Santa Rosa'),(39,'Los Olivos'),(40,'Cieneguilla'),(41,'San Borja'),(42,'Villa El Salvador'),(43,'Santa Anita'),(44,' Cercado Callao'),(45,' Bellavista'),(46,' Carmen de la Legua'),(47,' La Perla'),(48,' La Punta'),(49,' Ventanilla');
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `CODASISTENTASOCIAL` varchar(11) NOT NULL,
  `CODDISPONIBILIDADAS` char(4) NOT NULL,
  `ESTADO` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`CODASISTENTASOCIAL`,`CODDISPONIBILIDADAS`),
  KEY `HORARIO_DISPONIBILIDAD` (`CODDISPONIBILIDADAS`),
  CONSTRAINT `HORARIO_ASISTENTA` FOREIGN KEY (`CODASISTENTASOCIAL`) REFERENCES `asistentasocial` (`CODASISTENTASOCIAL`),
  CONSTRAINT `HORARIO_DISPONIBILIDAD` FOREIGN KEY (`CODDISPONIBILIDADAS`) REFERENCES `disponibilidadasistentasocial` (`CODDISPONIBILIDADAS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `idmatricula` int(11) NOT NULL,
  `CODALUMNO` varchar(11) NOT NULL,
  `idseccionprogramada` int(11) NOT NULL,
  `CODCALENDARIO` char(4) NOT NULL,
  `fechamat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmatricula`),
  KEY `fk_alumno_has_seccionprogramada_seccionprogramada1` (`idseccionprogramada`),
  KEY `fk_alumno_has_seccionprogramada_alumno1` (`CODALUMNO`),
  KEY `fk_matricula_calendarioacademico1` (`CODCALENDARIO`),
  CONSTRAINT `fk_alumno_has_seccionprogramada_alumno1` FOREIGN KEY (`CODALUMNO`) REFERENCES `alumno` (`CODALUMNO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_has_seccionprogramada_seccionprogramada1` FOREIGN KEY (`idseccionprogramada`) REFERENCES `seccionprogramada` (`idseccionprogramada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_calendarioacademico1` FOREIGN KEY (`CODCALENDARIO`) REFERENCES `calendarioacademico` (`CODCALENDARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivo`
--

DROP TABLE IF EXISTS `motivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivo` (
  `CODMOTIVO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`CODMOTIVO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivo`
--

LOCK TABLES `motivo` WRITE;
/*!40000 ALTER TABLE `motivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `CODPERFIL` char(4) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CODPERFIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`CODPERFIL`, `NOMBRE`, `DESCRIPCION`) VALUES ('pf01','Apoderado','Persona responsable de un determinado alumno de la Institucion Educativa'),('pf02','Asistenta Social','Persona encargada de brindar apoyo  social a los alumnos de la institucion'),('pf03','Secretaria','Persona encargada la evaluacion de tramites de la Institucion Educativa'),('pf04','No asignado','No asignado'),('pf05','Director General','Persona que visualiza los reportes'),('pf06','Administrador','Persona con privilegios para usar los mantenimientos'),('pf07','Asistente de Coordinacion','Persona que puede Evaluar las solicitudes de Exoneracion'),('pf08','Asistente de Direccion','Persona que puede Evaluar las solicitudes de retiro');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `CODPERMISO` char(4) NOT NULL,
  `NOMBRE` varchar(80) DEFAULT NULL,
  `DESCRIPCION` varchar(200) DEFAULT NULL,
  `ENLACE` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CODPERMISO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` (`CODPERMISO`, `NOMBRE`, `DESCRIPCION`, `ENLACE`) VALUES ('pm01','Solicitar Cita','Usted puede solicitar una cita con la asistenta social del tipo: \\\"Entrevista Personal\\\" en una fecha determinada','citas/solicitarCitaAS.xhtml'),('pm02','Solicitar Retiro','Iniciar tramite para retirar al alumno de la institucion educativa','retiro/solicitarRetiroAlumno.xhtml'),('pm03','Solicitar Exoneracion','Usted puede solicitar la exoneracion de las asignaturas de \\\"Religion\\\" y \\\"Educacion Fisica\\\". NOTA: Consulte el calendario academico para ver la fecha limite de solicitud','exoneracion/solicitarExonAsignatura.xhtml'),('pm04','Evaluar citas pendientes','Evalue las citas del dia y genere un certificado de lo acontecido','citas/evaluarCitas.xhtml'),('pm05','Evaluar solicitudes de retiro','Evalue los motivos de una determinada solicitud de retiro','retiro/evaluarSolicitud.xhtml'),('pm06','Evaluar solicitudes de exoneracion','Evalue los motivos de una determinada solicitud de exoneracion de asignatura','exoneracion/evaluarSolExon.xhtml'),('pm07','Listar/Mantener Alumno','Usted puede buscar, agregar y/o modificar alumnos','mantenimientos/listadoAlumnos.xhtml'),('pm08','Listar/Mantener Empleado','Usted puede buscar, agregar y/o modificar empleados','mantenimientos/listadoEmpleados.xhtml'),('pm09','Listar/Mantener Asignatura','Usted puede buscar, agregar y/o modificar asignatura','mantenimientos/listadoAsignaturas.xhtml'),('pm10','Generar Reportes','Usted puede generar reportes y visualizarlos','reportes/generaReportes.xhtml');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `CODPERSONA` varchar(11) NOT NULL,
  `NOMBRES` varchar(80) DEFAULT NULL,
  `APELLIDOPAT` varchar(80) DEFAULT NULL,
  `APELLIDOMAT` varchar(80) DEFAULT NULL,
  `DIRECCION` varchar(60) DEFAULT NULL,
  `EMAIL` varchar(80) DEFAULT NULL,
  `TELEFONO` varchar(10) DEFAULT NULL,
  `CELULAR` varchar(15) DEFAULT NULL,
  `SEXO` int(11) DEFAULT NULL,
  `DNI` int(8) DEFAULT NULL,
  `IDDISTRITO` int(11) NOT NULL,
  PRIMARY KEY (`CODPERSONA`),
  KEY `fk_persona_distrito1` (`IDDISTRITO`),
  CONSTRAINT `fk_persona_distrito1` FOREIGN KEY (`IDDISTRITO`) REFERENCES `distrito` (`iddistrito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`CODPERSONA`, `NOMBRES`, `APELLIDOPAT`, `APELLIDOMAT`, `DIRECCION`, `EMAIL`, `TELEFONO`, `CELULAR`, `SEXO`, `DNI`, `IDDISTRITO`) VALUES ('PE-10101010','Jorge','Rojas','De la Cruz',NULL,NULL,NULL,NULL,1,10101010,1),('PE-11111111','Rodrigo','Berrospi','Gutierrez',NULL,'rmberrospig@gmail.com',NULL,NULL,1,11111111,2),('PE-12121212','Carlos','Mendez','Nosequemas',NULL,'angelogaceto6@hotmail.com',NULL,NULL,1,12121212,3),('PE-13131313','Joe','Guere','Sandioma',NULL,NULL,NULL,NULL,1,13131313,4),('PE-14141414','Adolfo','Gutierrez','Toguchi',NULL,NULL,NULL,NULL,1,14141414,5),('PE-15151515','Gianina','Lujan','Zavaleta',NULL,NULL,NULL,NULL,0,15151515,6),('PE-16161616','Catalina','Gomez','Paredes',NULL,NULL,NULL,NULL,0,16161616,7),('PE-17171717','Raul','Fernandez','Ambolaya',NULL,'jean333_3@hotmail.com',NULL,NULL,1,17171717,8),('PE-18181818','Juan','Vivanco','Fernandez',NULL,NULL,NULL,NULL,1,18181818,9),('PE-19191919','Juan','Perez','Lopez',NULL,NULL,NULL,NULL,1,19191919,10),('PE-20202020','Rhandy','Muguruza','Vega','Coop Magdalena Mz C Lote 9 ','rmuguruza19@gmail.com','5555555','999999999',1,20202020,11),('PE-22222222','Carlos','Alcantara','Villavicencio',NULL,NULL,NULL,NULL,1,22222222,12),('PE-33333333','Pedro','Castillo','Ascencios',NULL,NULL,NULL,NULL,1,33333333,13),('PE-44444444','Ariadna','Ramos','De la Cruz',NULL,NULL,NULL,NULL,0,44444444,14),('PE-55555555','Brenda','Rey','Pacherres',NULL,NULL,NULL,NULL,0,55555555,15),('PE-66666666','Marilda','Lumbre','Mayuri',NULL,NULL,NULL,NULL,0,66666666,16),('PE-77777777','Vilma','Cardenas','Narro',NULL,NULL,NULL,NULL,0,77777777,17),('PE-88888888','Edinso','Goicochea','Ascencios',NULL,NULL,NULL,NULL,1,88888888,18),('PE-44853428','Rhandy','Muguruza','Vega','asdgasd g785','rmuguruza19@gmail.com','465-4633','654978561',1,44853428,47),('PE-99999999','Yaneth','Susanivar','Porras',NULL,'yanet.susanivar@gmail.com',NULL,NULL,0,99999999,19);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restriccion`
--

DROP TABLE IF EXISTS `restriccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restriccion` (
  `CODRESTRICCION` int(11) NOT NULL DEFAULT '0',
  `NOMBRE` varchar(45) DEFAULT NULL,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CODRESTRICCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restriccion`
--

LOCK TABLES `restriccion` WRITE;
/*!40000 ALTER TABLE `restriccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `restriccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccionprogramada`
--

DROP TABLE IF EXISTS `seccionprogramada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seccionprogramada` (
  `idseccionprogramada` int(11) NOT NULL AUTO_INCREMENT,
  `grado` int(11) DEFAULT NULL,
  `seccion` varchar(2) DEFAULT NULL,
  `nivel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idseccionprogramada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccionprogramada`
--

LOCK TABLES `seccionprogramada` WRITE;
/*!40000 ALTER TABLE `seccionprogramada` DISABLE KEYS */;
INSERT INTO `seccionprogramada` (`idseccionprogramada`,`grado`,`seccion`,`nivel`) VALUES 
 (1,1,'A','PRIMARIA'),
 (2,1,'B','PRIMARIA'),
 (3,1,'C','PRIMARIA'),
 (4,2,'A','PRIMARIA'),
 (5,2,'B','PRIMARIA'),
 (6,2,'C','PRIMARIA'),
 (7,3,'A','PRIMARIA'),
 (8,3,'B','PRIMARIA'),
 (9,3,'C','PRIMARIA'),
 (10,4,'A','PRIMARIA'),
 (11,4,'B','PRIMARIA'),
 (12,4,'C','PRIMARIA'),
 (13,5,'A','PRIMARIA'),
 (14,5,'B','PRIMARIA'),
 (15,5,'C','PRIMARIA'),
 (16,6,'A','PRIMARIA'),
 (17,6,'B','PRIMARIA'),
 (18,6,'C','PRIMARIA'),
 (19,1,'A','SECUNDARIA'),
 (20,1,'B','SECUNDARIA'),
 (21,1,'C','SECUNDARIA'),
 (22,2,'A','SECUNDARIA'),
 (23,2,'B','SECUNDARIA'),
 (24,2,'C','SECUNDARIA'),
 (25,3,'A','SECUNDARIA'),
 (26,3,'B','SECUNDARIA'),
 (27,3,'C','SECUNDARIA'),
 (28,4,'A','SECUNDARIA'),
 (29,4,'B','SECUNDARIA'),
 (30,4,'C','SECUNDARIA'),
 (31,5,'A','SECUNDARIA'),
 (32,5,'B','SECUNDARIA'),
 (33,5,'C','SECUNDARIA');
/*!40000 ALTER TABLE `seccionprogramada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretaria`
--

DROP TABLE IF EXISTS `secretaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretaria` (
  `CODSECRETARIA` varchar(11) NOT NULL,
  PRIMARY KEY (`CODSECRETARIA`),
  CONSTRAINT `SECRETARIA_PERSONA_FK` FOREIGN KEY (`CODSECRETARIA`) REFERENCES `persona` (`CODPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretaria`
--

LOCK TABLES `secretaria` WRITE;
/*!40000 ALTER TABLE `secretaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `secretaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudexoneracion`
--

DROP TABLE IF EXISTS `solicitudexoneracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitudexoneracion` (
  `CODSOLICITUDEXONERACION` char(4) NOT NULL,
  `CODALUMNO` varchar(11) NOT NULL,
  `DOCSUSTENTATORIO` mediumblob,
  `ESTADO` varchar(15) DEFAULT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `CODASIGNATURA` int(11) DEFAULT NULL,
  `OBSERVACION` varchar(255) DEFAULT NULL,
  `FLAGPROCESADO` int(11) DEFAULT NULL,
  `CODACA` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`CODSOLICITUDEXONERACION`),
  KEY `SOLICITUDEXONERACION_ALUMNO_FK` (`CODALUMNO`),
  KEY `SOLICITUDEXONERACION_ASIGNATURA_FK` (`CODASIGNATURA`),
  KEY `fk_solicitudexoneracion_ACA1` (`CODACA`),
  CONSTRAINT `fk_solicitudexoneracion_ACA1` FOREIGN KEY (`CODACA`) REFERENCES `aca` (`CODPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SOLICITUDEXONERACION_ALUMNO_FK` FOREIGN KEY (`CODALUMNO`) REFERENCES `alumno` (`CODALUMNO`),
  CONSTRAINT `SOLICITUDEXONERACION_ASIGNATURA_FK` FOREIGN KEY (`CODASIGNATURA`) REFERENCES `asignatura` (`CODASIGNATURA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudexoneracion`
--

LOCK TABLES `solicitudexoneracion` WRITE;
/*!40000 ALTER TABLE `solicitudexoneracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudexoneracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudretiro`
--

DROP TABLE IF EXISTS `solicitudretiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitudretiro` (
  `CODSOLICITUDRETIRO` char(4) NOT NULL,
  `CODALUMNO` varchar(11) NOT NULL,
  `DOCSUSTENTATORIO` mediumblob,
  `MOTIVO` varchar(25) DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `CODCERTIFICADO` int(11) DEFAULT NULL,
  `OBSERVACION` varchar(255) DEFAULT NULL,
  `FLAGPROCESADO` int(11) DEFAULT NULL,
  `CODADA` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`CODSOLICITUDRETIRO`),
  KEY `SOLICITUDRETIRO_ALUMNO_FK` (`CODALUMNO`),
  KEY `SOLICITUDRETIRO_CERTIFICADOAS_FK` (`CODCERTIFICADO`),
  KEY `fk_solicitudretiro_ADA1` (`CODADA`),
  CONSTRAINT `fk_solicitudretiro_ADA1` FOREIGN KEY (`CODADA`) REFERENCES `ada` (`CODPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SOLICITUDRETIRO_ALUMNO_FK` FOREIGN KEY (`CODALUMNO`) REFERENCES `alumno` (`CODALUMNO`),
  CONSTRAINT `SOLICITUDRETIRO_CERTIFICADOAS_FK` FOREIGN KEY (`CODCERTIFICADO`) REFERENCES `certificadoas` (`CODCERTIFICADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudretiro`
--

LOCK TABLES `solicitudretiro` WRITE;
/*!40000 ALTER TABLE `solicitudretiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudretiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposervicioas`
--

DROP TABLE IF EXISTS `tiposervicioas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposervicioas` (
  `CODTIPOSERVICIO` int(11) NOT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `DESCRIPCION` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`CODTIPOSERVICIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposervicioas`
--

LOCK TABLES `tiposervicioas` WRITE;
/*!40000 ALTER TABLE `tiposervicioas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiposervicioas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `IDLOGIN` int(11) NOT NULL AUTO_INCREMENT,
  `CODPERSONA` varchar(11) NOT NULL,
  `CODPERFIL` char(4) NOT NULL,
  `CONTRASENA` varchar(12) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  PRIMARY KEY (`IDLOGIN`),
  KEY `USUARIO_PERFIL_FK` (`CODPERFIL`),
  KEY `USUARIO_PERSONA_FK` (`CODPERSONA`),
  CONSTRAINT `USUARIO_PERFIL_FK` FOREIGN KEY (`CODPERFIL`) REFERENCES `perfil` (`CODPERFIL`),
  CONSTRAINT `USUARIO_PERSONA_FK` FOREIGN KEY (`CODPERSONA`) REFERENCES `persona` (`CODPERSONA`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`IDLOGIN`, `CODPERSONA`, `CODPERFIL`, `CONTRASENA`) VALUES (20,'PE-14141414','pf02','14141414'),(21,'PE-55555555','pf02','55555555'),(22,'PE-13131313','pf02','13131313'),(23,'PE-18181818','pf01','18181818'),(24,'PE-66666666','pf02','66666666'),(25,'PE-17171717','pf07','17171717'),(26,'PE-12121212','pf08','12121212'),(27,'PE-22222222','pf08','22222222'),(28,'PE-88888888','pf01','88888888'),(29,'PE-10101010','pf01','10101010'),(30,'PE-11111111','pf01','11111111'),(31,'PE-33333333','pf01','33333333'),(32,'PE-44444444','pf03','44444444'),(33,'PE-16161616','pf03','16161616'),(34,'PE-99999999','pf03','99999999'),(35,'PE-15151515','pf03','15151515'),(36,'PE-77777777','pf03','77777777'),(37,'PE-20202020','pf05','20202020'),(41,'PE-44853428','pf01','44853428');
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

-- Dump completed on 2011-12-08 13:58:53
