/*
Navicat MySQL Data Transfer

Source Server         : system
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : mychat

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-08-07 20:41:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cuser`
-- ----------------------------
DROP TABLE IF EXISTS `cuser`;
CREATE TABLE `cuser` (
  `uid` int(8) NOT NULL COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `nickname` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '昵称',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of cuser
-- ----------------------------
INSERT INTO `cuser` VALUES ('1', 'just', '123456', '奔波儿灞');
INSERT INTO `cuser` VALUES ('2', 'just2', '123456', '霸波儿奔');
INSERT INTO `cuser` VALUES ('3', 'just3', '123456', '九头虫');

-- ----------------------------
-- Table structure for `messages`
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `mid` int(8) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `fromUserId` int(8) NOT NULL COMMENT '发送消息方',
  `toUserId` int(8) NOT NULL COMMENT '接收消息方',
  `message` varchar(140) CHARACTER SET utf8 NOT NULL COMMENT '发送的消息',
  `messageTime` datetime NOT NULL COMMENT '消息时间',
  `messageState` int(1) NOT NULL COMMENT '信息状态，1为已发送，0为未发送',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES ('44', '1', '2', '我是谁啊', '2016-08-07 20:16:30', '1');
INSERT INTO `messages` VALUES ('45', '2', '1', '你是我的小伙伴啊', '2016-08-07 20:28:17', '1');
INSERT INTO `messages` VALUES ('46', '1', '2', '呵呵哒', '2016-08-07 20:28:28', '1');
INSERT INTO `messages` VALUES ('47', '2', '1', '么么哒', '2016-08-07 20:28:53', '1');
INSERT INTO `messages` VALUES ('48', '1', '2', '笨笨哒', '2016-08-07 20:29:02', '1');
INSERT INTO `messages` VALUES ('49', '2', '1', 'QNMLGB', '2016-08-07 20:29:14', '1');
INSERT INTO `messages` VALUES ('50', '1', '2', 'MDZZ', '2016-08-07 20:29:25', '1');
INSERT INTO `messages` VALUES ('51', '2', '1', '你个妖怪', '2016-08-07 20:29:42', '1');
INSERT INTO `messages` VALUES ('52', '1', '2', '你个鱼精', '2016-08-07 20:30:00', '1');
INSERT INTO `messages` VALUES ('53', '2', '1', '你个二货', '2016-08-07 20:30:07', '1');
INSERT INTO `messages` VALUES ('54', '1', '2', '你个萌萌哒', '2016-08-07 20:30:21', '1');
INSERT INTO `messages` VALUES ('55', '1', '2', '来发个长的看看，哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈', '2016-08-07 20:30:51', '1');
INSERT INTO `messages` VALUES ('56', '2', '1', '切。。。。看我标点符号。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2016-08-07 20:31:32', '1');
INSERT INTO `messages` VALUES ('57', '2', '1', '出bug了吧。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '2016-08-07 20:31:52', '1');
