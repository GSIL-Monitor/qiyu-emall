CREATE DATABASE qiyu_emall;
use qiyu_emall;

drop table if exists qy_printer_device;
drop table if exists qy_printer_info;
drop table if exists qy_merchant;
drop table if exists qy_merchant_user;
drop table if exists qy_store;
drop table if exists qy_product;
drop table if exists qy_product_category;
drop table if exists qy_product_specification;
drop table if exists qy_product_spec_stock;
drop table if exists qy_product_picture;
drop table if exists qy_order;
drop table if exists qy_order_logs;
drop table if exists qy_order_product;
drop table if exists qy_order_logistics;
drop table if exists qy_user;
drop table if exists qy_user_address;
drop table if EXISTS qy_area;
drop table if EXISTS qy_banner;


-- banner数据表
CREATE TABLE `qy_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` tinyint(4) DEFAULT 0 COMMENT '类型标记 1商品,2文章',
  `name` varchar(30) DEFAULT '' COMMENT '名称',
  `picture` varchar(100) DEFAULT '' COMMENT '图片',
  `url` varchar(100) DEFAULT '' COMMENT 'banner链接url',
  `status` tinyint(4) DEFAULT 0 COMMENT '0 显示 1隐藏 2删除',
  `sort` int(11) DEFAULT 0 COMMENT '排序,值越小越靠前',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='banner管理';


-- 地址信息基础表
CREATE TABLE `qy_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) DEFAULT 0 COMMENT '父级id 0为顶级',
  `name` varchar(50) DEFAULT '' COMMENT '名称',
  `pinyin` varchar(50) DEFAULT '' COMMENT '拼音',
  `level` tinyint(4) DEFAULT 1 COMMENT '0:全国,1:省,2:市,3:区/县',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址信息表';


CREATE TABLE `qy_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pay_no` varchar(50) DEFAULT '' COMMENT '支付流水号',
  `order_no` varchar(50) NOT NULL COMMENT '订单号',
  `status` tinyint(4) DEFAULT 0 COMMENT '支付状态(0:待支付,1:已支付,2:已退款,3已撤销)',
  `pay_amount` decimal(20,2) DEFAULT 0.00 COMMENT '实际支付价格(包含配送费用)',
  `pay_type` tinyint(4) DEFAULT 0 COMMENT '支付方式(0:支付宝,1:微信,2:银行卡,3:现金,4:余额,5:储值卡)',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单表';


CREATE TABLE `qy_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT 0 COMMENT '用户id',
  `status` tinyint(4) DEFAULT 0 COMMENT '订单状态(0:待支付,1:已支付,2:已完成)',
  `postage` decimal(20,2) DEFAULT 0.00 COMMENT '配送费用',
  `original_price` decimal(20,2) DEFAULT 0.00 COMMENT '订单原价(包含配送费用)',
  `pay_amount` decimal(20,2) DEFAULT 0.00 COMMENT '订单现价(包含配送费用)',
  `delivery_way` tinyint(4) DEFAULT 0 COMMENT '配送方式(0:自提,1:店家配送,2:物流配送)',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品订单表';


CREATE TABLE `qy_order_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(50) DEFAULT '' COMMENT '订单号',
  `place_at` datetime NOT NULL COMMENT '下单时间',
  `change_price_at` datetime DEFAULT NULL COMMENT '改价时间',
  `pay_at` datetime DEFAULT NULL COMMENT '支付时间',
  `reject_at` datetime DEFAULT NULL COMMENT '拒单时间',
  `delivery_at` datetime DEFAULT NULL COMMENT '配送时间',
  `self_pick_up_at` datetime DEFAULT NULL COMMENT '自提时间',
  `comment_at` datetime DEFAULT NULL COMMENT '评价时间',
  `close_at` datetime DEFAULT NULL COMMENT '关闭时间',
  `refund_at` datetime DEFAULT NULL COMMENT '退款时间',
  `finish_at` datetime DEFAULT NULL COMMENT '完成时间',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单日志表';


CREATE TABLE `qy_order_logistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `address_id` int(11) DEFAULT NULL COMMENT '下单用户地址id',
  `order_no` varchar(50) DEFAULT '' COMMENT '订单号',
  `address` varchar(100) DEFAULT '' COMMENT '配送地址',
  `link_name` varchar(100) DEFAULT '' COMMENT '收货人姓名',
  `phone` varchar(50) DEFAULT '' COMMENT '用户手机号',
  `delivery_at` datetime NOT NULL COMMENT '配送时间',
  `postage` decimal(20,2) DEFAULT 0.00 COMMENT '配送费用',
  `pickup_code` varchar(50) DEFAULT '' COMMENT '提货码',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单配送表';


CREATE TABLE `qy_order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(50) DEFAULT '' COMMENT '订单号',
  `product_id` int(11) DEFAULT 0 COMMENT '商品id',
  `product_bar` varchar(50) DEFAULT '' COMMENT '商品条码',
  `product_name` varchar(30) DEFAULT '' COMMENT '商品名称',
  `spec_id` int(11) DEFAULT 0 COMMENT '规格id',
  `spec_name` varchar(50) DEFAULT '' COMMENT '规格名称',
  `picture` varchar(100) DEFAULT '' COMMENT '商品图片',
  `product_count` int(11) DEFAULT 0 COMMENT '商品数',
  `product_price` decimal(20,2) DEFAULT 0.00 COMMENT '商品总价',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品表';

CREATE TABLE `qy_shopcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) DEFAULT 0 COMMENT '用户id',
  `product_id` int(11) DEFAULT 0 COMMENT '商品id',
  `spec_id` int(11) DEFAULT 0 COMMENT '规格id',
  
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单日志表';


