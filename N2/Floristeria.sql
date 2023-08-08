-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: Floristeria
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Arbol`
--

DROP TABLE IF EXISTS `Arbol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Arbol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `altura` double DEFAULT NULL,
  `FOREIGN KEY (id_producto) REFERENCES Producto(id)` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Arbol`
--

LOCK TABLES `Arbol` WRITE;
/*!40000 ALTER TABLE `Arbol` DISABLE KEYS */;
INSERT INTO `Arbol` VALUES (1,NULL,'encina',39.99,1.5,NULL),(2,NULL,'encina',39.99,1.5,NULL),(3,NULL,'roble',59.99,2.5,NULL),(4,NULL,'castagno',79.99,2.2,NULL),(5,NULL,'alcornoque',39.99,1.2,NULL),(6,NULL,'encina',39.99,1.5,NULL),(7,NULL,'roble',59.99,2.5,NULL),(8,NULL,'castagno',79.99,2.2,NULL),(9,NULL,'alcornoque',39.99,1.2,NULL),(10,NULL,'encina',39.99,1.5,NULL),(11,NULL,'roble',59.99,2.5,NULL),(12,NULL,'castagno',79.99,2.2,NULL),(13,NULL,'alcornoque',39.99,1.2,NULL),(14,NULL,'encina',39.99,1.5,NULL),(15,NULL,'roble',59.99,2.5,NULL),(16,NULL,'castagno',79.99,2.2,NULL),(17,NULL,'alcornoque',39.99,1.2,NULL),(18,NULL,'encina',39.99,1.5,NULL),(19,NULL,'roble',59.99,2.5,NULL),(20,NULL,'castagno',79.99,2.2,NULL),(21,NULL,'alcornoque',39.99,1.2,NULL);
/*!40000 ALTER TABLE `Arbol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Decoracion`
--

DROP TABLE IF EXISTS `Decoracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Decoracion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `material` varchar(45) DEFAULT NULL,
  `FOREIGN KEY (id_producto) REFERENCES Producto(id)` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Decoracion`
--

LOCK TABLES `Decoracion` WRITE;
/*!40000 ALTER TABLE `Decoracion` DISABLE KEYS */;
INSERT INTO `Decoracion` VALUES (1,NULL,'jardinera','19.99','plastico',NULL),(2,NULL,'jardinera','29.99','madera',NULL),(3,NULL,'jardinera','49.99','metal',NULL),(4,NULL,'rocas','9.99','piedra',NULL),(5,NULL,'jardinera','19.99','plastico',NULL),(6,NULL,'jardinera','29.99','madera',NULL),(7,NULL,'jardinera','49.99','metal',NULL),(8,NULL,'rocas','9.99','piedra',NULL);
/*!40000 ALTER TABLE `Decoracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Flor`
--

DROP TABLE IF EXISTS `Flor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Flor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` varchar(45) DEFAULT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `color` varchar(200) DEFAULT NULL,
  `FOREIGN KEY (id_producto) REFERENCES Producto(id)` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Flor`
--

LOCK TABLES `Flor` WRITE;
/*!40000 ALTER TABLE `Flor` DISABLE KEYS */;
INSERT INTO `Flor` VALUES (1,NULL,'rosas',9.99,'rojo',NULL),(2,NULL,'lirios',12.99,'azul',NULL),(3,NULL,'margaritas',7.99,'amarillo',NULL);
/*!40000 ALTER TABLE `Flor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Producto` (
  `id` int(11) NOT NULL,
  `precio` double NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `FOREIGN KEY (ticketId) REFERENCES Ticket(id)` varchar(45) DEFAULT NULL,
  `FOREIGN KEY (floristeriaId) REFERENCES Floristeria(id)` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-08  1:48:40
