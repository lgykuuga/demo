SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `stud`;
CREATE TABLE `stud` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `gco` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '学生编码',
    `gna` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '学生名称',
    `age` int(5) DEFAULT NULL COMMENT '年龄',
    `mail` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
    `pgco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '上级学号',
    `crco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人编码',
    `crna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人名称',
    `crdt` bigint(20) DEFAULT NULL COMMENT '创建时间',
    `upco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人编码',
    `upna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人名称',
    `updt` bigint(20) DEFAULT NULL COMMENT '修改时间',
    `rema` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`,`gco`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学生表';


