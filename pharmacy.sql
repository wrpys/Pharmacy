/*
Navicat MySQL Data Transfer

Source Server         : loc
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : pharmacy

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-10 19:55:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `caigoudingdang`
-- ----------------------------
DROP TABLE IF EXISTS `caigoudingdang`;
CREATE TABLE `caigoudingdang` (
  `caigoudingdangID` int(111) NOT NULL,
  `yaopingID` int(111) NOT NULL,
  `yaopingMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `yaopingDanwei` varchar(111) COLLATE utf8_bin NOT NULL,
  `shuliang` int(111) NOT NULL,
  `zongjia` double(111,11) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `gongyingshangID` int(111) NOT NULL,
  `cangkuID` int(111) NOT NULL,
  `complete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`caigoudingdangID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of caigoudingdang
-- ----------------------------
INSERT INTO `caigoudingdang` VALUES ('1', '1', 'ypmz1', '1', '1', '111.12000000000', '2018-03-30', '1', '1', '1');
INSERT INTO `caigoudingdang` VALUES ('2', '1', '1', '2', '1', '1.00000000000', '2018-03-31', '1', '1', '0');
INSERT INTO `caigoudingdang` VALUES ('4', '1', 'ypmz', 'dw', '11', '88.00000000000', '2018-04-02', '1', '1', '0');
INSERT INTO `caigoudingdang` VALUES ('5', '1', 'ypmz', 'dw', '12', '24.00000000000', '2018-04-05', '1', '1', '0');

-- ----------------------------
-- Table structure for `caigoufahuo`
-- ----------------------------
DROP TABLE IF EXISTS `caigoufahuo`;
CREATE TABLE `caigoufahuo` (
  `caigoufahuoID` int(111) NOT NULL AUTO_INCREMENT,
  `yaopingID` int(111) NOT NULL,
  `yaopingMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `yaopingDanwei` varchar(111) COLLATE utf8_bin NOT NULL,
  `shuliang` int(111) NOT NULL,
  `zongjia` double(111,11) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `gongyingshangID` int(111) NOT NULL,
  `caigoudingdangID` int(111) NOT NULL,
  `complete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`caigoufahuoID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of caigoufahuo
-- ----------------------------
INSERT INTO `caigoufahuo` VALUES ('2', '1', '1', '1', '111', '111.00000000000', '2016-03-09', '1', '1', '0');
INSERT INTO `caigoufahuo` VALUES ('3', '1', 'yp1', 'dw', '1', '11.00000000000', '2018-04-06', '1', '1', '0');

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
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerID` int(111) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(111) COLLATE utf8_bin NOT NULL,
  `customerPhone` varchar(111) COLLATE utf8_bin NOT NULL,
  `customerQQ` varchar(111) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('6', '2', '2', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dingdan
-- ----------------------------
INSERT INTO `dingdan` VALUES ('1', '1001', '10', '0.90000000000', '10', '9.00000000000', '1', '2018-04-10 18:36:50', '2', null, '1', '0');

-- ----------------------------
-- Table structure for `fukuandan`
-- ----------------------------
DROP TABLE IF EXISTS `fukuandan`;
CREATE TABLE `fukuandan` (
  `fukuandanID` int(111) NOT NULL AUTO_INCREMENT,
  `gongyingshangID` int(111) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `caigoufahuoID` int(111) NOT NULL,
  `caigoudingdangID` int(111) NOT NULL,
  `qianshu` double(111,11) NOT NULL,
  `beizhi` varchar(111) COLLATE utf8_bin NOT NULL,
  `zhuangtai` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`fukuandanID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of fukuandan
-- ----------------------------
INSERT INTO `fukuandan` VALUES ('1', '1', '2015-06-16', '0', '1', '11111.00000000000', '1111111', '1');
INSERT INTO `fukuandan` VALUES ('2', '1', '2016-08-08', '0', '1', '1.00000000000', '1', '1');
INSERT INTO `fukuandan` VALUES ('4', '1', '2017-08-08', '0', '1', '10.00000000000', '1', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

-- ----------------------------
-- Table structure for `rukuandan`
-- ----------------------------
DROP TABLE IF EXISTS `rukuandan`;
CREATE TABLE `rukuandan` (
  `rukuandanID` int(111) NOT NULL AUTO_INCREMENT,
  `kehuID` int(111) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `xiaoshoudingdangID` int(111) NOT NULL,
  `qianshu` double(111,11) NOT NULL,
  `beizhi` varchar(111) COLLATE utf8_bin NOT NULL,
  `zhuantai` int(11) NOT NULL DEFAULT '0',
  `xiaoshoufahuoID` int(111) NOT NULL,
  PRIMARY KEY (`rukuandanID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of rukuandan
-- ----------------------------
INSERT INTO `rukuandan` VALUES ('1', '1', '2015-06-18', '1', '111.00000000000', '1', '1', '0');
INSERT INTO `rukuandan` VALUES ('3', '1', '2018-03-31', '1', '1.00000000000', '1', '0', '0');
INSERT INTO `rukuandan` VALUES ('5', '1', '2018-09-09', '1', '10.00000000000', '00', '0', '0');

-- ----------------------------
-- Table structure for `warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `warehouseID` int(111) NOT NULL,
  `warehouseName` varchar(111) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`warehouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for `warehouseset`
-- ----------------------------
DROP TABLE IF EXISTS `warehouseset`;
CREATE TABLE `warehouseset` (
  `id` int(111) NOT NULL,
  `warehouseID` int(111) NOT NULL,
  `drugsID` int(111) NOT NULL,
  `effectiveTime` int(111) NOT NULL,
  `minNumber` int(111) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of warehouseset
-- ----------------------------
INSERT INTO `warehouseset` VALUES ('1', '1', '1', '1', '4');
INSERT INTO `warehouseset` VALUES ('2', '1', '2', '1', '4');

-- ----------------------------
-- Table structure for `xiaoshoudingdang`
-- ----------------------------
DROP TABLE IF EXISTS `xiaoshoudingdang`;
CREATE TABLE `xiaoshoudingdang` (
  `xiaoshoudingdangID` int(111) NOT NULL,
  `yaopingID` int(111) NOT NULL,
  `yaopingMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `yaopingDanwei` varchar(111) COLLATE utf8_bin NOT NULL,
  `shuliang` int(111) NOT NULL,
  `jingjia` double(111,11) NOT NULL,
  `zongjia` double(111,11) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `cangkuID` int(111) NOT NULL,
  `kehuID` int(111) NOT NULL,
  `complete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`xiaoshoudingdangID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of xiaoshoudingdang
-- ----------------------------
INSERT INTO `xiaoshoudingdang` VALUES ('0', '0', 'null', 'null', '0', '0.00000000000', '0.00000000000', '2018-06-06', '1', '1', '0');
INSERT INTO `xiaoshoudingdang` VALUES ('1', '1', '1', '1', '1111', '11.00000000000', '1.00000000000', '2018-03-31', '1', '1', '0');
INSERT INTO `xiaoshoudingdang` VALUES ('2', '1', '1', '1', '11', '11.00000000000', '11.00000000000', '2018-03-31', '1', '1', '0');
INSERT INTO `xiaoshoudingdang` VALUES ('3', '1', 'yp1', '11', '11', '22.00000000000', '22.00000000000', '2018-04-06', '1', '1', '0');
INSERT INTO `xiaoshoudingdang` VALUES ('8', '1', 'y11', 'dw11', '11', '0.00000000000', '2.00000000000', '2018-08-08', '1', '1', '0');

-- ----------------------------
-- Table structure for `xiaoshoufahuo`
-- ----------------------------
DROP TABLE IF EXISTS `xiaoshoufahuo`;
CREATE TABLE `xiaoshoufahuo` (
  `xiaoshoufahuoID` int(111) NOT NULL AUTO_INCREMENT,
  `yaopingID` int(111) NOT NULL,
  `yaopingMingzi` varchar(111) COLLATE utf8_bin NOT NULL,
  `yaopingDanwei` varchar(111) COLLATE utf8_bin NOT NULL,
  `shuliang` int(111) NOT NULL,
  `zongjia` double(111,11) NOT NULL,
  `riqi` varchar(111) COLLATE utf8_bin NOT NULL,
  `gongyingshangID` int(111) NOT NULL,
  `kehuID` int(111) NOT NULL,
  `xiaoshoudingdangID` int(111) NOT NULL,
  `complete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`xiaoshoufahuoID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of xiaoshoufahuo
-- ----------------------------
INSERT INTO `xiaoshoufahuo` VALUES ('1', '1', 'y1', 'dw1', '1', '10086.00000000000', '2015-03-20', '1', '1', '1', '0');
INSERT INTO `xiaoshoufahuo` VALUES ('2', '1', 'y1', 'dw1', '1', '1.00000000000', '2018-04-06', '1', '1', '1', '0');
INSERT INTO `xiaoshoufahuo` VALUES ('3', '1', 'Y1', 'DW', '1', '1.00000000000', '2019-08-09', '1', '1', '6', '0');
INSERT INTO `xiaoshoufahuo` VALUES ('5', '1', '1', '1', '1', '1.00000000000', '2018-09-01', '1', '1', '1', '0');

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
INSERT INTO `yaoping` VALUES ('7', '0', 'ceshi1', '1', '11', '10.00000000000', 'b1', '0');
INSERT INTO `yaoping` VALUES ('8', '0', 'ceshi2', '1', '1', '1.00000000000', 'b1', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of zhanghu
-- ----------------------------
INSERT INTO `zhanghu` VALUES ('1', 'aa', '40.00000000000');
INSERT INTO `zhanghu` VALUES ('2', 'aa', '1.33300000000');
INSERT INTO `zhanghu` VALUES ('3', 'aa', '12.33300000000');
