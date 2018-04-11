/*
Navicat MySQL Data Transfer

Source Server         : loc
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : pharmacy

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-11 17:04:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cangku`
-- ----------------------------
DROP TABLE IF EXISTS `cangku`;
CREATE TABLE `cangku` (
  `cangkuID` int(111) NOT NULL AUTO_INCREMENT,
  `cangkuMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cangkuID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cangku
-- ----------------------------
INSERT INTO `cangku` VALUES ('1', '仓库1');
INSERT INTO `cangku` VALUES ('2', 'b1');
INSERT INTO `cangku` VALUES ('3', 'bc');
INSERT INTO `cangku` VALUES ('4', 'bca');

-- ----------------------------
-- Table structure for `cangkushezi`
-- ----------------------------
DROP TABLE IF EXISTS `cangkushezi`;
CREATE TABLE `cangkushezi` (
  `id` int(111) NOT NULL AUTO_INCREMENT,
  `cangkuID` int(111) NOT NULL,
  `yaopingID` int(111) NOT NULL,
  `zuishaoshuliang` int(111) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cangkushezi
-- ----------------------------
INSERT INTO `cangkushezi` VALUES ('1', '1', '1', '10');
INSERT INTO `cangkushezi` VALUES ('2', '1', '2', '10');

-- ----------------------------
-- Table structure for `dingdan`
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan` (
  `dingdanID` int(111) NOT NULL AUTO_INCREMENT,
  `dingdanBianhao` varchar(255) COLLATE utf8_bin NOT NULL,
  `yaopingID` int(111) NOT NULL,
  `danjia` double(111,11) NOT NULL,
  `shuliang` int(11) NOT NULL,
  `zongjia` double(111,11) NOT NULL,
  `dingdanleixing` int(11) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `gongyingshangID` int(111) NOT NULL,
  `kehuID` int(11) DEFAULT NULL,
  `cangkuID` int(111) DEFAULT NULL,
  `complete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dingdanID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
INSERT INTO `dingdan` VALUES ('1', '1001', '10', '0.90000000000', '10', '9.00000000000', '1', '2018-04-10 18:36:50', '2', '0', '1', '0');
INSERT INTO `dingdan` VALUES ('2', '1002', '7', '2.30000000000', '50', '115.00000000000', '1', '2018-04-11 08:36:22', '1', '0', '2', '1');
INSERT INTO `dingdan` VALUES ('3', '10001', '9', '2.60000000000', '90', '234.00000000000', '2', '2018-04-11 08:38:03', '2', '0', '1', '1');
INSERT INTO `dingdan` VALUES ('4', '10002', '8', '5.90000000000', '30', '177.00000000000', '2', '2018-04-11 08:39:37', '1', '0', '4', '1');
INSERT INTO `dingdan` VALUES ('5', '2003', '9', '2.70000000000', '60', '162.00000000000', '3', '2018-04-11 09:40:25', '0', '3', '2', '0');
INSERT INTO `dingdan` VALUES ('6', '2004', '10', '5.60000000000', '80', '448.00000000000', '3', '2018-04-11 09:40:50', '0', '3', '2', '1');
INSERT INTO `dingdan` VALUES ('8', '20002', '8', '2.60000000000', '50', '130.00000000000', '4', '2018-04-11 09:57:31', '0', '1', '2', '1');
INSERT INTO `dingdan` VALUES ('10', '20003', '10', '23.00000000000', '56', '1288.00000000000', '4', '2018-04-11 10:32:18', '0', '3', '3', '1');
INSERT INTO `dingdan` VALUES ('11', '1003', '7', '1.00000000000', '1', '1.00000000000', '1', '2018-04-11 16:32:23', '1', '0', '1', '0');
INSERT INTO `dingdan` VALUES ('12', '1004', '7', '1.00000000000', '1', '1.00000000000', '1', '2018-04-11 16:32:37', '1', '0', '1', '0');

-- ----------------------------
-- Table structure for `fukuandan`
-- ----------------------------
DROP TABLE IF EXISTS `fukuandan`;
CREATE TABLE `fukuandan` (
  `fukuandanID` int(111) NOT NULL AUTO_INCREMENT,
  `zhanghuID` int(111) NOT NULL,
  `dingdanID` int(111) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `qianshu` double(111,11) NOT NULL,
  `zhuangtai` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`fukuandanID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of fukuandan
-- ----------------------------
INSERT INTO `fukuandan` VALUES ('1', '0', '1', '2015-06-16', '11111.00000000000', '1');
INSERT INTO `fukuandan` VALUES ('2', '0', '1', '2016-08-08', '1.00000000000', '1');
INSERT INTO `fukuandan` VALUES ('4', '0', '1', '2017-08-08', '10.00000000000', '0');

-- ----------------------------
-- Table structure for `gongyingshang`
-- ----------------------------
DROP TABLE IF EXISTS `gongyingshang`;
CREATE TABLE `gongyingshang` (
  `gongyingshangID` int(111) NOT NULL AUTO_INCREMENT,
  `gongyingshangMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `mingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `dianhua` varchar(111) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`gongyingshangID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gongyingshang
-- ----------------------------
INSERT INTO `gongyingshang` VALUES ('1', 'b1', '33', '32');
INSERT INTO `gongyingshang` VALUES ('2', 'B2', '2', '2');

-- ----------------------------
-- Table structure for `kehu`
-- ----------------------------
DROP TABLE IF EXISTS `kehu`;
CREATE TABLE `kehu` (
  `kehuID` int(111) NOT NULL AUTO_INCREMENT,
  `kehuMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `kehuShouji` varchar(111) COLLATE utf8_bin NOT NULL,
  `kehuQQ` varchar(111) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`kehuID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of kehu
-- ----------------------------
INSERT INTO `kehu` VALUES ('1', 'C2', '142', '450');
INSERT INTO `kehu` VALUES ('3', 'C1', '15', '55');

-- ----------------------------
-- Table structure for `kucun`
-- ----------------------------
DROP TABLE IF EXISTS `kucun`;
CREATE TABLE `kucun` (
  `kucunID` int(111) NOT NULL AUTO_INCREMENT,
  `yaopingID` int(111) NOT NULL,
  `yaopingMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `dingdanhao` int(111) NOT NULL,
  `yaopingDanwei` varchar(111) COLLATE utf8_bin NOT NULL,
  `shuliang` int(111) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `zhuangtai` int(111) NOT NULL,
  PRIMARY KEY (`kucunID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of kucun
-- ----------------------------
INSERT INTO `kucun` VALUES ('1', '1', 'drugs1', '1', 'pcs', '10', '2018-04-01', '1');
INSERT INTO `kucun` VALUES ('2', '2', 'drugs2', '2', 'pcs', '20', '2018-04-01', '1');
INSERT INTO `kucun` VALUES ('5', '1', 'drugs1', '1', 'pcs', '5', '2018-04-01', '2');
INSERT INTO `kucun` VALUES ('6', '2', 'drugs2', '2', 'pcs', '17', '2018-04-01', '2');
INSERT INTO `kucun` VALUES ('7', '1', 'null', '0', 'dw1', '1', '2019-08-08', '1');
INSERT INTO `kucun` VALUES ('8', '1', 'null', '6', 'DW', '1', '2019-08-09', '2');
INSERT INTO `kucun` VALUES ('9', '1', '1', '0', '1', '1', '2018-08-08', '1');
INSERT INTO `kucun` VALUES ('10', '1', 'null', '1', '1', '1', '2018-09-01', '2');

-- ----------------------------
-- Table structure for `rizhi`
-- ----------------------------
DROP TABLE IF EXISTS `rizhi`;
CREATE TABLE `rizhi` (
  `rizhiID` int(111) NOT NULL AUTO_INCREMENT,
  `yonghuID` int(111) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `neirong` varchar(111) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`rizhiID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of rizhi
-- ----------------------------
INSERT INTO `rizhi` VALUES ('1', '1', '2018-03-20', '1DSAD');
INSERT INTO `rizhi` VALUES ('2', '2', '2018-03-28', '232');
INSERT INTO `rizhi` VALUES ('3', '1', '2018-03-27', '32344');
INSERT INTO `rizhi` VALUES ('4', '2', '2018-03-05', '43434');
INSERT INTO `rizhi` VALUES ('5', '1', '2018-04-06', 'ting登录');
INSERT INTO `rizhi` VALUES ('6', '1', '2018-04-06', 'ting登录');
INSERT INTO `rizhi` VALUES ('7', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('8', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('9', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('10', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('11', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('12', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('13', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('14', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('15', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('16', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('17', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('18', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('19', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('20', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('21', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('22', '1', '2018-04-10', 'ting退出');
INSERT INTO `rizhi` VALUES ('23', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('24', '1', '2018-04-10', 'ting退出');
INSERT INTO `rizhi` VALUES ('25', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('26', '1', '2018-04-10 13:32:35', 'ting退出');
INSERT INTO `rizhi` VALUES ('27', '1', '2018-04-10', 'ting登录');
INSERT INTO `rizhi` VALUES ('28', '1', '2018-04-10 13:55:34', 'ting退出');
INSERT INTO `rizhi` VALUES ('29', '1', '2018-04-10 13:55:37', 'ting登录');
INSERT INTO `rizhi` VALUES ('30', '1', '2018-04-10 14:37:20', 'ting退出');
INSERT INTO `rizhi` VALUES ('31', '1', '2018-04-10 14:37:21', 'ting登录');
INSERT INTO `rizhi` VALUES ('32', '1', '2018-04-10 14:37:42', 'ting退出');
INSERT INTO `rizhi` VALUES ('33', '1', '2018-04-10 14:37:45', 'ting登录');
INSERT INTO `rizhi` VALUES ('34', '1', '2018-04-10 14:42:04', 'ting登录');
INSERT INTO `rizhi` VALUES ('35', '1', '2018-04-10 14:42:43', 'ting退出');
INSERT INTO `rizhi` VALUES ('36', '1', '2018-04-10 14:42:44', 'ting登录');
INSERT INTO `rizhi` VALUES ('37', '1', '2018-04-10 14:43:19', 'ting退出');
INSERT INTO `rizhi` VALUES ('38', '1', '2018-04-10 14:43:21', 'ting登录');
INSERT INTO `rizhi` VALUES ('39', '1', '2018-04-11 08:35:03', 'ting登录');
INSERT INTO `rizhi` VALUES ('40', '1', '2018-04-11 09:02:58', 'ting登录');

-- ----------------------------
-- Table structure for `rukuandan`
-- ----------------------------
DROP TABLE IF EXISTS `rukuandan`;
CREATE TABLE `rukuandan` (
  `rukuandanID` int(111) NOT NULL AUTO_INCREMENT,
  `zhanghuID` int(111) NOT NULL,
  `dingdanID` int(111) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `qianshu` double(111,11) NOT NULL,
  `zhuangtai` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rukuandanID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of rukuandan
-- ----------------------------
INSERT INTO `rukuandan` VALUES ('1', '1', '0', '2015-06-18', '111.00000000000', '1');
INSERT INTO `rukuandan` VALUES ('3', '1', '0', '2018-03-31', '1.00000000000', '0');
INSERT INTO `rukuandan` VALUES ('5', '1', '0', '2018-09-09', '10.00000000000', '0');

-- ----------------------------
-- Table structure for `yaoping`
-- ----------------------------
DROP TABLE IF EXISTS `yaoping`;
CREATE TABLE `yaoping` (
  `yaopingID` int(111) NOT NULL AUTO_INCREMENT,
  `yaopingBianhao` varchar(255) COLLATE utf8_bin NOT NULL,
  `yaopingMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `yaopingDanwei` varchar(111) COLLATE utf8_bin NOT NULL,
  `youxiaoqi` int(111) NOT NULL,
  `jingjia` double(111,11) NOT NULL,
  `gongyingshangMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `shuliang` int(111) NOT NULL,
  PRIMARY KEY (`yaopingID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of yaoping
-- ----------------------------
INSERT INTO `yaoping` VALUES ('7', '1003', 'ceshi1', '1', '11', '10.00000000000', 'b1', '0');
INSERT INTO `yaoping` VALUES ('8', '1004', 'ceshi4', '1', '1', '1.00000000000', 'b1', '0');
INSERT INTO `yaoping` VALUES ('9', '1002', 'ceshi2', '1', '1', '1.00000000000', 'b1', '0');
INSERT INTO `yaoping` VALUES ('10', '1001', 'ceshi3', '1', '1', '1.00000000000', 'b1', '0');

-- ----------------------------
-- Table structure for `yonghu`
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu` (
  `yonghuID` int(111) NOT NULL AUTO_INCREMENT,
  `yonghuMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `dengluMingzi` varchar(111) COLLATE utf8_bin DEFAULT NULL,
  `miMa` varchar(111) COLLATE utf8_bin DEFAULT NULL,
  `zhiwu` int(111) NOT NULL,
  `shouji` varchar(111) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`yonghuID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES ('1', 'ting', 'ting', 'ting', '0', '13527774500');
INSERT INTO `yonghu` VALUES ('2', '管理员', 'ad', '123', '0', '13559438275');
INSERT INTO `yonghu` VALUES ('3', '张三', 'admin', '123456', '0', '18050171578');
INSERT INTO `yonghu` VALUES ('4', '采购人员', 'caigou', '123456', '1', '18050171577');
INSERT INTO `yonghu` VALUES ('5', '销售员', 'xiaoshou', '123456', '2', '18501715760');
INSERT INTO `yonghu` VALUES ('6', '财务', 'caiwu', '123456', '3', '18501715750');
INSERT INTO `yonghu` VALUES ('7', '仓管员', 'cangguan', '123456', '4', '18501715072');

-- ----------------------------
-- Table structure for `zhanghu`
-- ----------------------------
DROP TABLE IF EXISTS `zhanghu`;
CREATE TABLE `zhanghu` (
  `ID` int(111) NOT NULL AUTO_INCREMENT,
  `mingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `qianshu` double(111,11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of zhanghu
-- ----------------------------
INSERT INTO `zhanghu` VALUES ('1', 'aa', '196.00000000000');
INSERT INTO `zhanghu` VALUES ('2', 'aa', '1.33300000000');
INSERT INTO `zhanghu` VALUES ('3', 'aa', '12.33300000000');
INSERT INTO `zhanghu` VALUES ('4', '账户A', '9766.00000000000');
INSERT INTO `zhanghu` VALUES ('5', '账户B-A', '20020.00000000000');
