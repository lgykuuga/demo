CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `biid` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '订单编码',
  `soid` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '外部订单号',
  `shco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺编码',
  `whco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '仓库编码',
  `lpco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '物流商编码',
  `loid` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '快递单号',
  `type` int(5) DEFAULT '0' COMMENT '订单类型(1:一单一货/2:一单多货/3:大单)',
  `stat` int(5) DEFAULT '1' COMMENT '订单状态(0:取消/1:有效/2:被合并/3:被拆分)',
  `flag` int(5) DEFAULT '0' COMMENT '订单节点状态',
  `crco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人编码',
  `crna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人名称',
  `crdt` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `upco` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人编码',
  `upna` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人名称',
  `updt` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `rema` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`,`biid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='订单表';

