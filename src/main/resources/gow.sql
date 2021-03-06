/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : gow

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 23/09/2019 09:26:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gow_category
-- ----------------------------
DROP TABLE IF EXISTS `gow_category`;
CREATE TABLE `gow_category`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '分类id ',
  `cat_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `cat_parent_id` bigint(10) NULL DEFAULT NULL COMMENT '父级分类id',
  `cat_sort` mediumint(3) NULL DEFAULT NULL COMMENT '排序   ',
  `cat_is_show` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否显示(0:显示，1\r\n\r\n：不显示)',
  `cat_delflag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除（0:正常，\r\n\r\n1:已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4742 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品\r\n\r\n分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_contact_us
-- ----------------------------
DROP TABLE IF EXISTS `gow_contact_us`;
CREATE TABLE `gow_contact_us`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系名称',
  `contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_customer
-- ----------------------------
DROP TABLE IF EXISTS `gow_customer`;
CREATE TABLE `gow_customer`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `customer_username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `mobile` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `customer_password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `customer_nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `customer_realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0.0.0.0' COMMENT '登录IP',
  `login_time` timestamp(0) NULL DEFAULT NULL COMMENT '登录时间',
  `customer_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `captcha` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机验证码',
  `aead_time` timestamp(0) NULL DEFAULT NULL COMMENT '发送验证码的时间 30\r\n\r\n分钟失效',
  `pwd_captcha` varchar(75) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件验证码',
  `pwd_aead_time` timestamp(0) NULL DEFAULT NULL COMMENT '发送邮箱验证码\r\n\r\n的时间 120分钟失效',
  `login_error_count` bigint(10) NULL DEFAULT 0 COMMENT '记录当前会员登陆\r\n\r\n的错误次数',
  `user_salt_val` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值,用于密码加密\r\n\r\n',
  `customer_referee` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员推荐人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除状态（0：正常，1：已删除）',
  `integral` int(10) NULL DEFAULT 0 COMMENT '会员总积分',
  `is_use` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否冻结（0：正常，1：已冻结）',
  `is_use_time` datetime(0) NULL DEFAULT NULL COMMENT '冻结时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2478 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员\r\n\r\n表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_customer_address
-- ----------------------------
DROP TABLE IF EXISTS `gow_customer_address`;
CREATE TABLE `gow_customer_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `customer_id` bigint(20) NOT NULL COMMENT '会员id',
  `address_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址全称',
  `address_province` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `address_city` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `address_county` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区/县',
  `address_street` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '街道',
  `address_detail` varchar(75) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `address_phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `is_default` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否默认（1默认，0：\r\n\r\n非默认）',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `address_telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定电话',
  `address_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货邮箱',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志(0:正常，1:已\r\n\r\n删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 859 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员\r\n\r\n地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_goods
-- ----------------------------
DROP TABLE IF EXISTS `gow_goods`;
CREATE TABLE `gow_goods`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` bigint(10) NULL DEFAULT NULL COMMENT '分类id',
  `goods_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_spec` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `goods_subtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品副标题 ',
  `goods_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编号',
  `goods_keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品关键词',
  `goods_brief` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品简介',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '销售价',
  `goods_old_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '旧销售价',
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `goods_score` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品评分 ',
  `goods_deno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '盒' COMMENT '计价单位 ',
  `goods_detail_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详细介绍 ',
  `goods_detail_img` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情图片',
  `goods_number` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除（0：正常，1：已删除）',
  `is_upper_lower_racks` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否上架（0：未上架，1：已上架）',
  `is_recommend` enum('0','1','2','3') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否推荐（0：未推荐，1：已推荐）',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2083 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品\r\n\r\n表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_goods_collection
-- ----------------------------
DROP TABLE IF EXISTS `gow_goods_collection`;
CREATE TABLE `gow_goods_collection`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `customer_id` bigint(10) NULL DEFAULT NULL COMMENT '会员id',
  `goods_id` bigint(10) NOT NULL COMMENT '商品id',
  `goods_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_spec` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '收藏价格',
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品\r\n\r\n表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_goods_detail_image
-- ----------------------------
DROP TABLE IF EXISTS `gow_goods_detail_image`;
CREATE TABLE `gow_goods_detail_image`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_goods_image
-- ----------------------------
DROP TABLE IF EXISTS `gow_goods_image`;
CREATE TABLE `gow_goods_image`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  `is_other_img` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否使用外部图片链接（0：不使用，1：使用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_goods_recommended
-- ----------------------------
DROP TABLE IF EXISTS `gow_goods_recommended`;
CREATE TABLE `gow_goods_recommended`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `title_captions` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题说明',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0：正常，1\r\n\r\n：已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `recommended_type` enum('0','1','2','3') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '商品推荐类型（1：完美专享，2：推荐精品，3：人气热卖）',
  `level` int(10) NULL DEFAULT NULL COMMENT '排序层级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_image_url
