/*
Navicat MySQL Data Transfer

Source Server         : Amayadream
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : webchat

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-01-11 19:26:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` varchar(255) DEFAULT NULL COMMENT '日志编号',
  `userid` varchar(255) DEFAULT NULL COMMENT '用户名',
  `time` varchar(255) DEFAULT NULL COMMENT '操作时间',
  `type` varchar(255) DEFAULT NULL COMMENT '操作类型',
  `detail` varchar(255) DEFAULT NULL COMMENT '详情',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  KEY `fk_log_userid` (`userid`),
  CONSTRAINT `fk_log_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('a9786c018d854226bdfa0ab74d4045cf', 'Amayadream', '2017-01-11 19:20:43', '登陆', '用户登陆', null);
INSERT INTO `log` VALUES ('9136815071cc450ba00d9b693247dff2', 'Amayadream', '2017-01-11 19:21:26', '更新', '更新用户头像', null);
INSERT INTO `log` VALUES ('2be39dd8511c41259bfa2885353e94ad', 'Amayadream', '2017-01-11 19:21:52', '登陆', '用户登陆', null);
INSERT INTO `log` VALUES ('a48f35f8d3f84db1addc42cbf8835ac8', 'Amayadream', '2017-01-11 19:22:15', '登陆', '用户登陆', null);
INSERT INTO `log` VALUES ('48083bcfca7b4dbdb7236561cc118839', 'Amayadream', '2017-01-11 19:22:18', '登陆', '用户登陆', null);
INSERT INTO `log` VALUES ('2c83a3d453d94f83ac7595b4bb1fc2c6', 'Amayadream', '2017-01-11 19:22:21', '登陆', '用户登陆', null);
INSERT INTO `log` VALUES ('d05d2127977146dfbd0cf6076283c9e9', 'admin', '2017-01-11 19:23:20', '登陆', '用户登陆', null);
INSERT INTO `log` VALUES ('19b6f5ec3d6a4a3aacbbae28ea23afd2', 'admin', '2017-01-11 19:24:04', '更新', '更新用户头像', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `age` int(5) DEFAULT NULL COMMENT '年龄',
  `profilehead` varchar(255) DEFAULT NULL COMMENT '头像',
  `profile` varchar(255) DEFAULT NULL COMMENT '简介',
  `firsttime` varchar(255) DEFAULT NULL COMMENT '注册时间',
  `lasttime` varchar(255) DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT NULL COMMENT '账号状态(1正常 0禁用)',
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Amayadream', '123456', 'Amayadream', '1', '23', 'upload/Amayadream/Amayadream.jpg', 'are you ok?', '2017-01-11 19:22:21', '2017-01-11 19:22:21', '1');
INSERT INTO `user` VALUES ('admin', 'admin', 'admin', '1', '23', 'upload/admin/admin.jpg', 'i\'m admin', '2017-01-11 19:22:21', '2017-01-11 19:23:20', '1');
