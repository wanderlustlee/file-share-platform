/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : fileSharePlatform

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/03/2020 16:30:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for choiceQuestion
-- ----------------------------
DROP TABLE IF EXISTS `choiceQuestion`;
CREATE TABLE `choiceQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `description` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `optionA` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `optionB` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `optionC` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `optionD` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `answer` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `point` int(255) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDelete` tinyint(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of choiceQuestion
-- ----------------------------
BEGIN;
INSERT INTO `choiceQuestion` VALUES (1, 2, 'test', 'a', 'b', 'c', 'd', 'a', 5, '2020-03-24 20:00:35', '2020-03-24 20:00:39', 0);
INSERT INTO `choiceQuestion` VALUES (2, 2, '1', '1', '1', '1', '1', 'D', 4, '2020-03-25 16:00:42', '2020-03-25 16:00:42', 0);
INSERT INTO `choiceQuestion` VALUES (3, 2, '说的风格受到', '1', '1', '1', '1', 'A', 5, '2020-03-26 04:14:47', '2020-03-26 17:14:46', 0);
INSERT INTO `choiceQuestion` VALUES (4, 2, '恶搞虽然他和人挺好', '1', '1', '1', '1', 'B', 1, '2020-03-26 04:14:55', '2020-03-26 17:14:55', 0);
INSERT INTO `choiceQuestion` VALUES (5, 2, '说的风格受到过', '23', '123', '1', '1', 'B', 13, '2020-03-26 04:15:05', '2020-03-26 17:15:04', 0);
INSERT INTO `choiceQuestion` VALUES (6, 2, '额外人去玩儿去', '1', '1', '1', '1', 'B', 6, '2020-03-26 04:15:14', '2020-03-26 17:15:14', 0);
INSERT INTO `choiceQuestion` VALUES (7, 2, '热河热好热', '温柔', '3', '234', '发', 'B', 5, '2020-03-26 04:15:38', '2020-03-26 17:15:38', 0);
INSERT INTO `choiceQuestion` VALUES (8, 2, '呃呃哥哥', '呃', '呃', '2', '4', 'C', 4, '2020-03-26 04:15:49', '2020-03-26 17:15:48', 0);
INSERT INTO `choiceQuestion` VALUES (9, 2, '1234123阿斯顿发', '人', '1', '2', '3', 'B', 4, '2020-03-26 04:15:59', '2020-03-26 17:15:59', 0);
INSERT INTO `choiceQuestion` VALUES (10, 2, '234123 ', '沙发上', '23', '4', '5', 'B', 5, '2020-03-26 04:16:08', '2020-03-26 17:16:08', 0);
INSERT INTO `choiceQuestion` VALUES (11, 2, '23423', '反而分', '34', '2', '24', 'A', 4, '2020-03-26 04:16:17', '2020-03-26 17:16:16', 0);
INSERT INTO `choiceQuestion` VALUES (12, 2, '的风格受到', '23', '23', '4', '54', 'B', 4, '2020-03-26 04:16:26', '2020-03-26 17:16:25', 0);
INSERT INTO `choiceQuestion` VALUES (13, 2, '说的风格', '23', '4', '4', '5', 'B', 2, '2020-03-26 04:16:35', '2020-03-26 17:16:34', 0);
COMMIT;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `operateType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fileName` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `filePath` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of file
-- ----------------------------
BEGIN;
INSERT INTO `file` VALUES (3, 2, '', '攻略2 (1).png', '/Users/vivo/upload/攻略2 (1).png', '2020-03-16 03:51:27', '2020-03-16 16:51:26');
INSERT INTO `file` VALUES (4, 2, '', '攻略2 (1).png', '/Users/vivo/upload/攻略2 (1).png', '2020-03-16 03:56:45', '2020-03-16 16:56:45');
INSERT INTO `file` VALUES (5, 2, '', '攻略 (4) (1).png', '/Users/vivo/upload/攻略 (4) (1).png', '2020-03-16 04:07:43', '2020-03-16 17:07:42');
INSERT INTO `file` VALUES (6, 2, '', '未标题-6.jpg', '/Users/vivo/upload/未标题-6.jpg', '2020-03-16 04:07:58', '2020-03-16 17:07:58');
INSERT INTO `file` VALUES (7, 2, '', '攻略2 (1).png', '/Users/vivo/upload/攻略2 (1).png', '2020-03-16 04:09:55', '2020-03-16 17:09:54');
INSERT INTO `file` VALUES (8, 2, '', '攻略2 (1).png', '/Users/vivo/upload/攻略2 (1).png', '2020-03-16 04:10:01', '2020-03-16 17:10:01');
INSERT INTO `file` VALUES (9, 2, '', 'backFn.js', '/Users/vivo/uploadbackFn.js', '2020-03-16 21:02:39', '2020-03-17 10:02:39');
INSERT INTO `file` VALUES (10, 2, 'upload', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-19 08:24:21', '2020-03-19 21:24:20');
INSERT INTO `file` VALUES (11, 2, 'download', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-19 08:26:12', '2020-03-19 21:26:12');
INSERT INTO `file` VALUES (12, 2, 'upload', 'legs4___.png', '/Users/vivo/uploadlegs4___.png', '2020-03-19 21:11:13', '2020-03-20 10:11:13');
INSERT INTO `file` VALUES (13, 2, 'download', 'legs4___.png', '/Users/vivo/uploadlegs4___.png', '2020-03-19 21:18:46', '2020-03-20 10:18:46');
INSERT INTO `file` VALUES (14, 2, 'upload', '养成活动攻略-2.19.docx', '/Users/vivo/upload养成活动攻略-2.19.docx', '2020-03-19 21:30:35', '2020-03-20 10:30:35');
INSERT INTO `file` VALUES (15, 2, 'upload', '心愿星排期0320.pdf', '/Users/vivo/upload心愿星排期0320.pdf', '2020-03-20 02:31:47', '2020-03-20 15:31:47');
INSERT INTO `file` VALUES (16, 2, 'upload', '心愿星排期0320.pdf', '/Users/vivo/upload心愿星排期0320.pdf', '2020-03-20 02:32:18', '2020-03-20 15:32:17');
INSERT INTO `file` VALUES (17, 2, 'upload', '心愿星排期0320.pdf', '/Users/vivo/upload心愿星排期0320.pdf', '2020-03-20 02:32:22', '2020-03-20 15:32:22');
INSERT INTO `file` VALUES (18, 2, 'download', '123', '/Users/vivo/upload123', '2020-03-22 21:24:49', '2020-03-23 10:24:48');
INSERT INTO `file` VALUES (19, 2, 'download', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-22 21:25:58', '2020-03-23 10:25:57');
INSERT INTO `file` VALUES (20, 2, 'download', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-22 21:27:05', '2020-03-23 10:27:05');
INSERT INTO `file` VALUES (21, 2, 'download', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-22 21:34:17', '2020-03-23 10:34:16');
INSERT INTO `file` VALUES (22, 2, 'upload', '公益素材对接文档.docx', '/Users/vivo/upload公益素材对接文档.docx', '2020-03-22 22:37:45', '2020-03-23 11:37:45');
INSERT INTO `file` VALUES (23, 2, 'upload', '公益素材对接文档.docx', '/Users/vivo/upload公益素材对接文档.docx', '2020-03-22 22:38:07', '2020-03-23 11:38:06');
INSERT INTO `file` VALUES (24, 2, 'upload', '攻略2 (1).png', '/Users/vivo/upload攻略2 (1).png', '2020-03-24 02:47:20', '2020-03-24 15:47:19');
INSERT INTO `file` VALUES (25, 2, 'upload', '攻略2 (1).png', '/Users/vivo/upload攻略2 (1).png', '2020-03-24 02:47:24', '2020-03-24 15:47:23');
INSERT INTO `file` VALUES (26, 2, 'upload', '未标题-6 (1) (1).jpg', '/Users/vivo/upload未标题-6 (1) (1).jpg', '2020-03-24 02:47:37', '2020-03-24 15:47:36');
INSERT INTO `file` VALUES (27, 2, 'upload', '未标题-6 (1) (1).jpg', '/Users/vivo/upload未标题-6 (1) (1).jpg', '2020-03-24 02:47:39', '2020-03-24 15:47:39');
INSERT INTO `file` VALUES (28, 2, 'upload', 'preview.zip', '/Users/vivo/uploadpreview.zip', '2020-03-24 02:47:51', '2020-03-24 15:47:50');
INSERT INTO `file` VALUES (29, 2, 'upload', 'preview.zip', '/Users/vivo/uploadpreview.zip', '2020-03-24 02:47:55', '2020-03-24 15:47:54');
INSERT INTO `file` VALUES (30, 2, 'upload', '标注(1).zip', '/Users/vivo/upload标注(1).zip', '2020-03-24 22:12:10', '2020-03-25 11:12:10');
INSERT INTO `file` VALUES (31, 2, 'upload', '标注(1).zip', '/Users/vivo/upload标注(1).zip', '2020-03-24 22:12:34', '2020-03-25 11:12:33');
INSERT INTO `file` VALUES (32, 2, 'download', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-26 20:50:33', '2020-03-27 09:50:32');
INSERT INTO `file` VALUES (33, 2, 'download', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-26 20:51:36', '2020-03-27 09:51:35');
INSERT INTO `file` VALUES (34, 2, 'download', '【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '/Users/vivo/upload【悟空系统-浏览器心愿星养成活动-埋点设计-王越-20200303.xlsx', '2020-03-26 21:07:06', '2020-03-27 10:07:05');
INSERT INTO `file` VALUES (35, 2, 'upload', '试题-2020-03-27-10:42:01.doc', '/Users/vivo/upload试题-2020-03-27-10:42:01.doc', '2020-03-26 22:28:52', '2020-03-27 11:28:52');
INSERT INTO `file` VALUES (36, 2, 'upload', '试题-2020-03-27-10:42:01.doc', '/Users/vivo/upload试题-2020-03-27-10:42:01.doc', '2020-03-26 22:28:55', '2020-03-27 11:28:54');
INSERT INTO `file` VALUES (37, 2, 'upload', '答案-2020-03-26-20:12:51.docx', '/Users/vivo/upload答案-2020-03-26-20:12:51.docx', '2020-03-26 22:29:45', '2020-03-27 11:29:44');
INSERT INTO `file` VALUES (38, 2, 'upload', '答案-2020-03-26-20:12:51.docx', '/Users/vivo/upload答案-2020-03-26-20:12:51.docx', '2020-03-26 22:29:46', '2020-03-27 11:29:46');
INSERT INTO `file` VALUES (39, 2, 'download', '答案-2020-03-26-20:12:51.docx', '/Users/vivo/upload答案-2020-03-26-20:12:51.docx', '2020-03-26 22:30:16', '2020-03-27 11:30:15');
INSERT INTO `file` VALUES (40, 2, 'upload', '答案123.docx', '/Users/vivo/upload答案123.docx', '2020-03-26 22:33:15', '2020-03-27 11:33:15');
INSERT INTO `file` VALUES (41, 2, 'upload', '答案123.docx', '/Users/vivo/upload答案123.docx', '2020-03-26 22:33:17', '2020-03-27 11:33:16');
INSERT INTO `file` VALUES (42, 2, 'upload', '试题-2020-03-26-19-58-51.doc', '/Users/vivo/upload试题-2020-03-26-19-58-51.doc', '2020-03-26 22:36:08', '2020-03-27 11:36:07');
INSERT INTO `file` VALUES (43, 2, 'upload', '试题-2020-03-26-19-58-51.doc', '/Users/vivo/upload试题-2020-03-26-19-58-51.doc', '2020-03-26 22:36:10', '2020-03-27 11:36:09');
INSERT INTO `file` VALUES (44, 2, 'upload', '试题-2020-03-27-11:55:04.doc', '/Users/vivo/upload试题-2020-03-27-11:55:04.doc', '2020-03-27 01:14:32', '2020-03-27 14:14:32');
INSERT INTO `file` VALUES (45, 2, 'upload', '试题-2020-03-27-11:55:04.doc', '/Users/vivo/upload试题-2020-03-27-11:55:04.doc', '2020-03-27 01:15:58', '2020-03-27 14:15:58');
INSERT INTO `file` VALUES (46, 2, 'upload', '试题-2020-03-27-11:55:04.doc', '/Users/vivo/upload试题-2020-03-27-11:55:04.doc', '2020-03-27 01:16:45', '2020-03-27 14:16:44');
INSERT INTO `file` VALUES (47, 2, 'upload', '试题-2020-03-27-11:55:04.doc', '/Users/vivo/upload试题-2020-03-27-11:55:04.doc', '2020-03-27 01:16:46', '2020-03-27 14:16:46');
INSERT INTO `file` VALUES (48, 2, 'upload', '试题-2020-03-27-11:55:04.doc', '/Users/vivo/upload试题-2020-03-27-11:55:04.doc', '2020-03-27 01:17:15', '2020-03-27 14:17:15');
INSERT INTO `file` VALUES (49, 2, 'upload', '试题-2020-03-27-11:55:04.doc', '/Users/vivo/upload试题-2020-03-27-11:55:04.doc', '2020-03-27 01:17:16', '2020-03-27 14:17:16');
INSERT INTO `file` VALUES (50, 2, 'upload', '试题-2020-03-27-11-56-02.doc', '/Users/vivo/upload试题-2020-03-27-11-56-02.doc', '2020-03-27 01:17:58', '2020-03-27 14:17:58');
INSERT INTO `file` VALUES (51, 2, 'upload', '答案-2020-03-27-11-56-02.doc', '/Users/vivo/upload答案-2020-03-27-11-56-02.doc', '2020-03-27 01:18:18', '2020-03-27 14:18:17');
INSERT INTO `file` VALUES (52, 2, 'upload', '试题-2020-03-27-11-56-02.doc', '/Users/vivo/upload试题-2020-03-27-11-56-02.doc', '2020-03-27 01:27:49', '2020-03-27 14:27:49');
INSERT INTO `file` VALUES (53, 2, 'upload', '试题-2020-03-27-11-56-02.doc', '/Users/vivo/upload试题-2020-03-27-11-56-02.doc', '2020-03-27 01:28:09', '2020-03-27 14:28:08');
INSERT INTO `file` VALUES (54, 2, 'upload', '答案-2020-03-27-11-56-02.doc', '/Users/vivo/upload答案-2020-03-27-11-56-02.doc', '2020-03-27 01:28:37', '2020-03-27 14:28:37');
INSERT INTO `file` VALUES (55, 2, 'upload', '试题-2020-03-27-11:55:04.doc', '/Users/vivo/upload试题-2020-03-27-11:55:04.doc', '2020-03-27 01:31:41', '2020-03-27 14:31:40');
COMMIT;

-- ----------------------------
-- Table structure for paperAnswer
-- ----------------------------
DROP TABLE IF EXISTS `paperAnswer`;
CREATE TABLE `paperAnswer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `paperName` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `paperPath` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of paperAnswer
-- ----------------------------
BEGIN;
INSERT INTO `paperAnswer` VALUES (1, 2, '答案-2020-03-27-11-56-02.doc', '/Users/vivo/paper/答案-2020-03-27-11-56-02.doc', '2020-03-27 11:56:02', '2020-03-27 11:56:02');
COMMIT;

-- ----------------------------
-- Table structure for paperQuestion
-- ----------------------------
DROP TABLE IF EXISTS `paperQuestion`;
CREATE TABLE `paperQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `paperName` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `paperPath` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of paperQuestion
-- ----------------------------
BEGIN;
INSERT INTO `paperQuestion` VALUES (1, 2, '试题-2020-03-27-11-56-02.doc', '/Users/vivo/paper/试题-2020-03-27-11-56-02.doc', '2020-03-27 11:56:02', '2020-03-27 11:56:02');
COMMIT;

-- ----------------------------
-- Table structure for shortAnswerQuestion
-- ----------------------------
DROP TABLE IF EXISTS `shortAnswerQuestion`;
CREATE TABLE `shortAnswerQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `description` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL,
  `point` int(255) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDelete` tinyint(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of shortAnswerQuestion
-- ----------------------------
BEGIN;
INSERT INTO `shortAnswerQuestion` VALUES (1, 2, '你怎么了', 15, '2020-03-25 17:20:33', '2020-03-25 17:11:45', 0);
INSERT INTO `shortAnswerQuestion` VALUES (2, 2, '阿斯顿', 1, '2020-03-26 04:13:20', '2020-03-26 17:13:20', 0);
INSERT INTO `shortAnswerQuestion` VALUES (3, 2, '隋东风', 1, '2020-03-26 04:13:27', '2020-03-26 17:13:26', 0);
INSERT INTO `shortAnswerQuestion` VALUES (4, 2, '人挺好', 1, '2020-03-26 04:13:32', '2020-03-26 17:13:32', 0);
INSERT INTO `shortAnswerQuestion` VALUES (5, 2, '哪个好', 1, '2020-03-26 04:13:37', '2020-03-26 17:13:36', 0);
INSERT INTO `shortAnswerQuestion` VALUES (6, 2, '前二天', 1, '2020-03-26 04:13:40', '2020-03-26 17:13:39', 0);
INSERT INTO `shortAnswerQuestion` VALUES (7, 2, '更符合美国返回韩国', 1, '2020-03-26 04:13:43', '2020-03-26 17:13:42', 0);
INSERT INTO `shortAnswerQuestion` VALUES (8, 2, '泣鬼神的风格爱上', 1, '2020-03-26 04:13:46', '2020-03-26 17:13:46', 0);
INSERT INTO `shortAnswerQuestion` VALUES (9, 2, '我二哥说的风格 ', 1, '2020-03-26 04:13:49', '2020-03-26 17:13:49', 0);
INSERT INTO `shortAnswerQuestion` VALUES (10, 2, '是否更好', 1, '2020-03-26 04:13:53', '2020-03-26 17:13:52', 0);
INSERT INTO `shortAnswerQuestion` VALUES (11, 2, '说的风格的时光', 10, '2020-03-26 04:14:00', '2020-03-26 17:14:00', 0);
INSERT INTO `shortAnswerQuestion` VALUES (12, 2, '去玩儿去玩儿', 10, '2020-03-26 04:14:03', '2020-03-26 17:14:03', 0);
INSERT INTO `shortAnswerQuestion` VALUES (13, 2, '企鹅太年轻', 10, '2020-03-26 04:14:07', '2020-03-26 17:14:06', 0);
INSERT INTO `shortAnswerQuestion` VALUES (14, 2, '去玩儿前往法国帅哥', 10, '2020-03-26 04:14:10', '2020-03-26 17:14:09', 0);
INSERT INTO `shortAnswerQuestion` VALUES (15, 2, '前二哥我二哥', 10, '2020-03-26 04:14:13', '2020-03-26 17:14:12', 0);
INSERT INTO `shortAnswerQuestion` VALUES (16, 2, '风格受到法国帅哥', 10, '2020-03-26 04:14:16', '2020-03-26 17:14:16', 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `creatTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', '123', '2020-03-10 10:48:55', '2020-03-10 10:48:55');
INSERT INTO `user` VALUES (2, '1234', '1234', '2020-03-10 14:53:48', '2020-03-10 14:53:48');
INSERT INTO `user` VALUES (3, 'aaaa', 'aaa', '2020-03-14 14:31:53', '2020-03-14 14:31:53');
INSERT INTO `user` VALUES (4, 'aaabbb', 'aaabb', '2020-03-14 14:34:52', '2020-03-14 14:34:52');
INSERT INTO `user` VALUES (5, 'admin123', '123', '2020-03-23 19:35:51', '2020-03-23 19:35:51');
INSERT INTO `user` VALUES (7, 'admin1234', '123', '2020-03-23 19:39:49', '2020-03-23 19:39:49');
INSERT INTO `user` VALUES (8, 'adminwwerw', '123', '2020-03-23 19:41:14', '2020-03-23 19:41:14');
INSERT INTO `user` VALUES (9, 'admin123asd', '123', '2020-03-23 19:43:22', '2020-03-23 19:43:22');
INSERT INTO `user` VALUES (10, 'adminasdfda', '123', '2020-03-23 19:43:45', '2020-03-23 19:43:45');
COMMIT;

-- ----------------------------
-- Table structure for userLoad
-- ----------------------------
DROP TABLE IF EXISTS `userLoad`;
CREATE TABLE `userLoad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `uploadTimes` int(11) NOT NULL DEFAULT '0',
  `downloadTimes` int(11) NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of userLoad
-- ----------------------------
BEGIN;
INSERT INTO `userLoad` VALUES (1, 2, 36, 11, '2020-03-19 08:24:21', '2020-03-19 21:24:20');
COMMIT;

-- ----------------------------
-- Table structure for userToken
-- ----------------------------
DROP TABLE IF EXISTS `userToken`;
CREATE TABLE `userToken` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of userToken
-- ----------------------------
BEGIN;
INSERT INTO `userToken` VALUES (1, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-16 15:39:42', '2020-03-16 15:39:42');
INSERT INTO `userToken` VALUES (2, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-16 15:39:42', '2020-03-16 15:39:42');
INSERT INTO `userToken` VALUES (3, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-18 17:47:06', '2020-03-18 17:47:06');
INSERT INTO `userToken` VALUES (4, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-18 04:51:17', '2020-03-18 17:51:16');
INSERT INTO `userToken` VALUES (5, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-18 04:51:51', '2020-03-18 17:51:50');
INSERT INTO `userToken` VALUES (6, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-18 04:52:34', '2020-03-18 17:52:33');
INSERT INTO `userToken` VALUES (7, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-18 05:00:08', '2020-03-18 18:00:08');
INSERT INTO `userToken` VALUES (8, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-22 21:08:37', '2020-03-23 10:08:36');
INSERT INTO `userToken` VALUES (9, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-22 21:09:03', '2020-03-23 10:09:02');
INSERT INTO `userToken` VALUES (10, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 04:20:36', '2020-03-23 17:20:36');
INSERT INTO `userToken` VALUES (11, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 04:21:00', '2020-03-23 17:20:59');
INSERT INTO `userToken` VALUES (12, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 04:21:24', '2020-03-23 17:21:23');
INSERT INTO `userToken` VALUES (13, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 04:22:15', '2020-03-23 17:22:14');
INSERT INTO `userToken` VALUES (14, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 04:24:55', '2020-03-23 17:24:54');
INSERT INTO `userToken` VALUES (15, 5, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1In0.0Ccyb6wVDe0fMb-gzZdzaYHRkJ2AymRHLBIeUXNwBO0', '2020-03-23 06:35:51', '2020-03-23 19:35:51');
INSERT INTO `userToken` VALUES (16, 5, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1In0.0Ccyb6wVDe0fMb-gzZdzaYHRkJ2AymRHLBIeUXNwBO0', '2020-03-23 06:35:51', '2020-03-23 19:35:51');
INSERT INTO `userToken` VALUES (17, 6, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2In0.9uCK9Lca0gQVXTiBpkwJqqOb5Gm_u57pmWvcGISPnAI', '2020-03-23 06:39:34', '2020-03-23 19:39:33');
INSERT INTO `userToken` VALUES (18, 7, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3In0.EoRIBCe5Gi2Dwi2H7gJwh-tMg5xI2yhV8qgTeTMYDnY', '2020-03-23 06:39:49', '2020-03-23 19:39:49');
INSERT INTO `userToken` VALUES (19, 7, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3In0.EoRIBCe5Gi2Dwi2H7gJwh-tMg5xI2yhV8qgTeTMYDnY', '2020-03-23 06:39:49', '2020-03-23 19:39:49');
INSERT INTO `userToken` VALUES (20, 8, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4In0.Ib7dnTHONMmWtVjUtJ2cFc8fH8MRY6cbMekGIQ6aUQ8', '2020-03-23 06:41:15', '2020-03-23 19:41:14');
INSERT INTO `userToken` VALUES (21, 8, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4In0.Ib7dnTHONMmWtVjUtJ2cFc8fH8MRY6cbMekGIQ6aUQ8', '2020-03-23 06:41:15', '2020-03-23 19:41:14');
INSERT INTO `userToken` VALUES (22, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 06:41:44', '2020-03-23 19:41:43');
INSERT INTO `userToken` VALUES (23, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 06:41:56', '2020-03-23 19:41:56');
INSERT INTO `userToken` VALUES (24, 1, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.ihOZFzg3ZGIbBMneRy-4RMqors1P3nuO-wRJnQtTzWQ', '2020-03-23 06:42:53', '2020-03-23 19:42:52');
INSERT INTO `userToken` VALUES (25, 9, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5In0.q1cgh5KbmETT4DauDlm_bngoxoOjLB1Qo1PpnpvVfAM', '2020-03-23 06:43:23', '2020-03-23 19:43:22');
INSERT INTO `userToken` VALUES (26, 9, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5In0.q1cgh5KbmETT4DauDlm_bngoxoOjLB1Qo1PpnpvVfAM', '2020-03-23 06:43:23', '2020-03-23 19:43:22');
INSERT INTO `userToken` VALUES (27, 10, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMCJ9.qMpFFNclLAqZ4jGCfsoF5RbpO5orIJ9UIUd6QDPiCnQ', '2020-03-23 06:43:45', '2020-03-23 19:43:45');
INSERT INTO `userToken` VALUES (28, 10, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMCJ9.qMpFFNclLAqZ4jGCfsoF5RbpO5orIJ9UIUd6QDPiCnQ', '2020-03-23 06:43:45', '2020-03-23 19:43:45');
INSERT INTO `userToken` VALUES (29, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-24 02:58:38', '2020-03-24 15:58:37');
INSERT INTO `userToken` VALUES (30, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-27 03:23:58', '2020-03-27 16:23:58');
INSERT INTO `userToken` VALUES (31, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-27 03:25:04', '2020-03-27 16:25:03');
INSERT INTO `userToken` VALUES (32, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-27 03:25:53', '2020-03-27 16:25:53');
INSERT INTO `userToken` VALUES (33, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-27 03:26:44', '2020-03-27 16:26:43');
INSERT INTO `userToken` VALUES (34, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-27 03:27:35', '2020-03-27 16:27:34');
INSERT INTO `userToken` VALUES (35, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-27 03:28:31', '2020-03-27 16:28:30');
INSERT INTO `userToken` VALUES (36, 2, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyIn0.oHDiid0d18zZu97HIJOrsnNVPIsSzfbuVIX8imy0Y80', '2020-03-27 03:29:30', '2020-03-27 16:29:29');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
