-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 192.168.0.78    Database: user7
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `pos_item`
--

DROP TABLE IF EXISTS `pos_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pos_item` (
  `NAME` varchar(20) NOT NULL,
  `PRICE` int(11) NOT NULL,
  `TYPE` int(11) NOT NULL,
  `imageurl` varchar(100) NOT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pos_item`
--

LOCK TABLES `pos_item` WRITE;
/*!40000 ALTER TABLE `pos_item` DISABLE KEYS */;
INSERT INTO `pos_item` VALUES ('1955버거',5000,0,'C:/client/은호프로젝트/1955.JPG'),('더블불고기',4000,0,'C:/client/은호프로젝트/더블불고기.JPG'),('딸기쉐이크',2500,1,'C:/client/은호프로젝트/딸기쉐이크.JPG'),('맥너겟',2000,2,'C:/client/은호프로젝트/맥너겟.JPG'),('메가맥',5500,0,'C:/client/은호프로젝트/메가맥.JPG'),('바닐라쉐이크',2500,1,'C:/client/은호프로젝트/바닐라쉐이크.JPG'),('베이컨토마토',5000,0,'C:/client/은호프로젝트/베토디.JPG'),('빅맥',4000,0,'C:/client/은호프로젝트/빅맥.JPG'),('사과주스',1000,1,'C:/client/은호프로젝트/사과쥬스.JPG'),('상하이치킨',4000,0,'C:/client/은호프로젝트/상하이치킨.JPG'),('슈슈버거',4000,0,'C:/client/은호프로젝트/슈슈버거.JPG'),('스프라이트',1000,1,'C:/client/은호프로젝트/스프라이트.JPG'),('아이스크림콘',1000,2,'C:/client/은호프로젝트/아이스크림콘.JPG'),('애플파이',1000,2,'C:/client/은호프로젝트/애플파이.JPG'),('에그불고기',2000,0,'C:/client/은호프로젝트/캡처.JPG'),('오레오맥플러리',2000,2,'C:/client/은호프로젝트/오레오맥플러리.JPG'),('오렌지주스',1000,1,'C:/client/은호프로젝트/오렌지쥬스.JPG'),('우유',1000,1,'C:/client/은호프로젝트/우유.JPG'),('초코선데이',1500,2,'C:/client/은호프로젝트/초코선데이.JPG'),('초코쉐이크',2500,1,'C:/client/은호프로젝트/초코쉐이크.JPG'),('초코콘',1000,2,'C:/client/은호프로젝트/초코콘.JPG'),('치즈버거',2000,0,'C:/client/은호프로젝트/치즈버거.JPG'),('치즈스틱',1000,2,'C:/client/은호프로젝트/치즈스틱.JPG'),('치킨텐더',2000,2,'C:/client/은호프로젝트/치킨텐더.JPG'),('코카콜라',1000,1,'C:/client/은호프로젝트/코카콜라.JPG'),('환타(오렌지)',1000,1,'C:/client/은호프로젝트/환타(오렌지).JPG');
/*!40000 ALTER TABLE `pos_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-21 10:38:12
