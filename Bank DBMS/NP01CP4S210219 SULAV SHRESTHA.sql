-- MariaDB dump 10.19  Distrib 10.4.18-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	10.4.18-MariaDB
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;
/*!40101 SET NAMES utf8mb4 */
;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */
;
/*!40103 SET TIME_ZONE='+00:00' */
;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */
;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */
;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */
;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */
;
--
-- Table structure for table `account`
--
DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */
;
/*!40101 SET character_set_client = utf8 */
;
CREATE TABLE `account` (
  `AccountNo` int(11) NOT NULL,
  `AccountType` varchar(255) DEFAULT NULL,
  `Balance` decimal(12, 2) NOT NULL,
  PRIMARY KEY (`AccountNo`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */
;
--
-- Dumping data for table `account`
--
LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */
;
INSERT INTO `account`
VALUES (11, 'Savings Account', 2500000.00),
(12, 'Fixed Deposit Account', 25000000.00),
(13, 'Current Deposit Account', 500000.00),
(21, 'Savings Account', 3000000.00),
(22, 'Fixed Deposit Account', 35000000.00),
(23, 'Current Deposit Account', 250000.00),
(31, 'Savings Account', 2000000.00),
(32, 'Fixed Deposit Account', 45000000.00),
(33, 'Current Deposit Account', 200000.00),
(41, 'Savings Account', 4500000.00),
(42, 'Fixed Deposit Account', 50000000.00),
(43, 'Current Deposit Account', 300000.00),
(51, 'Savings Account', 5000000.00),
(52, 'Fixed Deposit Account', 70000000.00),
(53, 'Current Deposit Account', 350000.00);
/*!40000 ALTER TABLE `account` ENABLE KEYS */
;
UNLOCK TABLES;
--
-- Table structure for table `branch`
--
DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */
;
/*!40101 SET character_set_client = utf8 */
;
CREATE TABLE `branch` (
  `BranchID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Address` varchar(255) NOT NULL,
  PRIMARY KEY (`BranchID`)
) ENGINE = InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */
;
--
-- Dumping data for table `branch`
--
LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */
;
INSERT INTO `branch`
VALUES (1, 'ABC Bank', 'Gokarna, Kathmandu'),
(2, 'ABC Bank', 'Sundarijal, Kathmandu'),
(3, 'ABC Bank', 'Chahabhil, Kathmandu'),
(4, 'ABC Bank', 'Koteshowr, Kathmandu'),
(5, 'ABC Bank', 'Basundhara, Kathmandu');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */
;
UNLOCK TABLES;
--
-- Table structure for table `deposit`
--
DROP TABLE IF EXISTS `deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */
;
/*!40101 SET character_set_client = utf8 */
;
CREATE TABLE `deposit` (
  `Depositor` int(11) NOT NULL,
  `DepositType` varchar(255) DEFAULT NULL,
  `Amount` decimal(10, 2) NOT NULL,
  KEY `Depositor` (`Depositor`),
  CONSTRAINT `deposit_ibfk_1` FOREIGN KEY (`Depositor`) REFERENCES `depositor` (`DepositorID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */
;
--
-- Dumping data for table `deposit`
--
LOCK TABLES `deposit` WRITE;
/*!40000 ALTER TABLE `deposit` DISABLE KEYS */
;
INSERT INTO `deposit`
VALUES (1, 'Savings Deposit', 100000.00),
(3, 'Current Deposit', 25000.00),
(4, 'Savings Deposit', 250000.00),
(6, 'Current Deposit', 50000.00),
(7, 'Savings Deposit', 300000.00),
(9, 'Current Deposit', 45000.00),
(10, 'Savings Deposit', 400000.00),
(12, 'Current Deposit', 30000.00),
(13, 'Savings Deposit', 500000.00),
(15, 'Current Deposit', 35000.00);
/*!40000 ALTER TABLE `deposit` ENABLE KEYS */
;
UNLOCK TABLES;
--
-- Table structure for table `depositor`
--
DROP TABLE IF EXISTS `depositor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */
;
/*!40101 SET character_set_client = utf8 */
;
CREATE TABLE `depositor` (
  `DepositorID` int(11) NOT NULL AUTO_INCREMENT,
  `Account` int(11) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Address` varchar(255) DEFAULT 'Address Not Provided',
  PRIMARY KEY (`DepositorID`),
  KEY `Account` (`Account`),
  CONSTRAINT `depositor_ibfk_1` FOREIGN KEY (`Account`) REFERENCES `account` (`AccountNo`)
) ENGINE = InnoDB AUTO_INCREMENT = 16 DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */
;
--
-- Dumping data for table `depositor`
--
LOCK TABLES `depositor` WRITE;
/*!40000 ALTER TABLE `depositor` DISABLE KEYS */
;
INSERT INTO `depositor`
VALUES (1, 11, 'Shyam Bhandari', 'Gokarna, Kathmandu'),
(2, 12, 'Santosh Bhattrai', 'Suntakhan, Kathmandu'),
(3, 13, 'Kumar Basnet', 'Jagdol, Kathmandu'),
(4, 21, 'Rajesh Rai', 'Nayapati, Kathmandu'),
(5, 22, 'Ramesh Lama', 'Sundarijal, Kathmandu'),
(6, 23, 'Chhiring Sherpa', 'Namgel, Kathmandu'),
(7, 31, 'Hari Maharjan', 'Boudha, Kathmandu'),
(8, 32, 'Sijan Karmacharya', 'Mitrapark, Kathmandu'),
(9, 33, 'Dipak Shrestha', 'Chahabhil, Kathmandu'),
(10, 41, 'Satish Tuladhar', 'Gaushala, Kathmandu'),
(11, 42, 'Rina Rai', 'Koteshowr, Kathmandu'),
(12, 43, 'Sanju Baskota', 'Old Baneshowr, Kathmandu'),
(13, 51, 'Smriti Shrestha', 'Sundhara, Kathmandu'),
(14, 52, 'Dolma Tamang', 'Balaju, Kathmandu'),
(15, 53, 'Rohan Budhathoki', 'Chakrapath, Kathmandu');
/*!40000 ALTER TABLE `depositor` ENABLE KEYS */
;
UNLOCK TABLES;
--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */
;
/*!40101 SET character_set_client = utf8 */
;
CREATE TABLE `employee` (
  `EmployeeID` int(11) NOT NULL,
  `Branch` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `Branch` (`Branch`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Branch`) REFERENCES `branch` (`BranchID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */
;
--
-- Dumping data for table `employee`
--
LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */
;
INSERT INTO `employee`
VALUES (109, 1, 'Udaya Nepal', '984-121-5235'),
(156, 1, 'Raj Basnet', '984-950-4507'),
(213, 2, 'Sujan Shrestha', '984-066-6777'),
(256, 2, 'Kumari Rana', '984-257-6912'),
(321, 3, 'Madhav Nepal', '981-823-5601'),
(352, 3, 'Ram Shrestha', '981-375-2001'),
(432, 4, 'Rajesh Katuwal', '985-012-5689'),
(444, 4, 'Alina Shahi', '984-525-5209'),
(501, 5, 'Sajan Rai', '985-145-8962'),
(569, 5, 'Prajwol Khatiwoda', '986-928-8905');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */
;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */
;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */
;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */
;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */
;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */
;
-- Dump completed on 2021-04-27 16:11:33