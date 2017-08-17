/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-08-17 19:00:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `parentId` varchar(255) DEFAULT NULL,
  `principal` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1876cd6b7d684bb8b43958223c1be4b8', '2017-08-17 17:53:33', null, null, null, 'fffffff', 'fdfdfdfdf', null, null);
INSERT INTO `role` VALUES ('5d219fb6152040bb8edcbbe6101b1c12', '2017-08-17 17:53:53', null, null, null, 'asfasfasf', 'fdfdfd', '1876cd6b7d684bb8b43958223c1be4b8', null);
INSERT INTO `role` VALUES ('8790b4480fd54512b9aca36e6f5c8a3e', '2017-08-17 17:53:37', null, null, null, 'sdfsdf', 'sdfsdfsd', null, null);
INSERT INTO `role` VALUES ('bec167d14e4f4cdea98be9735d4290ce', '2017-08-17 17:53:41', null, null, null, 'sdfsdfsdfsdf', 'sdfsdfsdfs', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `english_name` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2aa09b124daa4cb387227d03daa09dcb', '2017-08-17 10:15:10', null, null, null, 'sdfsd', null, '1', 'fghfghfh', 'dddsds', '455664e871047367bf0e17e91c8820117b24a69df4e83e9ff4bbd81030e85525', 'hfghfghfgh', '1', null, null);
INSERT INTO `user` VALUES ('33dddcab38314d0eb7792d4ed683a906', '2017-08-17 15:25:04', null, null, null, 'afasfa@qq.com', null, '2', '15820356452', 'dfdfdfd', 'd7ef0a04f3c8055644677299a9414a75adcb15916eb48417416c9317ace2ff4f', 'dgdfgdf', '1', 'ffffdfd', null);
INSERT INTO `user` VALUES ('a3f71adc08e94a59803c5459bffe7331', '2017-08-17 16:14:10', null, null, null, 'fsdfsdfs@sd.com', 'sdfsdfsdf', '1', '15820356452', 'sdfsdfsdfsd', '65e69d9d49dd5b603944236651ba4830bb7987314cba887a2faa4a146866eec8', 'sdfsdfsdfsdfsd', '1', 'sdfsdfsdfdsf', null);

-- ----------------------------
-- Table structure for user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rel`;
CREATE TABLE `user_role_rel` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_rel
-- ----------------------------
