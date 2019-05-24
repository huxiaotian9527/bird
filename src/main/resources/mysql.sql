CREATE TABLE `t_aws_rank_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `asin` varchar(10) COMMENT '商品码ASIN',
  `rank_name` varchar(64)  COMMENT '类别名称',
  `rank_score` varchar(20)  COMMENT '类别排名',
  'grap_day' date COMMENT '爬取日期',
  'grap_hour' int(2) COMMENT '爬取小时',
  PRIMARY KEY (`id`),
  key 'k_grap'('grap_day','grap_hour')
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='亚马逊商品排名表';

