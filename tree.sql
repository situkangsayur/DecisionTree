-- MySQL dump 10.13  Distrib 5.5.25a, for Linux (i686)
--
-- Host: localhost    Database: tree
-- ------------------------------------------------------
-- Server version	5.5.25a

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
-- Table structure for table `iris`
--

DROP TABLE IF EXISTS `iris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iris` (
  `no` int(11) NOT NULL,
  `sepallength` float NOT NULL,
  `sepalwidth` float NOT NULL,
  `petallength` float NOT NULL,
  `petalwidth` float NOT NULL,
  `result` enum('Iris-setosa','Iris-versicolor','Iris-Virginica') NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iris`
--

LOCK TABLES `iris` WRITE;
/*!40000 ALTER TABLE `iris` DISABLE KEYS */;
/*!40000 ALTER TABLE `iris` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_set`
--

DROP TABLE IF EXISTS `training_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_set` (
  `day` varchar(5) NOT NULL,
  `out_look` varchar(10) DEFAULT NULL,
  `temperatur` varchar(10) DEFAULT NULL,
  `humadity` varchar(10) DEFAULT NULL,
  `wind` varchar(10) DEFAULT NULL,
  `playTennis` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`day`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_set`
--

LOCK TABLES `training_set` WRITE;
/*!40000 ALTER TABLE `training_set` DISABLE KEYS */;
INSERT INTO `training_set` VALUES ('D01','Sunny','Hot','High','Weak','No'),('D02','Sunny','Hot','High','Strong','No'),('D03','Overcast','Hot','High','Weak','Yes'),('D04','Rain','Mild','High','Weak','Yes'),('D05','Rain','Cool','Normal','Weak','Yes'),('D06','Rain','Cool','Normal','Strong','No'),('D07','Overcast','Cool','Normal','Strong','Yes'),('D08','Sunny','Mild','High','Weak','No'),('D09','Sunny','Cool','Normal','Weak','Yes'),('D10','Rain','Mild','Normal','Weak','Yes'),('D11','Sunny','Mild','Normal','Strong','Yes'),('D12','Overcast','Mild','High','Strong','Yes'),('D13','Overcast','Hot','Normal','Weak','Yes'),('D14','Rain','Mild','High','Strong','No');
/*!40000 ALTER TABLE `training_set` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-09 22:51:11
