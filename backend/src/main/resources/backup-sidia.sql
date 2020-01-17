/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.18 : Database - prova
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prova` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `prova`;

/*Table structure for table `genre` */

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`genre_id`),
  UNIQUE KEY `UK_f0cxck09qxl9ea0dhvl6aejis` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `genre` */

insert  into `genre`(`genre_id`,`name`) values 
(3,'Animation'),
(4,'Comedy'),
(1,'Documentary'),
(5,'Romance'),
(2,'Short'),
(6,'Sport');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `tconst` varchar(12) NOT NULL,
  `birthYear` varchar(4) DEFAULT NULL,
  `deathYear` varchar(4) DEFAULT NULL,
  `primaryTitle` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`tconst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `person` */

/*Table structure for table `ratings` */

DROP TABLE IF EXISTS `ratings`;

CREATE TABLE `ratings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `averageRating` double NOT NULL,
  `numVotes` int(11) DEFAULT NULL,
  `tconst` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtf5ohpn2xll9k6oociyf2ho5t` (`tconst`),
  CONSTRAINT `FKtf5ohpn2xll9k6oociyf2ho5t` FOREIGN KEY (`tconst`) REFERENCES `title` (`tconst`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `ratings` */

insert  into `ratings`(`id`,`averageRating`,`numVotes`,`tconst`) values 
(1,5.6,1567,'tt0000001'),
(2,6.1,189,'tt0000002'),
(3,6.5,1231,'tt0000003'),
(4,6.2,115,'tt0000004'),
(5,6.1,1965,'tt0000005'),
(6,5.2,106,'tt0000006'),
(7,5.4,622,'tt0000007'),
(8,5.4,1576,'tt0000008'),
(9,5.4,85,'tt0000009'),
(10,6.9,5617,'tt0000010'),
(11,5.2,241,'tt0000011'),
(12,7.4,9536,'tt0000012');

/*Table structure for table `title` */

DROP TABLE IF EXISTS `title`;

CREATE TABLE `title` (
  `tconst` varchar(12) NOT NULL,
  `adulto` bit(1) NOT NULL,
  `endYear` varchar(4) DEFAULT NULL,
  `originalTitle` varchar(255) DEFAULT NULL,
  `primaryTitle` varchar(255) DEFAULT NULL,
  `runtimeMinutes` varchar(255) DEFAULT NULL,
  `startYear` varchar(4) DEFAULT NULL,
  `titleType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tconst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `title` */

insert  into `title`(`tconst`,`adulto`,`endYear`,`originalTitle`,`primaryTitle`,`runtimeMinutes`,`startYear`,`titleType`) values 
('tt0000001','\0','','Carmencita','Carmencita','1','1894','short'),
('tt0000002','\0',NULL,'Le clown et ses chiens','Le clown et ses chiens','5','1892','short'),
('tt0000003','\0',NULL,'Pauvre Pierrot','Pauvre Pierrot','45','1892','short'),
('tt0000004','\0',NULL,'Un bon bock','Un bon bock',NULL,'1892','short'),
('tt0000005','\0',NULL,'Blacksmith Scene','Blacksmith Scene','1','1893','short'),
('tt0000006','\0',NULL,'Chinese Opium Den','Chinese Opium Den','1','1894','short'),
('tt0000007','\0',NULL,'Corbett and Courtney Before ','Corbett and Courtney Before ','1','1894','short'),
('tt0000008','\0',NULL,'Edison Kinetoscopic ','Edison Kinetoscopic ','1','1894','short'),
('tt0000009','\0',NULL,'Miss Jerry','Miss Jerry','1','1895','short'),
('tt0000010','\0',NULL,'Exiting the Factory','Exiting the Factory','1','1895','short'),
('tt0000011','\0',NULL,'Akrobatisches the Factory','Akrobatisches the Factory','1','1895','short'),
('tt0000012','\0',NULL,'The Arrival the Factory','The Arrival the Factory','1','1895','short');

/*Table structure for table `title_genre` */

DROP TABLE IF EXISTS `title_genre`;

CREATE TABLE `title_genre` (
  `tconst` varchar(12) NOT NULL,
  `genre_id` int(11) NOT NULL,
  KEY `FKqed7hvsx0wvs2aq7mqjw4idnv` (`genre_id`),
  KEY `FKivyo7ksyv19o3jb881rcai6ys` (`tconst`),
  CONSTRAINT `FKivyo7ksyv19o3jb881rcai6ys` FOREIGN KEY (`tconst`) REFERENCES `title` (`tconst`),
  CONSTRAINT `FKqed7hvsx0wvs2aq7mqjw4idnv` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `title_genre` */

insert  into `title_genre`(`tconst`,`genre_id`) values 
('tt0000001',1),
('tt0000002',2),
('tt0000003',3),
('tt0000004',4),
('tt0000005',5),
('tt0000006',5),
('tt0000007',1),
('tt0000008',2),
('tt0000009',3),
('tt0000010',4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
