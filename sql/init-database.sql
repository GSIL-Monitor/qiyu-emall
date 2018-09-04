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

CREATE TABLE `qy_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` tinyint(4) DEFAULT 0 COMMENT '类型标记 1商品',
  `name` varchar(30) DEFAULT '' COMMENT '名称',
  `picture` varchar(100) DEFAULT '' COMMENT '图片',
  `url` varchar(100) DEFAULT '' COMMENT 'banner链接url',
  `store_id` int(11) DEFAULT 0 COMMENT '所属店铺id',
  `status` tinyint(4) DEFAULT 0 COMMENT '0 显示 1隐藏 2删除',
  `sort` int(11) DEFAULT 0 COMMENT '排序,值越小越靠前',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='banner管理';

CREATE TABLE `qy_merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `merchant_no` varchar(50) DEFAULT '' COMMENT '商户编码',
  `merchant_name` varchar(50) DEFAULT '' COMMENT '商户名称',
  `contact_name` varchar(50) DEFAULT '' COMMENT '商户联系人名称',
  `phone` varchar(20) DEFAULT '' COMMENT '商户联系人手机号',
  `address` varchar(50) DEFAULT '' COMMENT '商户联系地址',
  `merchant_logo` varchar(100) DEFAULT '' COMMENT '商户logo',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户信息表';

CREATE TABLE `qy_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `merchant_id` int(11) DEFAULT 0 COMMENT '商户id',
  `store_type` varchar(50) DEFAULT '' COMMENT '店铺类型',
  `store_no` varchar(50) DEFAULT '' COMMENT '门店号',
  `store_name` varchar(50) DEFAULT '' COMMENT '店铺名称',
  `province_id` int(11) DEFAULT 0 COMMENT '所在省份id',
  `province_name` varchar(30) DEFAULT '' COMMENT '所在省份名称',
  `city_id` int(11) DEFAULT 0 COMMENT '所在城市id',
  `city_name` varchar(30) DEFAULT '' COMMENT '所在城市名称',
  `address` varchar(100) DEFAULT '' COMMENT '店铺地址',
  `server_address` varchar(50) DEFAULT '' COMMENT '店铺配送地址',
  `open_time` varchar(50) DEFAULT '' COMMENT '店铺营业时间',
  `delivery_time` varchar(100) DEFAULT '' COMMENT '配送时间startTime-endTime,多个逗号隔开',
  `is_test` tinyint(4) DEFAULT 0 COMMENT '是否测试店铺 0非 1是',
  `contact` varchar(20) DEFAULT '' COMMENT '联系电话',
  `description` varchar(300) DEFAULT '' COMMENT '店铺介绍',
  `characteristic` varchar(300) DEFAULT '' COMMENT '店铺特色描述',
  `longitude` varchar(20) DEFAULT '' COMMENT '经度',
  `latitude` varchar(20) DEFAULT '' COMMENT '纬度',
  `sort` int(11) DEFAULT 0 COMMENT '排序(倒序排序,默认值0)',
  `status` tinyint(4) DEFAULT 1 COMMENT '店铺状态(0:关店,-1:禁用,1:开店)',
  `picture` varchar(100) DEFAULT '' COMMENT '店铺图片',
  `sales` varchar(300) DEFAULT '' COMMENT '打折优惠信息',
  `postage` decimal(20,2) DEFAULT 0.00 COMMENT '配送费用',
  `postage_limit` decimal(20,2) DEFAULT 0.00 COMMENT '配送减免金额',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';


