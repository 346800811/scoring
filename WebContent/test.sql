SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sc_marker`
-- ----------------------------
DROP TABLE IF EXISTS `sc_marker`;
CREATE TABLE `sc_marker` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(32) DEFAULT NULL COMMENT '指标名称',
  `weight` int(3) DEFAULT NULL COMMENT '指标权重（和为100）',
  `type` int(11) DEFAULT NULL COMMENT '指标类别',
  PRIMARY KEY (`id`),
  KEY `sc_marker_fk1` (`type`),
  CONSTRAINT `sc_marker_fk1` FOREIGN KEY (`type`) REFERENCES `sc_proj_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='指标表';

-- ----------------------------
-- Records of sc_marker
-- ----------------------------
INSERT INTO `sc_marker` VALUES ('1', '指标a', '10', '3');
INSERT INTO `sc_marker` VALUES ('2', '指标b', '20', '3');
INSERT INTO `sc_marker` VALUES ('3', '指标c', '30', '3');
INSERT INTO `sc_marker` VALUES ('4', '指标d', '40', '3');
INSERT INTO `sc_marker` VALUES ('5', '指标e', '30', '4');
INSERT INTO `sc_marker` VALUES ('6', '指标f', '40', '4');
INSERT INTO `sc_marker` VALUES ('7', '指标g', '30', '4');

-- ----------------------------
-- Table structure for `sc_proj`
-- ----------------------------
DROP TABLE IF EXISTS `sc_proj`;
CREATE TABLE `sc_proj` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `type` int(11) DEFAULT NULL COMMENT '项目类型',
  PRIMARY KEY (`id`),
  KEY `sc_proj_fk1` (`type`),
  CONSTRAINT `sc_proj_fk1` FOREIGN KEY (`type`) REFERENCES `sc_proj_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Records of sc_proj
-- ----------------------------
INSERT INTO `sc_proj` VALUES ('3', '项目a', '4');
INSERT INTO `sc_proj` VALUES ('5', '项目b', '3');
INSERT INTO `sc_proj` VALUES ('6', '项目c', '3');
INSERT INTO `sc_proj` VALUES ('7', '项目d', '4');
INSERT INTO `sc_proj` VALUES ('8', '项目e', '3');

-- ----------------------------
-- Table structure for `sc_proj_type`
-- ----------------------------
DROP TABLE IF EXISTS `sc_proj_type`;
CREATE TABLE `sc_proj_type` (
  `type` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目类别',
  `name` varchar(32) DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='项目类别表';

-- ----------------------------
-- Records of sc_proj_type
-- ----------------------------
INSERT INTO `sc_proj_type` VALUES ('3', '工程类');
INSERT INTO `sc_proj_type` VALUES ('4', '研究类');

-- ----------------------------
-- Table structure for `sc_score`
-- ----------------------------
DROP TABLE IF EXISTS `sc_score`;
CREATE TABLE `sc_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `proj_id` int(11) DEFAULT NULL COMMENT '项目id',
  `marker_id` int(11) DEFAULT NULL COMMENT '指标id',
  `user_id` int(11) DEFAULT NULL COMMENT '评分人id',
  `score` float DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`),
  KEY `sc_score_fk3` (`user_id`),
  KEY `sc_score_fk1` (`proj_id`),
  KEY `sc_score_fk2` (`marker_id`),
  CONSTRAINT `sc_score_fk2` FOREIGN KEY (`marker_id`) REFERENCES `sc_marker` (`id`),
  CONSTRAINT `sc_score_fk1` FOREIGN KEY (`proj_id`) REFERENCES `sc_proj` (`id`),
  CONSTRAINT `sc_score_fk3` FOREIGN KEY (`user_id`) REFERENCES `sc_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='分数表';

-- ----------------------------
-- Records of sc_score
-- ----------------------------
INSERT INTO `sc_score` VALUES ('1', '5', '1', '0', '80');
INSERT INTO `sc_score` VALUES ('2', '5', '2', '0', '75');
INSERT INTO `sc_score` VALUES ('3', '5', '3', '0', '70');
INSERT INTO `sc_score` VALUES ('4', '5', '4', '0', '60');
INSERT INTO `sc_score` VALUES ('5', '6', '3', '0', '70');

-- ----------------------------
-- Table structure for `sc_user`
-- ----------------------------
DROP TABLE IF EXISTS `sc_user`;
CREATE TABLE `sc_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(32) DEFAULT NULL COMMENT '专家姓名',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `passwd` varchar(36) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  KEY `sc_user_fk1` (`type`),
  CONSTRAINT `sc_user_fk1` FOREIGN KEY (`type`) REFERENCES `sc_proj_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='评分人表';

-- ----------------------------
-- Records of sc_user
-- ----------------------------
INSERT INTO `sc_user` VALUES ('0', 'admin', '3', '1');
INSERT INTO `sc_user` VALUES ('1', 'admin', '4', '2');
INSERT INTO `sc_user` VALUES ('2', 'user', '3', '1');
INSERT INTO `sc_user` VALUES ('3', 'user1', '3', '1');
INSERT INTO `sc_user` VALUES ('4', 'user2', '4', '1');


CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sc_v_score` AS select `p`.`id` AS `pid`,`m`.`id` AS `mid`,`s`.`score` AS `score`,`p`.`type` AS `type`,`s`.`user_id` AS `user_id`,`p`.`name` AS `pname`,`m`.`name` AS `mname`,`pt`.`name` AS `typename` from (((`sc_proj` `p` join `sc_marker` `m` on((`p`.`type` = `m`.`type`))) join `sc_proj_type` `pt` on((`p`.`type` = `pt`.`type`))) left join `sc_score` `s` on(((`p`.`id` = `s`.`proj_id`) and (`s`.`marker_id` = `m`.`id`)))) order by `p`.`id`,`m`.`id`