-- ----------------------------
DROP TABLE IF EXISTS `gow_image_url`;
CREATE TABLE `gow_image_url`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址路径',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_information
-- ----------------------------
DROP TABLE IF EXISTS `gow_information`;
CREATE TABLE `gow_information`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '资讯内容',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `praise_number` int(11) NULL DEFAULT 0 COMMENT '点赞数量',
  `evaluate_number` int(11) NULL DEFAULT 0 COMMENT '评价数量',
  `is_submit` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否提交（0：草稿，1：提交/发布）',
  `to_view_number` int(11) NULL DEFAULT 0 COMMENT '查看次数/阅读量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除（0：正常，1：已删除）',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_information_operation
-- ----------------------------
DROP TABLE IF EXISTS `gow_information_operation`;
CREATE TABLE `gow_information_operation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `information_id` bigint(20) NULL DEFAULT NULL COMMENT '资讯id',
  `is_focus` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否已关注（0：未关注，1：已关注）',
  `focus_time` datetime(0) NULL DEFAULT NULL COMMENT '关注时间',
  `is_praise` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否点赞（0：未点赞，1：已点赞）',
  `praise_time` datetime(0) NULL DEFAULT NULL COMMENT '点赞时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_message
-- ----------------------------
DROP TABLE IF EXISTS `gow_message`;
CREATE TABLE `gow_message`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0：正常，1\r\n\r\n：已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_order
-- ----------------------------
DROP TABLE IF EXISTS `gow_order`;
CREATE TABLE `gow_order`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '订单Id',
  `customer_id` bigint(10) NULL DEFAULT NULL COMMENT '会员id',
  `order_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `order_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '订单总金额',
  `pay_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '支付金额',
  `order_status` enum('0','1','2','3') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '订单状态\r\n\r\n(0:待付款，1:待发货，2:待收货，3：交易成功)',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` enum('1','2') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '支付类型（1：微信，2：\r\n\r\n支付宝）',
  `send_express_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `express_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流名称',
  `express_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `get_goods_time` datetime(0) NULL DEFAULT NULL COMMENT '收货时间',
  `shopping_addr_id` bigint(10) NULL DEFAULT NULL COMMENT '收货地址id',
  `shipping_province` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货省',
  `shipping_city` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货市',
  `shipping_county` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货区县',
  `shipping_street` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货街道',
  `shipping_address` varchar(330) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货详细地址',
  `shipping_person` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `shipping_phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货电话',
  `shipping_mobile` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货手机',
  `invoice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票抬头',
  `invoice_content` varchar(350) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票内容',
  `del_flag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记',
  `invoice_type` enum('0','1','2') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票类型',
  `customer_remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户留言',
  `order_integral` bigint(10) NULL DEFAULT NULL COMMENT '积分',
  `evaluate_flag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否评价 0未评价 \r\n\r\n1已经评价',
  `express_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '运费',
  `shipping_postcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `order_cancel_time` datetime(0) NULL DEFAULT NULL COMMENT '取消时间',
  `order_cancel_remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取消原因',
  `back_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '退单金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `send_person` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送货人',
  `send_mobile` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送货人电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `gow_order_goods`;
CREATE TABLE `gow_order_goods`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '订单商品id',
  `order_id` bigint(10) NULL DEFAULT NULL COMMENT '订单Id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_spec` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `comment_id` bigint(20) NULL DEFAULT NULL COMMENT '评论id',
  `goods_number` int(5) NULL DEFAULT NULL COMMENT '商品数量',
  `goods_info_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '货品交易价\r\n\r\n格',
  `goods_info_sum_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '小计金\r\n\r\n额',
  `have_gift_status` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否有赠品(0:\r\n\r\n没有，1：有)',
  `del_flag` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除(0:正常，1：已\r\n\r\n删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_payment
-- ----------------------------
DROP TABLE IF EXISTS `gow_payment`;
CREATE TABLE `gow_payment`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调域名，此网站的域名',
  `notify_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调成功通知地址',
  `return_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付成功页面跳转地址',
  `api_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求支付地址',
  `app_ecret` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付key值,token',
  `expire` int(255) NULL DEFAULT 0 COMMENT '订单过期时间',
  `default_price` decimal(10, 2) NULL DEFAULT 0.01 COMMENT '默认支付金额，测试使用',
  `is_default_price` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否开启默认支付金额（0：不开启，1：开启）',
  `uid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户id',
  `use_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用标识类型，标识需要使用那条数据，唯一(docpay:支付猫，pufpay：个人收款)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_paytype
-- ----------------------------
DROP TABLE IF EXISTS `gow_paytype`;
CREATE TABLE `gow_paytype`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `pay_type` enum('alipay','wechat') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付类型（alipay：支付宝，wechat：微信）',
  `is_use` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否启用（0：启用，1：不启用）',
  `is_default` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否默认（0：非默认，1：默认）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除（0：正常，1：已删除）',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gow_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `gow_shopping_cart`;
CREATE TABLE `gow_shopping_cart`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `customer_id` bigint(10) NULL DEFAULT NULL COMMENT '用户id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `goods_pre_price` bigint(10) NULL DEFAULT NULL COMMENT '优惠价格',
  `goods_number` int(10) NULL DEFAULT 1 COMMENT '商品数量',
  `del_flag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记(0:正常,1:已删\r\n\r\n除)',
  `shopping_cart_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_shop` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '标识是否已经购买（0：未\r\n\r\n购买，1：已购买）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8346 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
