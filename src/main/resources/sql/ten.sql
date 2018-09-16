DROP  DATABASE IF EXISTS weitao;
CREATE DATABASE weitao;
USE weitao;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `items_id` int(50) NOT NULL,
  `seller_id` int(50) NOT NULL,
  `user_id` int(50) NOT NULL,
  `number` int(50) NOT NULL,
  KEY `car_fk_1` (`items_id`),
  KEY `car_fk_2` (`seller_id`),
  KEY `car_fk_3` (`user_id`),
  CONSTRAINT `car_fk_1` FOREIGN KEY (`items_id`) REFERENCES `items` (`i_id`),
  CONSTRAINT `car_fk_2` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`s_id`),
  CONSTRAINT `car_fk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ca_id` int(50) NOT NULL,
  `ca_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `ca_father` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ca_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `c_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_id` int(50) NOT NULL,
  `items_id` int(50) NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `collection_fk_1` (`user_id`),
  KEY `collection_fk_2` (`items_id`),
  CONSTRAINT `collection_fk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `collection_fk_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`i_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for `evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `e_id` int(50) NOT NULL AUTO_INCREMENT,
  `e_level` tinyint(4) NOT NULL,
  `e_description` text COLLATE utf8_bin,
  `e_photos` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_id` int(50) NOT NULL,
  `store_id` int(50) NOT NULL,
  `user_id` int(50) NOT NULL,
  `items_id` int(50) NOT NULL,
  PRIMARY KEY (`e_id`),
  KEY `evaluate_fk_1` (`order_id`),
  KEY `evaluate_fk_2` (`store_id`),
  KEY `evaluate_fk_3` (`user_id`),
  KEY `evaluate_fk_4` (`items_id`),
  CONSTRAINT `evaluate_fk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`o_id`),
  CONSTRAINT `evaluate_fk_2` FOREIGN KEY (`store_id`) REFERENCES `store` (`st_id`),
  CONSTRAINT `evaluate_fk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `evaluate_fk_4` FOREIGN KEY (`items_id`) REFERENCES `items` (`i_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `i_id` int(50) NOT NULL AUTO_INCREMENT,
  `i_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `i_introduction` text COLLATE utf8_bin NOT NULL,
  `i_photos` varchar(255) COLLATE utf8_bin NOT NULL,
  `i_exsit` int(50) NOT NULL,
  `i_sale` int(50) NOT NULL,
  `i_price` decimal(10,3) NOT NULL,
  `i_date` datetime DEFAULT NULL,
  `i_status` tinyint(4) NOT NULL,
  `store_id` int(50) NOT NULL,
  `catagory_id` int(50) NOT NULL,
  PRIMARY KEY (`i_id`),
  KEY `items_fk_1` (`store_id`),
  KEY `items_fk_2` (`catagory_id`),
  CONSTRAINT `items_fk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`st_id`),
  CONSTRAINT `items_fk_2` FOREIGN KEY (`catagory_id`) REFERENCES `category` (`ca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of items
-- ----------------------------

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `m_id` int(50) NOT NULL AUTO_INCREMENT,
  `m_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `m_authority` tinyint(4) NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `o_id` int(50) NOT NULL AUTO_INCREMENT,
  `o_post` tinyint(4) NOT NULL,
  `o_price` decimal(10,3) NOT NULL,
  `o_date` datetime NOT NULL,
  `o_status` tinyint(4) NOT NULL,
  `o_message` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(50) NOT NULL,
  `seller_id` int(50) NOT NULL,
  `store_id` int(50) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `order_fk_1` (`seller_id`),
  KEY `order_fk_2` (`user_id`),
  KEY `order_fk_3` (`store_id`),
  CONSTRAINT `order_fk_1` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`s_id`),
  CONSTRAINT `order_fk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `order_fk_3` FOREIGN KEY (`store_id`) REFERENCES `store` (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `or_de_id` int(50) NOT NULL AUTO_INCREMENT,
  `or_de_number` int(50) NOT NULL,
  `order_id` int(50) NOT NULL,
  `items_id` int(50) NOT NULL,
  PRIMARY KEY (`or_de_id`),
  KEY `order_detail_fk_1` (`items_id`),
  KEY `order_detail_fk_2` (`order_id`),
  CONSTRAINT `order_detail_fk_1` FOREIGN KEY (`items_id`) REFERENCES `items` (`i_id`),
  CONSTRAINT `order_detail_fk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `seller`
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `s_id` int(50) NOT NULL AUTO_INCREMENT,
  `s_account` varchar(255) COLLATE utf8_bin NOT NULL,
  `s_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `s_tel` varchar(255) COLLATE utf8_bin NOT NULL,
  `s_address` varchar(255) COLLATE utf8_bin NOT NULL,
  `s_icon` varchar(255) COLLATE utf8_bin NOT NULL,
  `s_sex` varchar(255) COLLATE utf8_bin NOT NULL,
  `s_stutas` tinyint(4) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of seller
-- ----------------------------

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `st_id` int(50) NOT NULL AUTO_INCREMENT,
  `st_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `st_status` tinyint(4) NOT NULL,
  `seller_id` int(50) NOT NULL,
  PRIMARY KEY (`st_id`),
  KEY `store_fk_1` (`seller_id`),
  CONSTRAINT `store_fk_1` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(50) NOT NULL AUTO_INCREMENT,
  `u_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_user_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_tel` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_address1` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_address2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `u_address3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `u_icon` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_sex` varchar(3) COLLATE utf8_bin NOT NULL,
  `u_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