CREATE TABLE `qy_merchant_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `merchant_id` int(11) NOT NULL DEFAULT 0 COMMENT '后端商户id',
  `account` varchar(20) DEFAULT '' COMMENT '登录账户',
  `password` varchar(50) DEFAULT '' COMMENT '登录密码',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `user_id` int(11) DEFAULT 0 COMMENT '用户id',
  `status` tinyint(4) DEFAULT 1 COMMENT '账户状态(0:限制登录,-1:禁用,1:启用)',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户用户表';

CREATE TABLE `qy_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pay_no` varchar(50) DEFAULT '' COMMENT '支付流水号',
  `order_no` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT 0 COMMENT '用户id',
  `store_id` int(11) DEFAULT 0 COMMENT '店铺id',
  `status` tinyint(4) DEFAULT 0 COMMENT '订单状态(0:待支付,1:已支付,2:已拒单,3:待配送,4:已关闭,5:待评价,6:已完成,7:已退款)',
  `postage` decimal(20,2) DEFAULT 0.00 COMMENT '配送费用',
  `original_price` decimal(20,2) DEFAULT 0.00 COMMENT '订单原价(包含配送费用)',
  `current_price` decimal(20,2) DEFAULT 0.00 COMMENT '订单现价(包含配送费用)',
  `pay_amount` decimal(20,2) DEFAULT 0.00 COMMENT '实际支付价格(包含配送费用)',
  `pay_way` tinyint(4) DEFAULT 0 COMMENT '支付方式(0:支付宝,1:微信,2:银行卡,3:现金,4:储值卡,5:积分)',
  `delivery_way` tinyint(4) DEFAULT 0 COMMENT '配送方式(0:自提,1:店家配送,2:物流配送)',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品规格库存表';

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

CREATE TABLE `qy_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_name` varchar(30) DEFAULT '' COMMENT '商品名称',
  `product_bar` varchar(50) DEFAULT '' COMMENT '商品条码',
  `characteristic` varchar(300) DEFAULT '' COMMENT '商品特色',
  `is_recommend` tinyint(4) DEFAULT 0 COMMENT '是否推荐 0 推荐 1不推荐',
  `status` tinyint(4) DEFAULT 1 COMMENT '商品状态(0:下架,1:上架)',
  `is_test` tinyint(4) DEFAULT 1 COMMENT '是否测试商品(0:是,1:不是)',
  `merchant_id` int(11) DEFAULT 0 COMMENT '商户id',
  `store_id` int(11) DEFAULT 0 COMMENT '店铺id',
  `category_id` int(11) DEFAULT 0 COMMENT '分类id',
  `sort` tinyint(4) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL COMMENT '商品详细介绍',
  `picture` varchar(100) DEFAULT '' COMMENT '商品图片',
  `stock` int(11) DEFAULT 0 COMMENT '商品库存',
  `pv_num` int(11) DEFAULT 0 COMMENT '查看数',
  `fav_num` int(11) DEFAULT 0 COMMENT '收藏数',
  `order_num` int(11) DEFAULT 0 COMMENT '订单数',
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
  `merchant_id` int(11) DEFAULT 0 COMMENT '后端商户id',
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
  `merchant_id` int(11) DEFAULT 0 COMMENT '商户id',
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

CREATE TABLE `qy_printer_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `device_no` varchar(50) DEFAULT '' COMMENT '打印设备编号',
  `device_secret` varchar(50) DEFAULT '' COMMENT '打印设备密钥',
  `user_id` varchar(50) DEFAULT '' COMMENT '设备用户id',
  `api_secret` varchar(50) DEFAULT '' COMMENT '设备api密钥',
  `merchant_id` int(11) DEFAULT 0 COMMENT '商户id',
  `store_id` int(11) DEFAULT 0 COMMENT '店铺id',
  `status` tinyint(4) DEFAULT 1 COMMENT '内部状态(1:正常使用,-1:停用,0:过期,2:欠费)',
  `printer_status` tinyint(4) DEFAULT 1 COMMENT '打印机状态(1:在线,-1:离线,0:缺纸)',
  `channel` tinyint(4) DEFAULT 1 COMMENT '打印机渠道(1:易联云,2:pos机)',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注描述',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='打印设备表';

CREATE TABLE `qy_printer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(50) DEFAULT '' COMMENT '订单号',
  `pay_no` varchar(50) DEFAULT '' COMMENT '支付流水号',
  `printer_info` varchar(2048) DEFAULT '' COMMENT '打印内容',
  `device_id` varchar(50) DEFAULT '' COMMENT '设备id',
  `commit_status` tinyint(4) DEFAULT 0 COMMENT '提交状态(1:提交成功,-1:提交失败,0:未提交)',
  `printer_status` tinyint(4) DEFAULT 0 COMMENT '打印状态(1:打印成功,-1:打印出错,0:未打印)',
  `retry_count` tinyint(4) DEFAULT 0 COMMENT '打印重试次数',
  `printer_no` varchar(50) DEFAULT '' COMMENT '打印任务id',
  `finish_at` datetime DEFAULT NULL COMMENT '打印完成时间',
  `create_at` datetime NOT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(30) DEFAULT '' COMMENT '创建人',
  `update_by` varchar(30) DEFAULT '' COMMENT '修改人',
  `remark` varchar(100) DEFAULT '' COMMENT '备注描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='打印内容表';