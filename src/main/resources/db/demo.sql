

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `gco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '编码',
    `gna` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
    `crco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人编码',
    `crna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人名称',
    `crdt` bigint(20) DEFAULT NULL COMMENT '创建时间',
    `upco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人编码',
    `upna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人名称',
    `updt` bigint(20) DEFAULT NULL COMMENT '修改时间',
    `rema` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='demo';


