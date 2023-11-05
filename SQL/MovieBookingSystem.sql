/*
SQLyog Community v13.1.2 (32 bit)
MySQL - 5.5.41 : Database - movie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`movie` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `movie`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_id` int(20) NOT NULL,
  `admin_name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`admin_id`,`admin_name`,`email`,`pwd`) values 
(1002,'Rahul','aj@gmail.com','Aj@123');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int(20) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(20) DEFAULT NULL,
  `pnumber` bigint(40) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`customer_name`,`pnumber`,`address`,`email`,`pwd`) values 
(1111,'Nayana',7795397589,'Hosapete','nayana@gmail.com','nayana@gmail.com'),
(1212,'Dheksha',8431269726,'near mvjce','dheksha@gmail.com','dheksha@123'),
(6666,'Anusha',67890567,'dfgh','anusha@gmail.com','Anusha@123'),
(7777,'Prajwal',67890567,'dfgh','prajwal@gmail.com','prajwal@123'),
(8888,'Akhil',67890567,'dfgh','akhil@gmail.com','akhil@123'),
(9999,'mithun',67890567,'dfgh','mithun@gmail.com','mithun@123');

/*Table structure for table `moviebooked` */

DROP TABLE IF EXISTS `moviebooked`;

CREATE TABLE `moviebooked` (
  `mname` varchar(20) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  `cid` int(20) DEFAULT NULL,
  `cname` varchar(20) DEFAULT NULL,
  `pnumber` bigint(20) DEFAULT NULL,
  `seats` int(20) DEFAULT NULL,
  KEY `cid` (`cid`),
  CONSTRAINT `moviebooked_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `moviebooked` */

insert  into `moviebooked`(`mname`,`price`,`cid`,`cname`,`pnumber`,`seats`) values 
('Arasu',50,1212,'dheksha',3456789,2);

/*Table structure for table `moviedetails` */

DROP TABLE IF EXISTS `moviedetails`;

CREATE TABLE `moviedetails` (
  `mname` varchar(20) NOT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `mtype` varchar(20) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `director` varchar(20) DEFAULT NULL,
  `cast` varchar(20) DEFAULT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  PRIMARY KEY (`mname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `moviedetails` */

insert  into `moviedetails`(`mname`,`tname`,`mtype`,`language`,`director`,`cast`,`duration`,`price`) values 
('ABCD','Bhagat','Dance','Hindi','Prabudev','Varun Darmesh','3',310),
('Appu','Mahalakshmi','Love','Kannada',NULL,'Puneet Rajkumar','2',400),
('Arasu','INOX','family','Kannada',NULL,'Dheksha','3',50),
('Dilwale','Garuda PVR','Drama','Hindi',NULL,'SRK VarunDhawan ','3',250),
('HelsForLyf','Park Square','Friendship','Kannada',NULL,'SRMNDA','5',500),
('Jathi Ratnalu','Meenashi','Comedy ','Telugu',NULL,'Naveen Faria','3',280),
('KrishnanMarraige','INOX','Family Drama','Kannada',NULL,'Ajay','3',350),
('Spider Man','cineipolis','Action','English',NULL,'Chris Erik','3',300);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
