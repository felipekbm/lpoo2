-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: trabalho_lpoo2
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nacionalidade` varchar(255) NOT NULL,
  `data_nasc` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `foto` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (1,'BRASIL','1993-02-02','IRINEU BARBOSA','https://i.pinimg.com/236x/1a/da/e1/1adae16e3acb0f2f84a8ac91b6474c83.jpg'),(2,'BRASIL','1993-02-02','NEYMAR','https://tm.ibxk.com.br/2021/12/14/14120648354257.jpg'),(3,'ARGENTINA','1993-02-02','MESSI','https://i.pinimg.com/236x/65/59/27/655927b6c4ede7bdb9225d4fed91ff6b.jpg'),(4,'BRASIL','1993-02-02','TITE','https://conteudo.imguol.com.br/c/esporte/f5/2020/07/07/tecnico-tite-comemora-conquista-da-copa-america-de-2019-pela-selecao-brasileira-1594136758144_v2_450x450.jpg'),(5,'Brasil','1993-02-02','Fred','https://i.pinimg.com/236x/8f/86/0b/8f860b2b7d4505c9a9c2c953a188625d.jpg'),(26,'Argentina','3854-01-12','Di Maria','https://i.pinimg.com/236x/4e/18/18/4e1818fd96f4d547878bd2582cee1f26.jpg'),(27,'BRASIL','3854-01-12','Willian','https://i.pinimg.com/236x/4d/55/3b/4d553b55d8b2135b508ba8403385002a.jpg'),(28,'BRASIL','3854-01-12','ALISSON','https://i.pinimg.com/236x/f5/36/30/f53630f3d5c45da9409cf557dd1b30ee.jpg'),(29,'Brasil','3854-01-12','Daniel Alves','https://i.pinimg.com/236x/52/be/31/52be3137de9c8f99588e334232fd8736.jpg'),(30,'BRASIL','3854-01-12','Tiago Silva','https://i.pinimg.com/236x/16/84/eb/1684ebdd8b6696eef4534e3aeb8eb21f.jpg'),(31,'Argentina','3854-01-12','Lionel Scaloni','https://i.pinimg.com/236x/6d/b2/cf/6db2cf3ae126cb9deb2f12c0c0d0e929.jpg'),(32,'Argentina','3854-01-12','Lionel Scaloni','https://i.pinimg.com/236x/6d/b2/cf/6db2cf3ae126cb9deb2f12c0c0d0e929.jpg'),(33,'Brasil','3854-01-12','Anderson Daronco','https://i.pinimg.com/236x/c3/74/80/c37480cdad8a619159d9ecc08798e4af.jpg');
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-05 16:37:47
