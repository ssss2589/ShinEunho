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
-- Table structure for table `pro_commend`
--

DROP TABLE IF EXISTS `pro_commend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pro_commend` (
  `cseq` int(5) NOT NULL AUTO_INCREMENT,
  `commend` varchar(100) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `indate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `re_useyn` char(1) DEFAULT 'n',
  `qseq` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`cseq`),
  UNIQUE KEY `commend` (`commend`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_commend`
--

LOCK TABLES `pro_commend` WRITE;
/*!40000 ALTER TABLE `pro_commend` DISABLE KEYS */;
INSERT INTO `pro_commend` VALUES (12,'안뇽','shin','2019-07-16 02:59:33','n','5');
/*!40000 ALTER TABLE `pro_commend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_free`
--

DROP TABLE IF EXISTS `pro_free`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pro_free` (
  `qseq` int(5) NOT NULL AUTO_INCREMENT,
  `subject` varchar(30) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `click` varchar(10000) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `indate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `image` varchar(50) DEFAULT 'default.jpg',
  PRIMARY KEY (`qseq`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_free`
--

LOCK TABLES `pro_free` WRITE;
/*!40000 ALTER TABLE `pro_free` DISABLE KEYS */;
INSERT INTO `pro_free` VALUES (2,'이금용 게임개잘함','구라임','106','','2019-07-09 07:35:01','캡처3.JPG'),(4,'신발이쁘지','쩔지않냐???','152','1','2019-07-09 08:24:05','발냄새_신발의_발냄새_발냄새제거_신발냄새_제거_54.jpg'),(5,'이런 펭귄 키울래?','귀엽지??','516','1','2019-07-10 02:21:18','Penguins6.jpg'),(6,'민균이라는 친구를 소개할께','','741','신은호','2019-07-10 02:22:11','Koala6.jpg'),(9,'민균이','바보','2','신은호','2019-07-16 03:10:07','Jellyfish.jpg');
/*!40000 ALTER TABLE `pro_free` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_index`
--

DROP TABLE IF EXISTS `pro_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pro_index` (
  `qseq` int(5) NOT NULL AUTO_INCREMENT,
  `subject` varchar(30) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `useyn` char(1) DEFAULT 'y',
  `site` varchar(10000) DEFAULT NULL,
  `indate` varchar(1000) DEFAULT NULL,
  `image` varchar(50) DEFAULT 'default.jpg',
  PRIMARY KEY (`qseq`),
  KEY `content` (`content`(255))
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_index`
--

LOCK TABLES `pro_index` WRITE;
/*!40000 ALTER TABLE `pro_index` DISABLE KEYS */;
INSERT INTO `pro_index` VALUES (9,'ㅁㄴㅇㄴㅁ','ㄴㅇㅁㅁㄴㅇㄴ','n','ㅁㄴㅇ','21','thumb14.jpg'),(10,'ㄴㅁㄹㅇㅁㄴㅇ','ㅇㄻㄴㅇㄹ','n','ㄻㄴ','ㅁㄴㅇㄹ','naver_com_20150921_161535.jpg'),(11,'보령 머드축제','대천해수욕장 주변에서 열리는 축제로 다양한 행사가 마련되어있습니다. 바디페인팅, 머드 분장 콘테스트, 슬라이딩 멀리하기, 외나무 다리 건너기등의 이벤트가 준비되어 있다고 합니다.','n','','2019.08.12~2019.08.21','머드축제.jpg'),(12,'논산 토마토 페스티벌','논산에서 토마토를 먹고, 요리를 만들고, 체험하는 복합 문화체험 축제가 열립니다. 토마토 던지기와 퍼레이드, 토마토 샴페인 만들기 등 갖가지 프로그램이 준비되어 있다고 합니다.','y','','2019.08.10~2019.08.11','논산 토마토.jpg'),(13,'고성 하늬라벤더팜 라벤더 축제 2019','온통 보랏빛으로 물든 마을과 농장을 볼수 있는것은 물론 향수, 비누등 라벤더 체험, 라벤더 피자 만들기, 라벤더 수확 체험 등 다양한 체험 프로그램이 마련되어 있어서 가족들과 함께 즐기기 좋다고 합니다.','y','','2019.08.19~2019.08.30','라벤더.jpg');
/*!40000 ALTER TABLE `pro_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_member`
--

DROP TABLE IF EXISTS `pro_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pro_member` (
  `id` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `zip_num` varchar(7) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `useyn` char(1) DEFAULT 'y',
  `indate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_member`
--

LOCK TABLES `pro_member` WRITE;
/*!40000 ALTER TABLE `pro_member` DISABLE KEYS */;
INSERT INTO `pro_member` VALUES ('1','1','1','1','142-718','서울 강북구 삼각산동 (101∼122동)','12','n','2019-07-08 06:19:12'),('2','2','2','2','142-718','서울 강북구 삼각산동 (101∼122동)','2','n','2019-07-12 05:21:56'),('3','3','3','3','142-718','서울 강북구 삼각산동 (101∼122동)','3','n','2019-07-15 09:24:09'),('4','4','4','4','617-812','부산 사상구 덕포1동 786∼789','4','n','2019-07-15 09:35:36'),('shin','123','신은호','tlsmsgh88@naver.com','142-781','서울 강북구 인수동 (101∼107동)','010-39774358','y','2019-07-08 05:57:35');
/*!40000 ALTER TABLE `pro_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_qna`
--

DROP TABLE IF EXISTS `pro_qna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pro_qna` (
  `qseq` int(5) NOT NULL AUTO_INCREMENT,
  `subject` varchar(30) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `reply` varchar(1000) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `rep` char(1) DEFAULT '1',
  `indate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`qseq`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_qna`
--

LOCK TABLES `pro_qna` WRITE;
/*!40000 ALTER TABLE `pro_qna` DISABLE KEYS */;
INSERT INTO `pro_qna` VALUES (1,'즈기요','어려워요','알아서하십쇼','shin','2','2019-07-11 06:12:18',NULL),(5,'aㄹㄴ','ㅇㄴㄹ',NULL,'shin','1','2019-07-16 03:02:44',NULL);
/*!40000 ALTER TABLE `pro_qna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pro_worker`
--

DROP TABLE IF EXISTS `pro_worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pro_worker` (
  `id` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pro_worker`
--

LOCK TABLES `pro_worker` WRITE;
/*!40000 ALTER TABLE `pro_worker` DISABLE KEYS */;
INSERT INTO `pro_worker` VALUES ('admin','admin','신은호','010-3977-4358');
/*!40000 ALTER TABLE `pro_worker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-16 12:42:05
