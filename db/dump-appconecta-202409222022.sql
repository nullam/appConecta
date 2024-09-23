-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: appconecta
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `id_auto` int NOT NULL AUTO_INCREMENT,
  `placa` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `chasis` varchar(100) NOT NULL,
  `color` varchar(100) NOT NULL,
  `id_usuario` int NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_auto`),
  KEY `auto_usuario_fk` (`id_usuario`),
  CONSTRAINT `auto_usuario_fk` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'ADF-1234','Renault','Tyggo 7 pro','AD12762GF43785','Rojo',1,1);
INSERT INTO `auto` VALUES (2,'ADF-1234','Cherry','Tyggo 7 pro','AD12762GF43785','Rojo',1,1);
INSERT INTO `auto` VALUES (3,'ADF-1234','Cherry','Tyggo 7 pro','AD12762GF43785','Rojo',3,1);
INSERT INTO `auto` VALUES (4,'ADF-1234','Cherry','Tyggo 7 pro','AD12762GF43785','Rojo',3,1);
INSERT INTO `auto` VALUES (5,'ADF-1234','Cherry','Tyggo 7 pro','AD12762GF43785','Rojo',3,1);
INSERT INTO `auto` VALUES (6,'ADF-1234','Cherry','Tyggo 7 pro','AD12762GF43785','Rojo',3,1);
INSERT INTO `auto` VALUES (7,'ADF-1234','Cherry','Tyggo 7 pro','AD12762GF43785','Rojo',3,1);
INSERT INTO `auto` VALUES (8,'ABC-1234','pruebas','pruebas','pruebas','pruebas',2,1);
INSERT INTO `auto` VALUES (9,'ABC-1234','pruebas','pruebas','pruebas','pruebas',2,1);
INSERT INTO `auto` VALUES (10,'ABC-1234','pruebas','pruebas','pruebas','pruebas',2,1);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `edad` int DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Ely Sanchez',35,'Quito',0);
INSERT INTO `usuario` VALUES (2,'Ely Sanchez',35,NULL,0);
INSERT INTO `usuario` VALUES (3,'Ely Sanchez',35,NULL,1);
INSERT INTO `usuario` VALUES (4,'Ely Sanchez',35,NULL,1);
INSERT INTO `usuario` VALUES (5,'Ely Sanchez',35,NULL,1);
INSERT INTO `usuario` VALUES (6,'Ely Sanchez',35,NULL,1);
INSERT INTO `usuario` VALUES (7,'Ely Sanchez',35,NULL,1);
INSERT INTO `usuario` VALUES (8,'Ely Sanchez',35,NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'appconecta'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-22 20:22:22
