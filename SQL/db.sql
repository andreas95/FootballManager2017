CREATE DATABASE  IF NOT EXISTS `fotballmanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fotballmanager`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: fotballmanager
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `clubs`
--

DROP TABLE IF EXISTS `clubs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clubs` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(75) NOT NULL,
  `COUNTRY` varchar(100) NOT NULL,
  `MP` int(3) DEFAULT '0',
  `W` int(3) DEFAULT '0',
  `D` int(3) DEFAULT '0',
  `L` int(3) DEFAULT '0',
  `GF` int(3) DEFAULT '0',
  `GA` int(3) DEFAULT '0',
  `GD` int(3) DEFAULT '0',
  `PTS` int(3) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubs`
--

LOCK TABLES `clubs` WRITE;
/*!40000 ALTER TABLE `clubs` DISABLE KEYS */;
INSERT INTO `clubs` VALUES (1,'Real Madrid','Spain',46,41,4,1,96,65,31,61),(10,'Barcelona','Spain',0,0,0,0,0,0,0,0),(11,'Atl. Madrid','Spain',0,0,0,0,0,0,0,0),(12,'Sevilla','Spain',0,0,0,0,0,0,0,0),(13,'Villarreal','Spain',0,0,0,0,0,0,0,0),(14,'Real Sociedad','Spain',0,0,0,0,0,0,0,0),(15,'Ath. Bilbao','Spain',0,0,0,0,0,0,0,0),(16,'Espanyol','Spain',0,0,0,0,0,0,0,0),(17,'Alaves','Spain',0,0,0,0,0,0,0,0),(18,'Eibar','Spain',0,0,0,0,0,0,0,0),(19,'Malaga','Spain',0,0,0,0,0,0,0,0),(20,'Valencia','Spain',0,0,0,0,0,0,0,0),(21,'Celta Vigo','Spain',0,0,0,0,0,0,0,0),(22,'Las Palmas','Spain',0,0,0,0,0,0,0,0),(23,'Betis','Spain',0,0,0,0,0,0,0,0),(24,'La Coruna','Spain',0,0,0,0,0,0,0,0),(25,'Leganes','Spain',0,0,0,0,0,0,0,0),(26,'Gijon','Spain',0,0,0,0,0,0,0,0),(27,'Osasuna','Spain',0,0,0,0,0,0,0,0),(28,'Granada','Spain',0,0,0,0,0,0,0,0),(29,'ASA Targu Mures','Romania',0,0,0,0,0,0,0,0),(30,'Astra Giurgiu','Romania',0,0,0,0,0,0,0,0),(31,'CFR Cluj','Romania',0,0,0,0,0,0,0,0),(32,'Concordia Chiajna','Romania',0,0,0,0,0,0,0,0),(33,'CSM Iasi','Romania',0,0,0,0,0,0,0,0),(34,'CS \'U\' Craiova','Romania',0,0,0,0,0,0,0,0),(35,'Dinamo Bucuresti','Romania',0,0,0,0,0,0,0,0),(36,'FC Botosani','Romania',0,0,0,0,0,0,0,0),(37,'FCSB','Romania',0,0,0,0,0,0,0,0),(38,'FC Viitorul','Romania',0,0,0,0,0,0,0,0),(39,'FC Voluntari','Romania',0,0,0,0,0,0,0,0),(40,'Gaz Metan Medias','Romania',0,0,0,0,0,0,0,0),(41,'Pandurii Tg. Jiu','Romania',0,0,0,0,0,0,0,0),(42,'Poli Timisoara','Romania',0,0,0,0,0,0,0,0),(43,'Juventus ','Italy',0,0,0,0,0,0,0,0),(44,'AS Roma','Italy',0,0,0,0,0,0,0,0),(45,'Napoli','Italy',0,0,0,0,0,0,0,0),(46,'Lazio ','Italy',0,0,0,0,0,0,0,0),(47,'Atalanta ','Italy',0,0,0,0,0,0,0,0),(48,'AC Milan ','Italy',0,0,0,0,0,0,0,0),(49,'Inter','Italy',0,0,0,0,0,0,0,0),(50,'Fiorentina','Italy',0,0,0,0,0,0,0,0),(51,'Torino','Italy',0,0,0,0,0,0,0,0),(52,'Sampdoria','Italy',0,0,0,0,0,0,0,0),(53,'Sassuolo','Italy',0,0,0,0,0,0,0,0),(54,'Udinese','Italy',0,0,0,0,0,0,0,0),(55,'Cagliari','Italy',0,0,0,0,0,0,0,0),(56,'Chievo','Italy',0,0,0,0,0,0,0,0),(57,'Bologna','Italy',0,0,0,0,0,0,0,0),(58,'Genoa','Italy',0,0,0,0,0,0,0,0),(59,'Empoli','Italy',0,0,0,0,0,0,0,0),(60,'Crotone','Italy',0,0,0,0,0,0,0,0),(61,'Palermo ','Italy',0,0,0,0,0,0,0,0),(62,'Pescara ','Italy',0,0,0,0,0,0,0,0),(63,'Chelsea','United Kingdom',0,0,0,0,0,0,0,0),(64,'Tottenham','United Kingdom',0,0,0,0,0,0,0,0),(65,'Manchester City','United Kingdom',0,0,0,0,0,0,0,0),(66,'Liverpool','United Kingdom',0,0,0,0,0,0,0,0),(67,'Arsenal','United Kingdom',0,0,0,0,0,0,0,0),(68,'Manchester Utd','United Kingdom',0,0,0,0,0,0,0,0),(69,'Everton','United Kingdom',0,0,0,0,0,0,0,0),(70,'Southampton','United Kingdom',0,0,0,0,0,0,0,0),(71,'Bournemouth','United Kingdom',0,0,0,0,0,0,0,0),(72,'West Brom','United Kingdom',0,0,0,0,0,0,0,0),(73,'West Ham','United Kingdom',0,0,0,0,0,0,0,0),(74,'Leicester','United Kingdom',0,0,0,0,0,0,0,0),(75,'Stoke','United Kingdom',0,0,0,0,0,0,0,0),(76,'Crystal Palace','United Kingdom',0,0,0,0,0,0,0,0),(77,'Swansea','United Kingdom',0,0,0,0,0,0,0,0),(78,'Burnley','United Kingdom',0,0,0,0,0,0,0,0),(79,'Watford','United Kingdom',0,0,0,0,0,0,0,0),(80,'Hull','United Kingdom',0,0,0,0,0,0,0,0),(81,'Middlesbrough','United Kingdom',0,0,0,0,0,0,0,0),(82,'Sunderland','United Kingdom',0,0,0,0,0,0,0,0),(83,'Bayern','Germany',0,0,0,0,0,0,0,0),(84,'RB Leipzig','Germany',0,0,0,0,0,0,0,0),(85,'Dortmund','Germany',0,0,0,0,0,0,0,0),(86,'Hoffenheim','Germany',0,0,0,0,0,0,0,0),(87,'Köln','Germany',0,0,0,0,0,0,0,0),(88,'Hertha','Germany',0,0,0,0,0,0,0,0),(89,'Freiburg','Germany',0,0,0,0,0,0,0,0),(90,'Bremen','Germany',0,0,0,0,0,0,0,0),(91,'Monchengladbach','Germany',0,0,0,0,0,0,0,0),(92,'Schalke','Germany',0,0,0,0,0,0,0,0),(93,'Frankfurt','Germany',0,0,0,0,0,0,0,0),(94,'Leverkusen','Germany',0,0,0,0,0,0,0,0),(95,'Augsburg','Germany',0,0,0,0,0,0,0,0),(96,'Hamburger SV','Germany',0,0,0,0,0,0,0,0),(97,'Mainz','Germany',0,0,0,0,0,0,0,0),(98,'Wolfsburg','Germany',0,0,0,0,0,0,0,0),(99,'Ingolstadt','Germany',0,0,0,0,0,0,0,0),(100,'Darmstadt','Germany',0,0,0,0,0,0,0,0),(101,'Monaco','France',0,0,0,0,0,0,0,0),(102,'PSG','France',0,0,0,0,0,0,0,0),(103,'Nice','France',0,0,0,0,0,0,0,0),(104,'Lyon','France',0,0,0,0,0,0,0,0),(105,'Marseille','France',0,0,0,0,0,0,0,0),(106,'Bordeaux','France',0,0,0,0,0,0,0,0),(107,'Nantes','France',0,0,0,0,0,0,0,0),(108,'St. Etienne','France',0,0,0,0,0,0,0,0),(109,'Rennes','France',0,0,0,0,0,0,0,0),(110,'Guingamp','France',0,0,0,0,0,0,0,0),(111,'Lille','France',0,0,0,0,0,0,0,0),(112,'Angers','France',0,0,0,0,0,0,0,0),(113,'Toulouse','France',0,0,0,0,0,0,0,0),(114,'Metz','France',0,0,0,0,0,0,0,0),(115,'Montpellier','France',0,0,0,0,0,0,0,0),(116,'Dijon','France',0,0,0,0,0,0,0,0),(117,'Caen','France',0,0,0,0,0,0,0,0),(118,'Lorient','France',0,0,0,0,0,0,0,0),(119,'Nancy','France',0,0,0,0,0,0,0,0),(120,'Bastia','France',0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `clubs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLUB` int(11) NOT NULL,
  `NAME` varchar(70) NOT NULL,
  `NUMBER` int(11) NOT NULL,
  `POSITION` varchar(20) NOT NULL,
  `AGE` int(3) NOT NULL,
  `MP` int(3) DEFAULT '0',
  `GS` int(3) DEFAULT '0',
  `YC` int(3) DEFAULT '0',
  `RC` int(3) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`),
  KEY `CLUBID_idx` (`ID_CLUB`),
  CONSTRAINT `CLUBID` FOREIGN KEY (`ID_CLUB`) REFERENCES `clubs` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,1,'Casilla Francisco',13,'Goalkeeper',30,20,0,0,0),(2,1,'Navas Keylor',1,'Goalkeeper',30,0,0,0,0),(3,1,'Yanez Ruben',25,'Goalkeeper',23,0,0,0,0),(4,1,'Carvajal Daniel',2,'Defender',25,0,0,0,0),(5,1,'Coentrao Fabio',15,'Defender',29,0,0,0,0),(6,1,'Danilo',23,'Defender',25,0,0,0,0),(7,1,'Hakimi Achraf',2,'Defender',18,0,0,0,0),(8,1,'Marcelo',12,'Defender',29,0,0,0,0),(9,1,'Nacho',6,'Defender',27,0,0,0,0),(10,1,'Pepe',3,'Defender',34,0,0,0,0),(11,1,'Ramos Sergio',4,'Defender',31,0,0,0,0),(12,1,'Tejero Alvaro',27,'Defender',20,0,0,0,0),(13,1,'Varane Raphael',5,'Defender',24,0,0,0,0),(14,1,'Asensio Marco',20,'Midfielder',21,0,0,0,0),(15,1,'Bale Gareth',11,'Midfielder',27,0,0,0,0),(16,1,'Casemiro',14,'Midfielder',25,0,0,0,0),(17,1,'Enzo',29,'Midfielder',22,0,0,0,0),(19,1,'Kovacic Mateo',16,'Midfielder',23,0,0,0,0),(20,1,'Kroos Toni',8,'Midfielder',27,0,0,0,0),(21,1,'Lucas',17,'Midfielder',25,0,0,0,0),(22,1,'Modric Luka',19,'Midfielder',31,0,0,0,0),(24,1,'Benzema Karim',9,'Forward',29,0,0,0,0),(25,1,'Diaz Mariano',18,'Forward',23,0,0,0,0),(26,1,'Morata Alvaro',21,'Forward',24,0,0,0,0),(27,1,'Ronaldo Cristiano',7,'Forward',32,30,15,1,5),(28,1,'Zidane Zinedine',0,'Coach',44,0,0,0,0);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-30 15:02:45
