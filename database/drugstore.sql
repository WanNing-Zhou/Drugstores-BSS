/*
SQLyog v10.2 
MySQL - 8.0.31 : Database - drugstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`drugstore` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `drugstore`;

/*Table structure for table `customerinfo` */

DROP TABLE IF EXISTS `customerinfo`;

CREATE TABLE `customerinfo` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `customerinfo` */

insert  into `customerinfo`(`customerID`,`name`,`phone`) values (1,'dcq','123456'),(2,'ljc','7890123'),(3,'ljs','456123'),(4,'lijianchan','65464984618');

/*Table structure for table `druginfo` */

DROP TABLE IF EXISTS `druginfo`;

CREATE TABLE `druginfo` (
  `drugID` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `supplierID` int NOT NULL,
  `batchNumber` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `placeOfOrigin` varchar(50) DEFAULT NULL,
  `categoryOfOwnership` varchar(50) DEFAULT NULL,
  `purchasingPrice` decimal(10,2) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `inventory` int DEFAULT NULL,
  `dateOfProduction` date DEFAULT NULL,
  `dateOfExpiry` date DEFAULT NULL,
  PRIMARY KEY (`drugID`,`batchNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `druginfo` */

insert  into `druginfo`(`drugID`,`name`,`supplierID`,`batchNumber`,`placeOfOrigin`,`categoryOfOwnership`,`purchasingPrice`,`unitPrice`,`inventory`,`dateOfProduction`,`dateOfExpiry`) values ('SWYGY','维三维鱼肝油',2,'2203071','福建省厦门市沧海区新美路36号','维生素类非处方药药品','78.54','100.98',14,'2022-03-07','2024-12-30'),('SWYGY','维三维鱼肝油',2,'2203072','福建省厦门市沧海区新美路36号','维生素类非处方药药品','78.54','100.98',100,'2022-03-07','2024-12-30'),('SWYGY','维三维鱼肝油',2,'2203073','福建省厦门市沧海区新美路36号','维生素类非处方药药品','78.54','100.98',100,'2022-03-07','2024-12-30'),('WSSADRJN','维生素AD软胶囊',2,'104222001','福建省厦门市沧海区新美路36号','维生素类非处方药药品','78.54','100.98',3,'2022-03-07','2024-12-30'),('WSSADRJN','维生素AD软胶囊',2,'104222002','福建省厦门市沧海区新美路36号','维生素类非处方药药品','78.54','100.98',25,'2022-03-07','2024-12-30'),('WSSADRJN','维生素AD软胶囊',2,'104222003','福建省厦门市沧海区新美路36号','维生素类非处方药药品','78.54','100.98',35,'2022-03-07','2024-12-30'),('WSSADRJN','维生素AD软胶囊',2,'104222004','福建省厦门市沧海区新美路36号','维生素类非处方药药品','78.54','100.98',45,'2022-03-07','2024-12-30');

/*Table structure for table `employeesinfo` */

DROP TABLE IF EXISTS `employeesinfo`;

CREATE TABLE `employeesinfo` (
  `employeesID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`employeesID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

/*Data for the table `employeesinfo` */

insert  into `employeesinfo`(`employeesID`,`name`,`password`,`position`,`phone`) values (1,'ljs','qweasd','经理','123456'),(3,'lmd','qweasd','经理','789012'),(4,'周周','123456','经理','123456789'),(6,'周店员','周店员','店员','123456789'),(7,'周周','e10adc3949ba59abbe56e057f20f883e','经理','65461684864'),(8,'周xiao','e10adc3949ba59abbe56e057f20f883e','店员','685494168'),(9,'ljc','e10adc3949ba59abbe56e057f20f883e','经理','6871687464'),(10,'lmd','e10adc3949ba59abbe56e057f20f883e','经理','3856518654');

/*Table structure for table `financialrevenueandexpenditureinfo` */

DROP TABLE IF EXISTS `financialrevenueandexpenditureinfo`;

CREATE TABLE `financialrevenueandexpenditureinfo` (
  `financialRevenueAndExpenditureID` int NOT NULL AUTO_INCREMENT,
  `billID` int DEFAULT NULL,
  `typeOfBill` varchar(20) DEFAULT NULL,
  `profitAndLoss` decimal(10,2) DEFAULT NULL,
  `currentAmount` decimal(10,2) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`financialRevenueAndExpenditureID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;

/*Data for the table `financialrevenueandexpenditureinfo` */

insert  into `financialrevenueandexpenditureinfo`(`financialRevenueAndExpenditureID`,`billID`,`typeOfBill`,`profitAndLoss`,`currentAmount`,`time`) values (1,0,'original','0.00','100000.00',NULL),(2,5,'marketing','706.02','99293.98','2022-12-08 00:25:33'),(3,1,'return','302.58','98991.40','2022-12-08 01:00:02'),(4,2,'return','1008.60','97982.80','2022-12-08 01:00:42'),(5,6,'marketing','706.02','98688.82','2022-12-08 01:01:29'),(6,1,'return','10086.00','88602.82','2022-12-08 01:44:51'),(7,2,'storageEntry','10086.00','78516.82','2022-12-08 01:45:43'),(8,2,'storageEntry','100860.00','-22343.18','2022-12-08 02:10:53'),(9,2,'storageEntry','100860.00','78516.82','2022-12-08 02:12:17'),(10,2,'outbound','100860.00','179376.82','2022-12-08 02:13:00'),(11,2,'outbound','100860.00','280236.82','2022-12-08 02:13:05'),(12,2,'outbound','100860.00','381096.82','2022-12-08 02:13:09'),(13,7,'marketing','706.02','381802.84','2022-12-08 14:25:26'),(14,8,'marketing','706.02','382508.86','2022-12-08 14:25:41'),(15,9,'marketing','706.02','383214.88','2022-12-08 14:26:35'),(16,10,'marketing','706.02','383920.90','2022-12-08 14:27:59'),(17,11,'marketing','3530.10','387451.00','2022-12-08 14:30:55'),(18,12,'marketing','3530.10','390981.10','2022-12-08 14:31:28'),(19,13,'marketing','3530.10','394511.20','2022-12-08 14:31:44'),(20,14,'marketing','3530.10','398041.30','2022-12-08 14:33:50'),(21,15,'marketing','3530.10','401571.40','2022-12-08 14:35:10'),(22,16,'marketing','3530.10','405101.50','2022-12-08 14:35:49'),(23,17,'marketing','3530.10','408631.60','2022-12-08 14:37:42'),(24,18,'marketing','3530.10','412161.70','2022-12-08 14:41:41'),(25,19,'marketing','3530.10','415691.80','2022-12-08 14:42:56'),(26,20,'marketing','3530.10','419221.90','2022-12-08 14:43:08'),(27,21,'marketing','3530.10','422752.00','2022-12-08 14:43:16'),(28,22,'marketing','3530.10','426282.10','2022-12-08 14:43:31'),(29,3,'return','1008.60','425273.50','2022-12-08 14:49:12'),(30,4,'return','1008.60','424264.90','2022-12-08 14:50:42'),(31,5,'return','1008.60','423256.30','2022-12-08 14:51:33'),(32,6,'return','1008.60','422247.70','2022-12-08 14:52:41'),(33,7,'return','1008.60','421239.10','2022-12-08 14:53:33'),(34,3,'storageEntry','10086.00','411153.10','2022-12-08 14:56:09'),(35,3,'outbound','100860.00','512013.10','2022-12-08 14:57:14'),(36,4,'storageEntry','10086.00','501927.10','2022-12-08 14:58:20'),(37,4,'outbound','10086.00','512013.10','2022-12-08 14:59:42'),(38,23,'marketing','100.86','512113.96','2022-12-08 16:45:58'),(39,24,'marketing','100.86','512214.82','2022-12-08 16:47:52'),(40,5,'storageEntry','1210.32','511004.50','2022-12-08 16:53:54'),(41,8,'return','201.72','510802.78','2022-12-08 16:56:22');

/*Table structure for table `marketinginfo` */

DROP TABLE IF EXISTS `marketinginfo`;

CREATE TABLE `marketinginfo` (
  `marketingID` int NOT NULL AUTO_INCREMENT,
  `drugID` varchar(20) DEFAULT NULL,
  `drugName` varchar(20) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `customerID` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`marketingID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;

/*Data for the table `marketinginfo` */

insert  into `marketinginfo`(`marketingID`,`drugID`,`drugName`,`unitPrice`,`number`,`amount`,`customerID`,`time`) values (1,'SWYGY','三维鱼肝油','100.86',10,'1008.60',1,'2022-12-07 20:53:10'),(2,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-07 20:54:24'),(3,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-07 23:21:26'),(4,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-08 00:17:53'),(5,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-08 00:25:33'),(6,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-08 01:01:29'),(7,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-08 14:25:26'),(8,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-08 14:25:41'),(9,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-08 14:26:34'),(10,'WSSADRJN','维生素AD软胶囊','100.86',7,'706.02',2,'2022-12-08 14:27:59'),(11,'WSSADRJN','维生素AD软胶囊','100.86',35,'3530.10',2,'2022-12-08 14:30:55'),(12,'WSSADRJN','维生素AD软胶囊','100.86',35,'3530.10',2,'2022-12-08 14:31:28'),(13,'WSSADRJN','维生素AD软胶囊','100.86',35,'3530.10',2,'2022-12-08 14:31:44'),(14,'SWYGY','三维鱼肝油','100.86',35,'3530.10',2,'2022-12-08 14:33:50'),(15,'SWYGY','三维鱼肝油','100.86',35,'3530.10',2,'2022-12-08 14:35:10'),(16,'SWYGY','三维鱼肝油','100.86',35,'3530.10',2,'2022-12-08 14:35:49'),(17,'SWYGY','三维鱼肝油','100.86',35,'3530.10',2,'2022-12-08 14:37:42'),(18,'SWYGY','三维鱼肝油','100.86',35,'3530.10',2,'2022-12-08 14:41:41'),(19,'WSSADRJN','维生素AD软胶囊','100.86',35,'3530.10',2,'2022-12-08 14:42:56'),(20,'WSSADRJN','维生素AD软胶囊','100.86',35,'3530.10',2,'2022-12-08 14:43:08'),(21,'WSSADRJN','维生素AD软胶囊','100.86',35,'3530.10',2,'2022-12-08 14:43:16'),(22,'WSSADRJN','维生素AD软胶囊','100.86',35,'3530.10',2,'2022-12-08 14:43:31'),(23,'WSSADRJN','维生素AD软胶囊','100.86',1,'100.86',2,'2022-12-08 16:45:58'),(24,'WSSADRJN','维生素AD软胶囊','100.86',1,'100.86',2,'2022-12-08 16:47:52');

/*Table structure for table `outboundinfo` */

DROP TABLE IF EXISTS `outboundinfo`;

CREATE TABLE `outboundinfo` (
  `outboundID` int NOT NULL AUTO_INCREMENT,
  `drugID` varchar(20) DEFAULT NULL,
  `drugName` varchar(20) DEFAULT NULL,
  `purchasingPrice` decimal(10,2) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `supplierID` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`outboundID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

/*Data for the table `outboundinfo` */

insert  into `outboundinfo`(`outboundID`,`drugID`,`drugName`,`purchasingPrice`,`number`,`amount`,`supplierID`,`time`) values (1,'SWYGY','三维鱼肝油','100.86',1000,'100860.00',1,'2022-12-08 02:10:53'),(2,'SWYGY','三维鱼肝油','100.86',1000,'100860.00',1,'2022-12-08 02:12:17'),(3,'SWYGY','三维鱼肝油','100.86',1000,'100860.00',1,'2022-12-08 02:13:00'),(4,'SWYGY','三维鱼肝油','100.86',1000,'100860.00',1,'2022-12-08 02:13:05'),(5,'SWYGY','三维鱼肝油','100.86',1000,'100860.00',1,'2022-12-08 02:13:09'),(6,'SWYGY','三维鱼肝油','100.86',1000,'100860.00',1,'2022-12-08 14:57:14'),(7,'SWYGY','三维鱼肝油','100.86',100,'10086.00',1,'2022-12-08 14:59:42');

/*Table structure for table `returninfo` */

DROP TABLE IF EXISTS `returninfo`;

CREATE TABLE `returninfo` (
  `returnID` int NOT NULL AUTO_INCREMENT,
  `drugID` varchar(20) DEFAULT NULL,
  `drugName` varchar(20) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `customerID` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`returnID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

/*Data for the table `returninfo` */

insert  into `returninfo`(`returnID`,`drugID`,`drugName`,`unitPrice`,`number`,`amount`,`customerID`,`time`) values (1,'SWYGY','三维鱼肝油','100.86',3,'302.58',1,'2022-12-08 01:00:02'),(2,'SWYGY','三维鱼肝油','100.86',10,'1008.60',3,'2022-12-08 01:00:42'),(3,'SWYGY','三维鱼肝油','100.86',10,'1008.60',3,'2022-12-08 14:49:12'),(4,'SWYGY','三维鱼肝油','100.86',10,'1008.60',3,'2022-12-08 14:50:42'),(5,'SWYGY','三维鱼肝油','100.86',10,'1008.60',3,'2022-12-08 14:51:33'),(6,'SWYGY','三维鱼肝油','100.86',10,'1008.60',3,'2022-12-08 14:52:41'),(7,'SWYGY','三维鱼肝油','100.86',10,'1008.60',3,'2022-12-08 14:53:33'),(8,'SWYGY','三维鱼肝油','100.86',2,'201.72',1,'2022-12-08 16:56:22');

/*Table structure for table `storageentryinfo` */

DROP TABLE IF EXISTS `storageentryinfo`;

CREATE TABLE `storageentryinfo` (
  `storageEntryID` int NOT NULL AUTO_INCREMENT,
  `drugID` varchar(20) DEFAULT NULL,
  `drugName` varchar(20) DEFAULT NULL,
  `purchasingPrice` decimal(10,2) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `supplierID` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`storageEntryID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

/*Data for the table `storageentryinfo` */

insert  into `storageentryinfo`(`storageEntryID`,`drugID`,`drugName`,`purchasingPrice`,`number`,`amount`,`supplierID`,`time`) values (1,'SWYGY','三维鱼肝油','100.86',100,'10086.00',1,'2022-12-08 01:44:51'),(2,'SWYGY','三维鱼肝油','100.86',100,'10086.00',1,'2022-12-08 01:45:43'),(3,'SWYGY','三维鱼肝油','100.86',100,'10086.00',1,'2022-12-08 14:56:09'),(4,'SWYGY','三维鱼肝油','100.86',100,'10086.00',1,'2022-12-08 14:58:20'),(5,'SWYGY','三维鱼肝油','100.86',12,'1210.32',1,'2022-12-08 16:53:54');

/*Table structure for table `supplierinfo` */

DROP TABLE IF EXISTS `supplierinfo`;

CREATE TABLE `supplierinfo` (
  `supplierID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `agent` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`supplierID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

/*Data for the table `supplierinfo` */

insert  into `supplierinfo`(`supplierID`,`name`,`agent`,`phone`,`address`) values (1,'广药','ljm','001212','广东省广州市海珠区ABCDEFG'),(3,'哈药','ljm','001212','黑龙江省哈尔冰市南岗区OPQRST'),(4,'北药','ljs','123678','中国首都'),(5,'北药','ljm','001212','北京市市海淀区HIJKLMN'),(6,'云药','周景顺','135418564584','云南省丽江市三水区妆发镇'),(9,'贵药','张三','465468471','贵州');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
