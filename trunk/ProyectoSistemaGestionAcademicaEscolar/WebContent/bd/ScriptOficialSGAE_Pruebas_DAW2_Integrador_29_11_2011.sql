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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `CODALUMNO` int(11) NOT NULL,
  `CODAPODERADO` int(11) NOT NULL,
  `NOMBRES` varchar(40) DEFAULT NULL,
  `APELLIDOPAT` varchar(20) DEFAULT NULL,
  `APELLIDOMAT` varchar(20) DEFAULT NULL,
  `FECNAC` datetime DEFAULT NULL,
  `GRADO` int(11) DEFAULT NULL,
  `SECCION` char(1) DEFAULT NULL,
  `ANOACADEMICO` char(4) DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  `CODCALENDARIO` char(4) DEFAULT NULL,
  `SEXO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODALUMNO`),
  KEY `ALUMNO_APODERADO_FK` (`CODAPODERADO`),
  KEY `FK_alumno_calendario` (`CODCALENDARIO`),
  CONSTRAINT `ALUMNO_APODERADO_FK` FOREIGN KEY (`CODAPODERADO`) REFERENCES `apoderado` (`CODAPODERADO`),
  CONSTRAINT `FK_alumno_calendario` FOREIGN KEY (`CODCALENDARIO`) REFERENCES `calendarioacademico` (`CODCALENDARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`CODALUMNO`, `CODAPODERADO`, `NOMBRES`, `APELLIDOPAT`, `APELLIDOMAT`, `FECNAC`, `GRADO`, `SECCION`, `ANOACADEMICO`, `ESTADO`, `CODCALENDARIO`, `SEXO`) VALUES (30303030,18181818,'Lionelo','Messi','Caraccitti','2011-11-25 00:00:00',1,'B','2011','MATRICULADO','2011',1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apoderado`
--

DROP TABLE IF EXISTS `apoderado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apoderado` (
  `CODAPODERADO` int(11) NOT NULL,
  PRIMARY KEY (`CODAPODERADO`),
  CONSTRAINT `APODERADO_PERSONA_FK` FOREIGN KEY (`CODAPODERADO`) REFERENCES `persona` (`CODPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apoderado`
--

LOCK TABLES `apoderado` WRITE;
/*!40000 ALTER TABLE `apoderado` DISABLE KEYS */;
INSERT INTO `apoderado` (`CODAPODERADO`) VALUES (10101010),(11111111),(12121212),(17171717),(18181818),(22222222),(33333333),(55555555),(88888888);
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
  PRIMARY KEY (`CODASIGNATURA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` (`CODASIGNATURA`, `NOMBRE`, `ESTADO`) VALUES (1,'hola','Deshabilitado');
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistentasocial`
--

DROP TABLE IF EXISTS `asistentasocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistentasocial` (
  `CODASISTENTASOCIAL` int(11) NOT NULL AUTO_INCREMENT,
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
  `CODAPODERADO` int(11) NOT NULL DEFAULT '0',
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
  `CODCITA` int(11) NOT NULL DEFAULT '0',
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
  `CODCITA` int(11) NOT NULL AUTO_INCREMENT,
  `CODALUMNO` int(11) NOT NULL,
  `CODTIPOSERVICIO` int(11) NOT NULL,
  `CODASISTENTASOCIAL` int(11) NOT NULL DEFAULT '0',
  `CORREOPERSONAL` varchar(60) DEFAULT NULL,
  `TLFFIJO` char(7) DEFAULT NULL,
  `TLFCELULAR` char(9) DEFAULT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  `CODDISPONIBILIDADAS` char(4) NOT NULL DEFAULT '',
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
-- Table structure for table `detalleasignatura`
--

DROP TABLE IF EXISTS `detalleasignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleasignatura` (
  `ESTADO` varchar(15) DEFAULT NULL,
  `CODASIGNATURA` int(11) NOT NULL,
  `CODALUMNO` int(11) NOT NULL,
  PRIMARY KEY (`CODASIGNATURA`,`CODALUMNO`),
  KEY `DETALLEASIGNATURA_ALUMNO_FK` (`CODALUMNO`),
  CONSTRAINT `DETALLEASIGNATURA_ALUMNO_FK` FOREIGN KEY (`CODALUMNO`) REFERENCES `alumno` (`CODALUMNO`),
  CONSTRAINT `DETALLEASIGNATURA_ASIGNATURA_FK` FOREIGN KEY (`CODASIGNATURA`) REFERENCES `asignatura` (`CODASIGNATURA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleasignatura`
--

LOCK TABLES `detalleasignatura` WRITE;
/*!40000 ALTER TABLE `detalleasignatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleasignatura` ENABLE KEYS */;
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
INSERT INTO `detalleperfil` (`CODPERMISO`, `CODPERFIL`) VALUES ('pm01','pf01'),('pm02','pf01'),('pm03','pf01'),('pm04','pf02'),('pm05','pf03'),('pm06','pf03'),('pm07','pf03'),('pm09','pf03'),('pm10','pf05'),('pm07','pf06'),('pm08','pf06'),('pm09','pf06');
/*!40000 ALTER TABLE `detalleperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallerestriccion`
--

DROP TABLE IF EXISTS `detallerestriccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallerestriccion` (
  `CODALUMNO` int(11) NOT NULL DEFAULT '0',
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
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `CODASISTENTASOCIAL` int(11) NOT NULL AUTO_INCREMENT,
  `CODDISPONIBILIDADAS` char(4) NOT NULL DEFAULT '',
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
  `NOMBRE` varchar(20) DEFAULT NULL,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CODPERFIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`CODPERFIL`, `NOMBRE`, `DESCRIPCION`) VALUES ('pf01','Apoderado','Persona responsable de un determinado alumno de la Instituci贸n Educativa'),('pf02','Asistenta Social','Persona encargada de brindar apoyo  social a los alumnos de la instituci贸n'),('pf03','Secretaria','Persona encargada la evaluaci贸n de tramites de la Instituci贸n Educativa'),('pf04','No asignado','No asignado'),('pf05','GerenteGeneral','Persona que visualiza los reportes'),('pf06','Administrador','Persona con privilegios para usar los amntenimientos');
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
INSERT INTO `permiso` (`CODPERMISO`, `NOMBRE`, `DESCRIPCION`, `ENLACE`) VALUES ('pm01','Solicitar Cita','Usted puede solicitar una cita con la asistenta social del tipo: \\\"Entrevista Personal\\\" en una fecha determinada','citas/solicitarCitaAS.xhtml'),('pm02','Solicitar Retiro','Iniciar tramite para retirar al alumno de la instituci髇 educativa','retiro/solicitarRetiroAlumno.xhtml'),('pm03','Solicitar Exoneraci髇','Usted puede solicitar la exoneraci髇 de las asignaturas de \\\"Religi髇\\\" y \\\"Educaci髇 F韘ica\\\". NOTA: Consulte el calendario acad閙ico para ver la fecha l韒ite de solicitud','exoneracion/solicitarExonAsignatura.xhtml'),('pm04','Evaluar citas pendientes','Eval鷈 las citas del dia y genere un certificado de lo acontecido','citas/evaluarCitas.xhtml'),('pm05','Evaluar solicitudes de retiro','Eval鷈 los motivos de una determinada solicitud de retiro','retiro/evaluarSolicitud.xhtml'),('pm06','Evaluar solicitudes de exoneraci髇','Eval鷈 los motivos de una determinada solicitud de exoneraci髇 de asignatura','exoneracion/evaluarSolExon.xhtml'),('pm07','Listar/Mantener Alumno','Usted puede buscar, agregar y/o modificar alumnos','mantenimientos/listadoAlumnos.xhtml'),('pm08','Listar/Mantener Empleado','Usted puede buscar, agregar y/o modificar empleados','mantenimientos/listadoEmpleados.xhtml'),('pm09','Listar/Mantener Asignatura','Usted puede buscar, agregar y/o modificar asignatura','mantenimientos/listadoAsignaturas.xhtml'),('pm10','Generar Reportes','Usted puede generar reportes y visualizarlos','reportes/generaReportes.xhtml');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `CODPERSONA` int(11) NOT NULL,
  `NOMBRES` varchar(80) DEFAULT NULL,
  `APELLIDOPAT` varchar(80) DEFAULT NULL,
  `APELLIDOMAT` varchar(80) DEFAULT NULL,
  `DIRECCION` varchar(60) DEFAULT NULL,
  `EMAIL` varchar(80) DEFAULT NULL,
  `TELEFONO` varchar(10) DEFAULT NULL,
  `CELULAR` varchar(15) DEFAULT NULL,
  `SEXO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`CODPERSONA`, `NOMBRES`, `APELLIDOPAT`, `APELLIDOMAT`, `DIRECCION`, `EMAIL`, `TELEFONO`, `CELULAR`, `SEXO`) VALUES (10101010,'Jorge','Rojas','De la Cruz',NULL,NULL,NULL,NULL,1),(11111111,'Rodrigo','Berrospi','Gutierrez',NULL,'rmberrospig@gmail.com',NULL,NULL,1),(12121212,'Carlos','Mendez','Nosequemas',NULL,'angelogaceto6@hotmail.com',NULL,NULL,1),(13131313,'Joe','Guere','Sandioma',NULL,NULL,NULL,NULL,1),(14141414,'Adolfo','Gutierrez','Toguchi',NULL,NULL,NULL,NULL,1),(15151515,'Gianina','Lujan','Zavaleta',NULL,NULL,NULL,NULL,0),(16161616,'Catalina','Gomez','Paredes',NULL,NULL,NULL,NULL,0),(17171717,'Raul','Fernandez','Ambolaya',NULL,'jean333_3@hotmail.com',NULL,NULL,1),(18181818,'Juan','Vivanco','Fernandez',NULL,NULL,NULL,NULL,1),(19191919,'Juan','Perez','Lopez',NULL,NULL,NULL,NULL,1),(20202020,'Rhandy','Muguruza','Vega','Coop Magdalena Mz C Lote 9 ','rmuguruza19@gmail.com','5555555','999999999',1),(22222222,'Carlos','Alcantara','Villavicencio',NULL,NULL,NULL,NULL,1),(33333333,'Pedro','Castillo','Ascencios',NULL,NULL,NULL,NULL,1),(44444444,'Ariadna','Ramos','De la Cruz',NULL,NULL,NULL,NULL,0),(55555555,'Brenda','Rey','Pacherres',NULL,NULL,NULL,NULL,0),(66666666,'Marilda','Lumbre','Mayuri',NULL,NULL,NULL,NULL,0),(77777777,'Vilma','Cardenas','Narro',NULL,NULL,NULL,NULL,0),(88888888,'Edinso','Goicochea','Ascencios',NULL,NULL,NULL,NULL,1),(99999999,'Yaneth','Susanivar','Porras',NULL,'yanet.susanivar@gmail.com',NULL,NULL,0);
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
-- Table structure for table `secretaria`
--

DROP TABLE IF EXISTS `secretaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretaria` (
  `CODSECRETARIA` int(11) NOT NULL AUTO_INCREMENT,
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
  `CODALUMNO` int(11) NOT NULL,
  `DOCSUSTENTATORIO` mediumblob,
  `ESTADO` varchar(15) DEFAULT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `CODASIGNATURA` int(11) DEFAULT NULL,
  `OBSERVACION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CODSOLICITUDEXONERACION`),
  KEY `SOLICITUDEXONERACION_ALUMNO_FK` (`CODALUMNO`),
  KEY `SOLICITUDEXONERACION_ASIGNATURA_FK` (`CODASIGNATURA`),
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
  `CODALUMNO` int(11) NOT NULL,
  `DOCSUSTENTATORIO` mediumblob,
  `MOTIVO` varchar(25) DEFAULT NULL,
  `ESTADO` varchar(15) DEFAULT NULL,
  `FECHAREGISTRO` date DEFAULT NULL,
  `CODCERTIFICADO` int(11) DEFAULT NULL,
  `OBSERVACION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CODSOLICITUDRETIRO`),
  KEY `SOLICITUDRETIRO_ALUMNO_FK` (`CODALUMNO`),
  KEY `SOLICITUDRETIRO_CERTIFICADOAS_FK` (`CODCERTIFICADO`),
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
  `CODPERSONA` int(11) NOT NULL,
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
INSERT INTO `usuario` (`IDLOGIN`, `CODPERSONA`, `CODPERFIL`, `CONTRASENA`) VALUES (20,14141414,'pf02','14141414'),(21,55555555,'pf02','55555555'),(22,13131313,'pf02','13131313'),(23,18181818,'pf01','18181818'),(24,66666666,'pf02','66666666'),(25,17171717,'pf01','17171717'),(26,12121212,'pf01','12121212'),(27,55555555,'pf01','55555555'),(28,22222222,'pf01','22222222'),(29,88888888,'pf01','88888888'),(30,10101010,'pf01','10101010'),(31,11111111,'pf01','11111111'),(32,33333333,'pf01','33333333'),(33,44444444,'pf03','44444444'),(34,16161616,'pf03','16161616'),(35,99999999,'pf03','99999999'),(36,15151515,'pf03','15151515'),(37,18181818,'pf04','18181818'),(38,77777777,'pf03','77777777'),(39,20202020,'pf05','20202020');
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

-- Dump completed on 2011-11-29 21:44:22
