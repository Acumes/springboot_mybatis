/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-08-25 17:53:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for measureunit_conversion
-- ----------------------------
DROP TABLE IF EXISTS `measureunit_conversion`;
CREATE TABLE `measureunit_conversion` (
  `measureunit_code` varchar(40) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `measureunit_name` varchar(40) NOT NULL,
  `ratio` decimal(19,2) DEFAULT NULL,
  `sort_seq` int(11) DEFAULT NULL,
  `measureunit_type_code` varchar(40) NOT NULL,
  PRIMARY KEY (`measureunit_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of measureunit_conversion
-- ----------------------------
INSERT INTO `measureunit_conversion` VALUES ('02FBFC86FBA943CCAD73C9218', '', '', '2016-07-28 19:11:52', '2016-07-28 19:11:52', '', '1', '平方分米', '10000.00', '2', 'area');
INSERT INTO `measureunit_conversion` VALUES ('272B17A37BC7413293F35805F', '', '', '2016-07-28 19:11:52', '2016-07-28 19:11:52', '', '1', '平方毫米', '1.00', '4', 'area');
INSERT INTO `measureunit_conversion` VALUES ('28A022DE6908484F8B793D02E', '', '', '2016-07-28 19:08:12', '2016-07-28 19:08:12', '', '1', '克', '1.00', '3', 'weight');
INSERT INTO `measureunit_conversion` VALUES ('3C8A641A368049B293BDA703C', '', '', '2016-07-28 19:36:55', '2016-07-28 19:36:55', '', '1', '包', '1.00', '1', 'bao');
INSERT INTO `measureunit_conversion` VALUES ('4CB57649994643F6A61CF6FD5', '', '', '2016-07-28 19:37:27', '2016-07-28 19:37:27', '', '1', '条', '1.00', '1', 'tiao');
INSERT INTO `measureunit_conversion` VALUES ('4EDDDE0173B94C3FB85AB4325', '', '', '2016-09-03 11:00:09', '2016-09-03 11:00:09', '', '1', '支', '1.00', '1', 'zhi');
INSERT INTO `measureunit_conversion` VALUES ('4F9CBBD014724B24B1222ADDD', '', '', '2016-07-28 19:16:01', '2016-07-28 19:16:01', '', '1', '毫米', '0.10', '5', 'lenght');
INSERT INTO `measureunit_conversion` VALUES ('55843DA147164E66BABAE45E6', '', '', '2016-07-28 19:08:12', '2016-07-28 19:08:12', '', '1', '毫克', '0.00', '4', 'weight');
INSERT INTO `measureunit_conversion` VALUES ('5C769812736D4582924039742', '', '', '2016-07-28 20:01:30', '2016-07-28 20:01:30', '', '1', '码', '91.44', '6', 'lenght');
INSERT INTO `measureunit_conversion` VALUES ('5ECEACB56D0B4914B57B42128', '', '', '2016-07-28 19:16:01', '2016-07-28 19:16:01', '', '1', '厘米', '1.00', '4', 'lenght');
INSERT INTO `measureunit_conversion` VALUES ('74424E9AD19D4830AF1338F5E', '', '', '2016-07-28 19:34:59', '2016-07-28 19:34:59', '', '1', '张', '1.00', '1', 'zhang');
INSERT INTO `measureunit_conversion` VALUES ('7935DC1A9D0E4DB48199FF169', '', '', '2016-07-28 19:08:12', '2016-07-28 19:08:12', '', '1', '吨', '1000000.00', '1', 'weight');
INSERT INTO `measureunit_conversion` VALUES ('7C7CF7C138094D5DA64BA1229', '', '', '2016-07-28 19:29:13', '2016-07-28 19:29:13', '', '1', '个', '1.00', '1', 'ge');
INSERT INTO `measureunit_conversion` VALUES ('835E3F3392D9448EB84FEDD19', '', '', '2016-07-28 19:36:27', '2016-07-28 19:36:27', '', '1', '片', '1.00', '1', 'pare');
INSERT INTO `measureunit_conversion` VALUES ('C0990D40AF3242C887A044C43', '', '', '2016-07-28 19:16:01', '2016-07-28 19:16:01', '', '1', '米', '100.00', '2', 'lenght');
INSERT INTO `measureunit_conversion` VALUES ('C558305B8012457F93E437F2A', '', '', '2016-07-28 19:11:52', '2016-07-28 19:11:52', '', '1', '平方厘米', '100.00', '3', 'area');
INSERT INTO `measureunit_conversion` VALUES ('D0B5CCA03F7943F6B0FC645EE', '', '', '2016-07-28 19:16:01', '2016-07-28 19:16:01', '', '1', '分米', '10.00', '3', 'lenght');
INSERT INTO `measureunit_conversion` VALUES ('D29B237A3F854A61AEE736D83', '', '', '2016-07-28 19:37:10', '2016-07-28 19:37:10', '', '1', '卷', '1.00', '1', 'juan');
INSERT INTO `measureunit_conversion` VALUES ('D29B867F0023423FA61F4D11D', '', '', '2016-07-28 19:08:12', '2016-07-28 19:08:12', '', '1', '千克', '1000.00', '2', 'weight');
INSERT INTO `measureunit_conversion` VALUES ('F152C2077FB242FF84DBB34BF', '', '', '2016-10-13 10:08:41', '2016-10-13 10:08:41', '', '1', '筒', '1.00', '1', 'tong');
INSERT INTO `measureunit_conversion` VALUES ('F54F5CDABE6641B398BE8EF52', '', '', '2016-07-28 19:11:52', '2016-07-28 19:11:52', '', '1', '平方米', '1000000.00', '1', 'area');

-- ----------------------------
-- Table structure for measureunit_type
-- ----------------------------
DROP TABLE IF EXISTS `measureunit_type`;
CREATE TABLE `measureunit_type` (
  `measureunit_type_code` varchar(40) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `measureunit_type_name` varchar(40) NOT NULL,
  `sort_seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`measureunit_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of measureunit_type
-- ----------------------------
INSERT INTO `measureunit_type` VALUES ('area', '', '', '2016-07-28 19:11:52', null, null, '1', '面积', '0');
INSERT INTO `measureunit_type` VALUES ('bao', '', '', '2016-07-28 19:36:55', null, null, '1', '包', '0');
INSERT INTO `measureunit_type` VALUES ('ge', '', '', '2016-07-28 19:29:13', null, null, '1', '个', '0');
INSERT INTO `measureunit_type` VALUES ('juan', '', '', '2016-07-28 19:37:10', null, null, '1', '卷', '0');
INSERT INTO `measureunit_type` VALUES ('lenght', '', '', '2016-07-28 20:01:30', '2016-07-28 20:01:30', '', '1', '长度', '0');
INSERT INTO `measureunit_type` VALUES ('pare', '', '', '2016-07-28 19:36:27', null, null, '1', '片', '0');
INSERT INTO `measureunit_type` VALUES ('tiao', '', '', '2016-07-28 19:37:27', null, null, '1', '条', '0');
INSERT INTO `measureunit_type` VALUES ('tong', '', '', '2016-10-13 10:13:49', null, null, '1', '筒', '0');
INSERT INTO `measureunit_type` VALUES ('weight', '', '', '2016-08-01 17:13:12', '2016-08-01 17:13:12', '', '1', '重量', '0');
INSERT INTO `measureunit_type` VALUES ('zhang', '', '', '2016-07-28 19:34:59', null, null, '1', '张', '0');
INSERT INTO `measureunit_type` VALUES ('zhi', '', '', '2016-09-03 11:00:09', null, null, '1', '支', '0');

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
INSERT INTO `menu` VALUES ('088da451e975439cb4ad0c76b9403d7e', 'd889014192454eb786619a77436a8487', 'sys.user', '1', '用户管理', '1', null, '2017-08-22 17:46:09', null, null);
INSERT INTO `menu` VALUES ('19386519d09a4af3a9df025dcadb3eb8', 'f8ee2a1bfca742a19663a4a0e1df23f3', 'sys.menu.add', '2', '新增', '0', null, '2017-08-22 17:56:36', null, null);
INSERT INTO `menu` VALUES ('19a966bd282b4d51bdb4e85806a1e722', '088da451e975439cb4ad0c76b9403d7e', 'sys.user.view', '2', '查看', '2', null, '2017-08-22 18:00:59', null, null);
INSERT INTO `menu` VALUES ('22fb1cf3362a48a39fc0d5bda807757f', '088da451e975439cb4ad0c76b9403d7e', 'sys.user.delete', '2', '删除', '3', null, '2017-08-22 18:02:02', null, null);
INSERT INTO `menu` VALUES ('32eaa314572e43b6bf32a46bf39d1cf5', '8ae096af6f434760993e2cc1eaf563a2', 'sys.role.delete', '2', '删除', '0', null, '2017-08-22 17:58:13', null, null);
INSERT INTO `menu` VALUES ('47b5f9c06ad647f18478fcf1a0306965', 'f8ee2a1bfca742a19663a4a0e1df23f3', 'sys.menu.view', '2', '查看', '3', null, '2017-08-22 17:57:20', null, null);
INSERT INTO `menu` VALUES ('55853f10668b4d2fa4d09f2841a5c229', 'f8ee2a1bfca742a19663a4a0e1df23f3', 'sys.menu.delete', '2', '删除', '2', null, '2017-08-22 17:57:10', null, null);
INSERT INTO `menu` VALUES ('7ccbb402be5f4da3964d236f1959d099', '088da451e975439cb4ad0c76b9403d7e', 'sys.user.add', '2', '新增', '0', null, '2017-08-22 18:00:37', null, null);
INSERT INTO `menu` VALUES ('8ae096af6f434760993e2cc1eaf563a2', 'd889014192454eb786619a77436a8487', 'sys.role', '1', '角色管理', '0', null, '2017-08-22 17:45:54', null, null);
INSERT INTO `menu` VALUES ('916e4a00797b420f86cf3cb9b41de8de', 'f8ee2a1bfca742a19663a4a0e1df23f3', 'sys.menu.edit', '2', '修改', '1', null, '2017-08-22 17:56:55', null, null);
INSERT INTO `menu` VALUES ('9ad3ec5a35a14ff49a166b584310f1e3', '8ae096af6f434760993e2cc1eaf563a2', 'sys.role.edit', '2', '修改', '5', null, '2017-08-22 17:59:33', null, null);
INSERT INTO `menu` VALUES ('a0a34c1fbb244249a80b81112a550cba', '088da451e975439cb4ad0c76b9403d7e', 'sys.user.edit', '2', '修改', '1', null, '2017-08-22 18:00:44', null, null);
INSERT INTO `menu` VALUES ('a9c0742fc9cc4e318d99c5a799f79761', null, 'home', '0', '首页', '0', null, '2017-08-22 17:41:52', null, null);
INSERT INTO `menu` VALUES ('b69bba6be55f434f85e242210239e253', '8ae096af6f434760993e2cc1eaf563a2', 'sys.role.add', '2', '新增', '6', null, '2017-08-22 17:59:54', null, null);
INSERT INTO `menu` VALUES ('d884066cd2f243899b3268b30d00a59c', '8ae096af6f434760993e2cc1eaf563a2', 'sys.role.view', '2', '查看', '4', null, '2017-08-22 17:57:49', null, null);
INSERT INTO `menu` VALUES ('d889014192454eb786619a77436a8487', null, 'sys', '0', '系统管理', '1', null, '2017-08-22 17:42:05', null, null);
INSERT INTO `menu` VALUES ('f8ee2a1bfca742a19663a4a0e1df23f3', 'd889014192454eb786619a77436a8487', 'sys.menu', '1', '菜单管理', '2', null, '2017-08-22 17:46:43', null, null);

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
INSERT INTO `role` VALUES ('2d82fc40747d4fe2bff585639218bb3d', 'admin', '系统管理员', null, 'ecea08c54a7a42b0819690a3f26f78fc', 'ecea08c54a7a42b0819690a3f26f78fc', '2017-08-22 17:30:32', null, null);
INSERT INTO `role` VALUES ('701e3d969ccb45f698e1301asfasfasf', 'user3', '普通用户3', null, null, null, null, null, null);
INSERT INTO `role` VALUES ('701e3d969ccb45f698e1301b45a4661a', 'user1', '普通用户1', null, 'ecea08c54a7a42b0819690a3f26f78fc', 'ecea08c54a7a42b0819690a3f26f78fc', '2017-08-22 17:30:42', null, null);
INSERT INTO `role` VALUES ('b908f9a06034425397539a9536db0bb9', 'user2', '普通用户2', null, 'ecea08c54a7a42b0819690a3f26f78fc', 'ecea08c54a7a42b0819690a3f26f78fc', '2017-08-22 17:30:45', null, null);
INSERT INTO `role` VALUES ('b908f9a06034425397539a9536ddfsdf', 'fewfwef', 'fewfwe', 'b908f9a06034425397539a9536db0bb9', null, null, null, null, null);

-- ----------------------------
-- Table structure for role_menu_rel
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_rel`;
CREATE TABLE `role_menu_rel` (
  `id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单关系表';

-- ----------------------------
-- Records of role_menu_rel
-- ----------------------------
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fe2bff585639218bb3s', '2d82fc40747d4fe2bff585639218bb3d', '088da451e975439cb4ad0c76b9403d7e');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fe2bff585639218bsdf', '2d82fc40747d4fe2bff585639218bb3d', '19386519d09a4af3a9df025dcadb3eb8');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fe2bff585639218bfsd', '2d82fc40747d4fe2bff585639218bb3d', '19a966bd282b4d51bdb4e85806a1e722');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fe2bff585639218bsvd', '2d82fc40747d4fe2bff585639218bb3d', '22fb1cf3362a48a39fc0d5bda807757f');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fe2bff585639218bsdf', '2d82fc40747d4fe2bff585639218bb3d', '32eaa314572e43b6bf32a46bf39d1cf5');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fe2bff585639sdfbb3d', '2d82fc40747d4fe2bff585639218bb3d', '47b5f9c06ad647f18478fcf1a0306965');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fsdfsdfs5639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', '55853f10668b4d2fa4d09f2841a5c229');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4fe2sdf585639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', '7ccbb402be5f4da3964d236f1959d099');
INSERT INTO `role_menu_rel` VALUES ('ssdfsdewrwerwerwerwd132431231r41', '2d82fc40747d4fe2bff585639218bb3d', '8ae096af6f434760993e2cc1eaf563a2');
INSERT INTO `role_menu_rel` VALUES ('dsgdsge534534523t3ttewrt342t342t', '2d82fc40747d4fe2bff585639218bb3d', '916e4a00797b420f86cf3cb9b41de8de');
INSERT INTO `role_menu_rel` VALUES ('geeg4353534532rgfewrgesgwegsdg43', '2d82fc40747d4fe2bff585639218bb3d', '9ad3ec5a35a14ff49a166b584310f1e3');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40dgdfgfdgbff585639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', 'a0a34c1fbb244249a80b81112a550cba');
INSERT INTO `role_menu_rel` VALUES ('2d82fc4074143fe2bff585639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', 'a9c0742fc9cc4e318d99c5a799f79761');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747dwerwe1f585639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', 'b69bba6be55f434f85e242210239e253');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747were2bff585639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', 'd884066cd2f243899b3268b30d00a59c');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747d4234bff585639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', 'd889014192454eb786619a77436a8487');
INSERT INTO `role_menu_rel` VALUES ('2d82fc40747dwerwbff585639218bb3d', '2d82fc40747d4fe2bff585639218bb3d', 'f8ee2a1bfca742a19663a4a0e1df23f3');
INSERT INTO `role_menu_rel` VALUES ('701e3d969ccb45f698e1asdasdasdasd', '701e3d969ccb45f698e1301asfasfasf', '19386519d09a4af3a9df025dcadb3eb8');
INSERT INTO `role_menu_rel` VALUES ('701e3d969ccb4faf3423rwetyerwtert', '701e3d969ccb45f698e1301asfasfasf', '088da451e975439cb4ad0c76b9403d7e');
INSERT INTO `role_menu_rel` VALUES ('701e3d969ccb45f698e1301b45fd23r3', '701e3d969ccb45f698e1301b45a4661a', '19386519d09a4af3a9df025dcadb3eb8');

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `sku_code` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL COMMENT 'sku名称',
  `user_group_id` varchar(40) DEFAULT NULL COMMENT '组织',
  `HAS_BOM_STATUS` tinyint(4) DEFAULT '0' COMMENT '是否有子对象， 1 true  (如果有BOM, 肯定有子对象, 也为true)',
  `category` varchar(40) DEFAULT NULL COMMENT '三级分类',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态    1:正常，-1:禁用',
  `bom_status` int(11) DEFAULT NULL COMMENT 'BOM是否完备 1:完备 0:不完备',
  `measure_unit_id` varchar(40) DEFAULT NULL COMMENT '计量单位',
  `pictures` varchar(511) DEFAULT NULL COMMENT '图片路径，多个用英文逗号分隔',
  `comment` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(40) DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(40) DEFAULT NULL COMMENT '修改人',
  `PIFFER` decimal(20,2) DEFAULT NULL COMMENT '皮费',
  PRIMARY KEY (`sku_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES ('7f72514d4b934146a736670b2f78f6f4', '物料2', null, '0', null, '1', '-1', null, 'string', 'string', '2017-08-24 18:12:59', 'string', '2017-08-24 18:21:21', null, '10.00');
INSERT INTO `sku` VALUES ('8f32634914294cdcbb0e8c15442530f3', '纸盒1', null, '0', 'ba7d2d7a0e8d4b369260da6ffcd4363b', '1', '-1', null, '', '测试SKU', '2017-08-25 16:04:24', 'ecea08c54a7a42b0819690a3f26f78fc', null, null, '10.00');

-- ----------------------------
-- Table structure for sku_bom
-- ----------------------------
DROP TABLE IF EXISTS `sku_bom`;
CREATE TABLE `sku_bom` (
  `sku_code` varchar(64) NOT NULL,
  `bom_sku_code` varchar(64) NOT NULL COMMENT '物料的sku_code',
  `measure_unit_id` varchar(40) NOT NULL COMMENT '计量单位',
  `qty` decimal(12,4) NOT NULL COMMENT '存货数量的分子部分',
  `QTY_DENOMINATOR` int(8) DEFAULT NULL COMMENT '存货数量的分母部分',
  `WASTE_RATE` decimal(6,6) DEFAULT NULL COMMENT '损耗率',
  `is_deleted_record` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为删除节点，此时其它参数，如数量，损耗率将无意义',
  `COMMENT` varchar(255) DEFAULT '',
  `sku_version` int(11) NOT NULL COMMENT '创建该记录时,sku的当前版本号',
  `CREATE_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATOR` varchar(40) NOT NULL DEFAULT '' COMMENT '创建人',
  PRIMARY KEY (`sku_code`,`bom_sku_code`,`sku_version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BOM关系表（主线），一经创建，任意字段均不再修改';

-- ----------------------------
-- Records of sku_bom
-- ----------------------------

-- ----------------------------
-- Table structure for sku_type
-- ----------------------------
DROP TABLE IF EXISTS `sku_type`;
CREATE TABLE `sku_type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `parentId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sku_type
-- ----------------------------
INSERT INTO `sku_type` VALUES ('026c1f3db2784da5aaf46965f2c9f2cd', '内顶', '我是内顶', '2017-08-25 10:17:54', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '3929a565d16c47c2b1ba414d5339abb1');
INSERT INTO `sku_type` VALUES ('0df9613e356344a78ca6cd0a731a11cc', '铁盒', '我是铁盒', '2017-08-25 15:48:25', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '3ecbcd8b56ce466599d6e5612305dbad');
INSERT INTO `sku_type` VALUES ('16a9aecc001e47fb8354910a664781b1', '绒盒(3级)', '我是绒盒', '2017-08-25 15:50:22', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '1ea310b953cc4eb189a39973be162e1c');
INSERT INTO `sku_type` VALUES ('1ea310b953cc4eb189a39973be162e1c', '绒盒', '我是绒盒', '2017-08-25 15:48:11', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '3ecbcd8b56ce466599d6e5612305dbad');
INSERT INTO `sku_type` VALUES ('1fb82638499b4ce79306bae170429e0f', '纸盒', '我是纸盒', '2017-08-25 15:48:47', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '3ecbcd8b56ce466599d6e5612305dbad');
INSERT INTO `sku_type` VALUES ('24012137b8844377958877a709d2d564', '内芯布', '我是内芯布', '2017-08-25 15:47:17', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, 'aae26a356f1945499af1ba211d604865');
INSERT INTO `sku_type` VALUES ('2adca39f0ed243869c383523dd961c3f', '内心卡', '我是内心卡', '2017-08-25 15:47:37', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, 'aae26a356f1945499af1ba211d604865');
INSERT INTO `sku_type` VALUES ('3320ab7a06694c2a9eec2a732c155b87', '原料', '我是原料', '2017-08-25 09:41:34', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, null);
INSERT INTO `sku_type` VALUES ('3929a565d16c47c2b1ba414d5339abb1', '半成品', '我是半成品', '2017-08-25 09:17:55', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, null);
INSERT INTO `sku_type` VALUES ('3ecbcd8b56ce466599d6e5612305dbad', '产成品', '我是产成品', '2017-08-25 09:41:23', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, null);
INSERT INTO `sku_type` VALUES ('8c45164314964ec8a6d57d4c2bd07f95', '铁盒(3级)', '我是铁盒', '2017-08-25 15:49:47', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '0df9613e356344a78ca6cd0a731a11cc');
INSERT INTO `sku_type` VALUES ('aae26a356f1945499af1ba211d604865', '内芯', '我是内芯', '2017-08-25 10:19:26', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '3929a565d16c47c2b1ba414d5339abb1');
INSERT INTO `sku_type` VALUES ('ba7d2d7a0e8d4b369260da6ffcd4363b', '纸盒(3级)', '我是纸盒', '2017-08-25 15:50:48', null, 'ecea08c54a7a42b0819690a3f26f78fc', null, '1fb82638499b4ce79306bae170429e0f');
INSERT INTO `sku_type` VALUES ('d5c62dd39fba4dbca640ba783a0ca3cc', '备品', '我是备品', '2017-08-25 09:41:42', '2017-08-25 09:55:09', 'ecea08c54a7a42b0819690a3f26f78fc', 'ecea08c54a7a42b0819690a3f26f78fc', null);

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
INSERT INTO `user` VALUES ('17a79695204c4c9ea414db5d9613d59b', '295277302@qq.com', 'acumes', '15820356452', 'Acumes', '1', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '昊祯', '1', 'string', null, '2017-08-22 17:22:53', 'ecea08c54a7a42b0819690a3f26f78fc', null, null);
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
INSERT INTO `user_role_rel` VALUES ('08561ea50fc64174b4c2393213dd8a5d', 'ecea08c54a7a42b0819690a3f26f78fc', '2d82fc40747d4fe2bff585639218bb3d');
INSERT INTO `user_role_rel` VALUES ('17a79695204c4c9ea414db5ddfdsf324', '17a79695204c4c9ea414db5d9613d59b', '701e3d969ccb45f698e1301b45a4661a');
INSERT INTO `user_role_rel` VALUES ('17a79695204c4c9ea414db5ddfdsf124', 'ecea08c54a7a42b0819690a3f26f78fc', '701e3d969ccb45f698e1301b45a4661a');
INSERT INTO `user_role_rel` VALUES ('701e3d969ccb45f698e1301asfasfasf', '17a79695204c4c9ea414db5d9613d59b', '701e3d969ccb45f698e1301asfasfasf');

-- ----------------------------
-- Table structure for version_center
-- ----------------------------
DROP TABLE IF EXISTS `version_center`;
CREATE TABLE `version_center` (
  `branch_id` varchar(28) NOT NULL COMMENT '分支ID',
  `type` varchar(8) NOT NULL COMMENT '类型，目前有spu、sku',
  `fork_version` int(11) NOT NULL COMMENT '该分支从主线的哪个版本创建的',
  `cur_version` int(11) NOT NULL COMMENT '该分支的当前版本号',
  `ref_type` varchar(16) NOT NULL COMMENT '外键类型，防止不同模块创建分支时带过来的ID重复的情况。主线的那条记录定为master',
  `ref_id` varchar(64) NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '状态    1:正常，-1:禁用',
  `crt_time` datetime NOT NULL COMMENT '创建时间',
  `creator` varchar(40) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`branch_id`),
  UNIQUE KEY `INDEX_BOM_COST_BRANCH_UNIQUE` (`type`,`ref_id`,`ref_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='版本维护中心，目前有spu\\sku的全局版本（本身没有版本，是其下面的bom\\cost的版本），以及对应的各个分支的全局版本';

-- ----------------------------
-- Records of version_center
-- ----------------------------
INSERT INTO `version_center` VALUES ('master_sku', 'sku', '1', '22', 'master', 'meanless', '1', '2016-12-01 11:30:15', 'system');
