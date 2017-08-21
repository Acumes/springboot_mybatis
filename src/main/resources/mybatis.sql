/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-08-21 18:05:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(32) NOT NULL,
  `parentId` varchar(32) DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `type` varchar(10) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL COMMENT '菜单标题',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  `creator` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('asddddddddddddddddddddasdasdasda', null, 'HTF Admin', '0', '平台菜单', '0', null, '2017-08-21 09:08:28', null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `parentId` varchar(255) DEFAULT NULL,
  `principal` varchar(32) DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('091b6275eca14fb6b10b78d5e8749c4e', 'asdasdsad', 'asda', '4b432e82eacd480093c582ae8159fb11', 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 17:51:20', null, null);
INSERT INTO `role` VALUES ('0c3c091e869545999eb2eaaaebf41a2d', 'dasdasdasdasdasdasda', 'asdasdasdasdsadasd', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 17:52:27', null, null);
INSERT INTO `role` VALUES ('4223167658ff4db9b01884166ef1147b', 'ccc', 'ccccc', 'ff013362378448039af2138ec2dbd1bb', 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 16:20:18', null, null);
INSERT INTO `role` VALUES ('4b432e82eacd480093c582ae8159fb11', 'ddd', 'ddd', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 16:20:31', null, null);
INSERT INTO `role` VALUES ('8d52f11d02294daa9fa1a782a215944e', 'asdasdsadsadasdas', 'adsasdasdasdasdasd', '4b432e82eacd480093c582ae8159fb11', 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 17:51:39', null, null);
INSERT INTO `role` VALUES ('92419639b31c4810a5c0082e7df175eb', 'dfdfdfdddd', 'asdccccccc', '4b432e82eacd480093c582ae8159fb11', 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 17:51:33', null, null);
INSERT INTO `role` VALUES ('ead38789355740ff82b683c2687a6323', '管理员', '管理员', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-18 18:22:48', null, null);
INSERT INTO `role` VALUES ('f39af9a773844c82a3e174590c377a8f', 'fdf', 'fdfd', '4223167658ff4db9b01884166ef1147b', 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 17:57:21', null, null);
INSERT INTO `role` VALUES ('ff013362378448039af2138ec2dbd1bb', 'dfgdfgv', 'gfdgdfgdf', 'ead38789355740ff82b683c2687a6323', 'ecea08c54a7a42b0819690a3f26f78fc', null, '2017-08-21 16:19:56', null, null);

-- ----------------------------
-- Table structure for role_menu_rel
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_rel`;
CREATE TABLE `role_menu_rel` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单关系表';

-- ----------------------------
-- Records of role_menu_rel
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `english_name` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `creator` varchar(40) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `modifier` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('bc221f4ab2ca49ec934ee21c07e05767', 'dfgfdgdfg', 'ggffffff', 'dfgdfgdfg', 'dgfdf', '1', 'd95e0dba36cbe28ea4e97b1f9ac9eab64d588b6812819a370eb9c6e8573d1c79', 'dfgdfgdfg', '1', 'dfgdfgdfgdf', null, '2017-08-21 15:13:16', 'ecea08c54a7a42b0819690a3f26f78fc', null, null);
INSERT INTO `user` VALUES ('ecea08c54a7a42b0819690a3f26f78fc', 'admin@qq.com', 'admin', '15820356452', 'admin', '1', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'admin', '1', 'admin', null, '2017-08-18 18:21:27', null, '2017-08-18 18:24:58', null);

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
INSERT INTO `user_role_rel` VALUES ('f6dd0ab70f964ca98eb07b7d456962d2', 'ecea08c54a7a42b0819690a3f26f78fc', 'ead38789355740ff82b683c2687a6323');
