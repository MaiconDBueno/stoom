CREATE SCHEMA `stoom` ;

CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(200) NOT NULL,
  `number` int(11) NOT NULL,
  `complement` varchar(100) DEFAULT NULL,
  `neighbourhood` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `statel` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `zipcode` varchar(20) NOT NULL,
  `latitude` decimal(10,8) DEFAULT NULL,
  `longitude` decimal(11,8) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `stoom`.`location`(`street_name`,`number`,`complement`,`neighbourhood`,`city`,`statel`,`country`,`zipcode`,`latitude`,`longitude`,`creation_date`,`update_date`)
VALUES
("Avenida Affonso Arinos",1001,"Casa","neighbourhood","Americana","SP","Brazil","13474-580",30,30,null,null);

