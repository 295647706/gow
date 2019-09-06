

CREATE TABLE `gow_category`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '分类id ',
  `cat_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `cat_parent_id` bigint(10) NULL DEFAULT NULL COMMENT '父级分类id',
  `cat_sort` mediumint(3) NULL DEFAULT NULL COMMENT '排序   ',
  `cat_is_show` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否显示(0:显示，1：不显示)',
  `cat_delflag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除（0:正常，1:已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4741 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;


CREATE TABLE `gow_contact_us`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系名称',
  `contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


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
  `aead_time` timestamp(0) NULL DEFAULT NULL COMMENT '发送验证码的时间 30分钟失效',
  `pwd_captcha` varchar(75) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件验证码',
  `pwd_aead_time` timestamp(0) NULL DEFAULT NULL COMMENT '发送邮箱验证码的时间 120分钟失效',
  `login_error_count` bigint(10) NULL DEFAULT 0 COMMENT '记录当前会员登陆的错误次数',
  `user_salt_val` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值,用于密码加密',
  `customer_referee` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员推荐人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除状态（0：正常，1：已删除）',
  `integral` int(10) NULL DEFAULT 0 COMMENT '会员总积分',
  `is_use` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否冻结（0：正常，1：已冻结）',
  `is_use_time` datetime(0) NULL DEFAULT NULL COMMENT '冻结时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2478 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;


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
  `is_default` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否默认（1默认，0：非默认）',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `address_telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定电话',
  `address_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货邮箱',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志(0:正常，1:已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 859 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员地址表' ROW_FORMAT = Dynamic;


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
) ENGINE = InnoDB AUTO_INCREMENT = 2076 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;


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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;


CREATE TABLE `gow_goods_detail_image`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `gow_goods_image`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `gow_goods_recommended`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `title_captions` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题说明',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0：正常，1：已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `recommended_type` enum('0','1','2','3') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '商品推荐类型（1：完美专享，2：推荐精品，3：人气热卖）',
  `level` int(10) NULL DEFAULT NULL COMMENT '排序层级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `gow_message`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `is_delete` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0：正常，1：已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `gow_order`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '订单Id',
  `customer_id` bigint(10) NULL DEFAULT NULL COMMENT '会员id',
  `order_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `order_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '订单总金额',
  `pay_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '支付金额',
  `order_status` enum('0','1','2','3') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '订单状态(0:待付款，1:待发货，2:待收货，3：交易成功)',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` enum('1','2') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '支付类型（1：微信，2：支付宝）',
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
  `evaluate_flag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否评价 0未评价 ,1已经评价',
  `express_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '运费',
  `shipping_postcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `order_cancel_time` datetime(0) NULL DEFAULT NULL COMMENT '取消时间',
  `order_cancel_remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取消原因',
  `back_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '退单金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `send_person` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送货人',
  `send_mobile` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送货人电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE `gow_order_goods`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '订单商品id',
  `order_id` bigint(10) NULL DEFAULT NULL COMMENT '订单Id',
  `goods_id` bigint(10) NULL DEFAULT NULL COMMENT '商品id',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_spec` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格',
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `comment_id` bigint(20) NULL DEFAULT NULL COMMENT '评论id',
  `goods_number` int(5) NULL DEFAULT NULL COMMENT '商品数量',
  `goods_info_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '货品交易价格',
  `goods_info_sum_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '小计金额',
  `have_gift_status` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否有赠品(0:没有，1：有)',
  `del_flag` enum('1','0') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除(0:正常，1：已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


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
-- Records of gow_payment
-- ----------------------------
INSERT INTO `gow_payment` VALUES (1, 'http://gow.hdongx.com', '/order/paymentOrder?orderCode=', '/orderPage/order2-page', 'https://bufpay.com/api/pay/95134', '967e0dc6b34e46c082af6997253fde6c', 0, 0.01, '1', NULL, 'pufpay');
INSERT INTO `gow_payment` VALUES (2, 'http://gm.xiaomy.net', '/order/paymentOrder', '/orderPage/order2-page', 'http://pay.aswe.com.cn', 'BZCchKH9tcuJJ9tBSJ0cXChH9petb98c', 0, 0.01, '1', '4504', 'docpay');

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
  `del_flag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记(0:正常,1:已删除)',
  `shopping_cart_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_shop` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '标识是否已经购买（0：未购买，1：已购买）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8340 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


