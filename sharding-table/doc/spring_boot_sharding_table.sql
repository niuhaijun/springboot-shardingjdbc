/*
 Navicat MySQL Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : spring_boot_sharding_table

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 05/11/2019 10:40:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(32) NOT NULL,
  `content` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `uuid` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_0
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0`;
CREATE TABLE `t_user_0` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_1
-- ----------------------------
DROP TABLE IF EXISTS `t_user_1`;
CREATE TABLE `t_user_1` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_2
-- ----------------------------
DROP TABLE IF EXISTS `t_user_2`;
CREATE TABLE `t_user_2` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201901
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201901`;
CREATE TABLE `t_user_201901` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201902
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201902`;
CREATE TABLE `t_user_201902` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201903
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201903`;
CREATE TABLE `t_user_201903` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201904
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201904`;
CREATE TABLE `t_user_201904` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201905
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201905`;
CREATE TABLE `t_user_201905` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201906
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201906`;
CREATE TABLE `t_user_201906` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201907
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201907`;
CREATE TABLE `t_user_201907` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201908
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201908`;
CREATE TABLE `t_user_201908` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201909
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201909`;
CREATE TABLE `t_user_201909` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201910
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201910`;
CREATE TABLE `t_user_201910` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201911
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201911`;
CREATE TABLE `t_user_201911` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for t_user_201912
-- ----------------------------
DROP TABLE IF EXISTS `t_user_201912`;
CREATE TABLE `t_user_201912` (
  `id` int(32) NOT NULL COMMENT '主键',
  `content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for WORKER_NODE
-- ----------------------------
DROP TABLE IF EXISTS `WORKER_NODE`;
CREATE TABLE `WORKER_NODE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `HOST_NAME` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'host name',
  `PORT` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'port',
  `TYPE` int(11) NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
  `LAUNCH_DATE` date NOT NULL COMMENT 'launch date',
  `MODIFIED` timestamp NOT NULL COMMENT 'modified time',
  `CREATED` timestamp NOT NULL COMMENT 'created time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='DB WorkerID Assigner for UID Generator';

SET FOREIGN_KEY_CHECKS = 1;
