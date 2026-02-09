-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: bakery
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_no` varchar(45) DEFAULT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `customer_phone_number` varchar(45) DEFAULT NULL,
  `customer_adress` varchar(45) DEFAULT NULL,
  `user_account` varchar(45) DEFAULT NULL,
  `user_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'c001','阿琴','912345678','台北','a3549','1234'),(2,'c002','阿德','986136645','桃園','b6494','4568'),(3,'c003','阿芳','987132131','新竹','d4944','7982'),(4,'c004','阿勞','966313545','桃園','w4949','4644'),(6,NULL,NULL,NULL,NULL,NULL,''),(7,'c006','張明明','0945-499-888','士林','eqw998','q999'),(8,'c007','張白白','0918-666-888','新店','w5978','a13678'),(9,'c008','陳西西','0987-778-122','中山','d4944','1234'),(10,'c009','晴寶','44949499','西門','a350499','1234'),(11,'c010','張阿掰','094464','台南','a8879','1554'),(12,'c011','渣渣灰','06465416516','日本','aaa123','bbb123');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_no` varchar(45) DEFAULT NULL,
  `employee_name` varchar(45) DEFAULT NULL,
  `employee_phone_number` varchar(45) DEFAULT NULL,
  `employee_account` varchar(45) DEFAULT NULL,
  `employee_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'e001','小張','975151534','e0001','1234'),(2,'e002','老張','943513216','e0002','1234'),(3,'e003','小陳','943159949','e0003','1234'),(4,'e004','老陳','964461123','e0004','1234'),(6,'e006','阿貝','0988-777-584','e0006','1234');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orders_id` int NOT NULL AUTO_INCREMENT,
  `orders_no` varchar(45) DEFAULT NULL,
  `customer_no` varchar(45) DEFAULT NULL,
  `product_no` varchar(45) DEFAULT NULL,
  `employee_no` varchar(45) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `total_price` int DEFAULT NULL,
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65827 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'o001','c001','p001','e001',30,NULL),(2,'o002','c002','p010','e001',40,NULL),(3,'o003','c003','p008','e003',20,NULL),(4,'o004','c004','p010','e005',15,NULL),(5,'o005','c005','p009','e003',45,NULL),(6,'o006','c001','p001','e002',60,NULL),(7,'o007','c001','p001','e002',40,NULL),(8,'o008','c004','p006','e001',30,NULL),(9,'o009','c005','p007','e001',60,NULL),(10,'o010','c004','p004','e004',20,NULL),(11,NULL,'訪客','波羅麵包','老張',10,100),(12,NULL,'訪客','羅宋麵包','老張',20,320),(13,NULL,'訪客','波羅麵包','老張',30,300),(17708,'ORD17708','c001','p004','e001',8,96),(17709,'ORD17709','c001','p014','e001',16,224),(18723,'ORD18723','C001','p001','e001',353,5295),(18724,'ORD18724','C001','p001','e001',353,5295),(37549,'ORD37549','c001','p001','e001',20,300),(37550,'ORD37550','c001','p005','e001',30,300),(37551,'ORD37551','c001','p012','e001',10,100),(56565,'ORD56565','C001','p005','e002',10,100),(56566,'ORD56566','C001','p006','e001',10,100),(56567,'ORD56567','C001','p002','e001',1010,10100),(65825,'ORD65825','c001','p001','e001',20,300),(65826,'ORD65826','c001','p006','e001',242,2420);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_no` varchar(20) DEFAULT NULL,
  `product_name` varchar(20) DEFAULT NULL,
  `product_cost` int DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'p001','蔥捲',14),(2,'p002','太陽餅',10),(3,'p003','羅宋麵包',16),(4,'p004','起司大蒜可頌',12),(5,'p005','波羅奶酥',10),(6,'p006','波羅麵包',10),(7,'p007','炸彈奶酥麵包',12),(8,'p008','花生麵包',10),(9,'p009','椰子麵包',10),(10,'p010','蛋塔',12),(11,'p011','大蒜麵包',10),(13,'p013','甜甜圈',13),(14,'p014','紅豆麻糬麵包',14),(15,'p015','椰子塔',13);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `show_bakery_final_order`
--

DROP TABLE IF EXISTS `show_bakery_final_order`;
/*!50001 DROP VIEW IF EXISTS `show_bakery_final_order`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `show_bakery_final_order` AS SELECT 
 1 AS `order_number`,
 1 AS `customer`,
 1 AS `employee`,
 1 AS `product_name`,
 1 AS `total_cost`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `show_bakery_final_order2`
--

DROP TABLE IF EXISTS `show_bakery_final_order2`;
/*!50001 DROP VIEW IF EXISTS `show_bakery_final_order2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `show_bakery_final_order2` AS SELECT 
 1 AS `訂單編號`,
 1 AS `客戶姓名`,
 1 AS `負責員工`,
 1 AS `產品名稱`,
 1 AS `產品單價`,
 1 AS `訂購數量`,
 1 AS `總金額`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `show_bakery_final_order`
--

/*!50001 DROP VIEW IF EXISTS `show_bakery_final_order`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `show_bakery_final_order` AS select `orders`.`orders_id` AS `order_number`,`customer`.`customer_name` AS `customer`,`employee`.`employee_name` AS `employee`,`product`.`product_name` AS `product_name`,(`orders`.`amount` * `product`.`product_cost`) AS `total_cost` from (((`orders` join `customer` on((`customer`.`customer_no` = `orders`.`customer_no`))) join `employee` on((`employee`.`employee_no` = `orders`.`employee_no`))) join `product` on((`product`.`product_no` = `orders`.`product_no`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `show_bakery_final_order2`
--

/*!50001 DROP VIEW IF EXISTS `show_bakery_final_order2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `show_bakery_final_order2` AS select `o`.`orders_id` AS `訂單編號`,`c`.`customer_name` AS `客戶姓名`,`e`.`employee_name` AS `負責員工`,`p`.`product_name` AS `產品名稱`,`p`.`product_cost` AS `產品單價`,`o`.`amount` AS `訂購數量`,`o`.`total_price` AS `總金額` from (((`orders` `o` join `customer` `c` on((`o`.`customer_no` = `c`.`customer_no`))) join `employee` `e` on((`o`.`employee_no` = `e`.`employee_no`))) join `product` `p` on((`o`.`product_no` = `p`.`product_no`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-09  0:53:28
