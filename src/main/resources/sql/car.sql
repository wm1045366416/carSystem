/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : carsys

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2020-03-26 21:27:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carmessage`
-- ----------------------------
DROP TABLE IF EXISTS `carmessage`;
CREATE TABLE `carmessage` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `carName` varchar(100) NOT NULL,
  `carType` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `carSeries` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carmessage
-- ----------------------------
INSERT INTO `carmessage` VALUES ('2', '奥迪', '中型车', '28.5-70.0万', 'A级');
INSERT INTO `carmessage` VALUES ('3', '宝马', 'SUV', '30.8-56.3万', 'X1');
INSERT INTO `carmessage` VALUES ('7', '奔驰', '中型车', '28.5-70.0万', 'C级');
INSERT INTO `carmessage` VALUES ('11', '宾利', '轿车', '128.5-170.0万', '高级');


--车辆库存表
DROP TABLE IF EXISTS `carStock`;
DROP TABLE IF EXISTS `carStock`;
CREATE TABLE `carStock` (
  `id` int(100) NOT NULL,
  `totalAccount` INT NOT NULL COMMENT '总库存',
  `stockAccount` INT NOT NULL COMMENT '剩余库存',
  `createdTime` date NOT NULL,
	`updatedTime` date ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
INSERT INTO `carStock` VALUES ('2', 1, 1, NOW(), null);
INSERT INTO `carStock` VALUES ('3', 10, 8, NOW(), null);
INSERT INTO `carStock` VALUES ('7', 5, 1, NOW(), null);
INSERT INTO `carStock` VALUES ('11', 2, 2, NOW(), null);
--购车记录表
DROP TABLE IF EXISTS `carRecord`;
CREATE TABLE `carRecord` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(100) NOT NULL COMMENT '购车人姓名',
	`carId` INT(100) NOT NULL COMMENT '车辆id',
  `account` INT NOT NULL COMMENT '购车数量',
  `createdTime` date NOT NULL,
	`updatedTime` date ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;