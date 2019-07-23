CREATE database if NOT EXISTS `test` default character set utf8 collate utf8_general_ci;
use `test`;

SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `demo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `value` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `crco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人编码',
  `crna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人名称',
  `crdt` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `upco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人编码',
  `upna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人名称',
  `updt` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