CREATE TABLE `qy_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_name` varchar(30) DEFAULT '' COMMENT '商品名称',
  `product_bar` varchar(50) DEFAULT '' COMMENT '商品条码',
  `is_recommend` tinyint(4) DEFAULT 0 COMMENT '是否推荐 0 推荐 1不推荐',
  `status` tinyint(4) DEFAULT 1 COMMENT '商品状态(0:下架,1:上架)',
  `category_id` int(11) DEFAULT 0 COMMENT '分类id',
  `sort` tinyint(4) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL COMMENT '商品详细介绍',
  `picture` varchar(100) DEFAULT '' COMMENT '商品主图片',
  `stock` int(11) DEFAULT 0 COMMENT '商品库存',
  `pv_num` int(11) DEFAULT 0 COMMENT '查看数',
  `fav_num` int(11) DEFAULT 0 COMMENT '收藏数',
  `comment_num` int(11) DEFAULT 0 COMMENT '好评数',
  `original_price` decimal(20,2) DEFAULT 0.00 COMMENT '原价',
  `current_price` decimal(20,2) DEFAULT 0.00 COMMENT '现价',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';


CREATE TABLE `qy_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_name` varchar(50) DEFAULT '' COMMENT '分类名称',
  `category_type` varchar(50) DEFAULT 0 COMMENT '分类类型',
  `parent_id` int(11) DEFAULT 0 COMMENT '上级分类id',
  `level` int(11) DEFAULT 0 COMMENT '分类层级 1最高',
  `category_no` varchar(50) DEFAULT NULL COMMENT '分类编号',
  `icon` varchar(100) DEFAULT NULL COMMENT '分类图标',
  `status` tinyint(4) DEFAULT 1 COMMENT '状态(0:禁用 1:启用)',
  `sort` int(11) DEFAULT 0 COMMENT '排序(倒序排序,默认值0)',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';


CREATE TABLE `qy_product_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` int(11) DEFAULT 0 COMMENT '商品id',
  `picture` varchar(100) NOT NULL COMMENT '商品图片',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '打印完成时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';


CREATE TABLE `qy_product_spec_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` int(11) DEFAULT 0 COMMENT '商品id',
  `spec_id` varchar(50) DEFAULT 0 COMMENT '规格id',
  `spec_name` varchar(50) DEFAULT '' COMMENT '规格名称',
  `stock` int(11) DEFAULT 0 COMMENT '库存数',
  `init_stock` int(11) DEFAULT 0 COMMENT '每日补货初始库存',
  `original_price` decimal(20,2) DEFAULT '0.00' COMMENT '商品原价',
  `current_price` decimal(20,2) DEFAULT '0.00' COMMENT '商品现价',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格库存表';


CREATE TABLE `qy_product_specification` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `spec_name` varchar(50) DEFAULT '' COMMENT '规格名称',
  `spec_type` varchar(50) DEFAULT '' COMMENT '规格类型',
  `parent_id` varchar(50) DEFAULT 0 COMMENT '上级规格id',
  `spec_remark` varchar(50) DEFAULT NULL COMMENT '规格备注',
  `sort` bigint(20) DEFAULT 0 COMMENT '排序(倒序排序,默认值0)',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格尺寸表';


CREATE TABLE `qy_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `source` tinyint(4) DEFAULT 0 COMMENT '来源 0:小程序',
  `phone` varchar(20) DEFAULT '' COMMENT '手机号码',
  `logistics_phone` varchar(20) DEFAULT '' COMMENT '配送常用手机号码',
  `user_name` varchar(100) DEFAULT '' COMMENT '用户昵称',
  `user_id` varchar(50) DEFAULT '' COMMENT '用户id',
  `province` varchar(20) DEFAULT '' COMMENT '省份',
  `city` varchar(20) DEFAULT '' COMMENT '城市',
  `avatar` varchar(500) DEFAULT '' COMMENT '头像',
  `register_at` datetime DEFAULT NULL COMMENT '注册时间',
  `register_ip` varchar(20) DEFAULT '' COMMENT '注册IP',
  `login_at` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(20) DEFAULT '' COMMENT '登录IP',
  `status` tinyint(4) DEFAULT 1 COMMENT '账户状态(0:限制登录,-1:禁用,1:正常,2:限制功能)',
  `union_id` varchar(50) DEFAULT '',
  `open_id` varchar(50) DEFAULT '' COMMENT 'openid',
  `password` varchar(50) DEFAULT '' COMMENT '登录密码',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';


CREATE TABLE `qy_user_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT 0 COMMENT 'user_id',
  `link_phone` varchar(20) DEFAULT '' COMMENT '联系手机号',
  `link_name` varchar(30) DEFAULT '' COMMENT '联系人姓名',
  `link_sex` tinyint(4) DEFAULT 0 COMMENT '联系人性别 0:男,1:女',
  `address` varchar(100) DEFAULT '' COMMENT '详细地址',
  `is_default` tinyint(4) DEFAULT 1 COMMENT '0 默认地址 1非默认地址',
  `label` varchar(30) DEFAULT NULL COMMENT '标签',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';