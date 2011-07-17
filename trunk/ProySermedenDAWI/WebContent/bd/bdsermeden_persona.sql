CREATE DATABASE  IF NOT EXISTS `bdsermeden` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bdsermeden`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
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
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
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
  CONSTRAINT `fk_persona_especialidad1` FOREIGN KEY (`idEspecialidad`) REFERENCES `especialidad` (`idEspecialidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'44853428','Rhandy','Muguruza','Vega','1986-03-11 00:00:00','H','freddy_16512@hotmail.com','6554305','972703720','Calle 3 Lote 9 Los Olivos','Observando todo',NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-07-15  3:18:42
