create schema sharding_sphere_test_01;

create schema sharding_sphere_test_02;

CREATE TABLE `order_0`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_1`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_2`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_3`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_4`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_5`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_6`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_7`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_8`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_9`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_10`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_11`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_12`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_13`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_14`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';
CREATE TABLE `order_15`
(
    `id`            bigint(11)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `order_id`      bigint(11)     NOT NULL COMMENT '订单id',
    `user_id`       bigint(11)     NOT NULL COMMENT '用户信息关联id',
    `logistics_id`  bigint(11)     NOT NULL COMMENT '物流信息关联id',
    `commodity_ids` varchar(255)   NOT NULL DEFAULT '' COMMENT '商品列表',
    `order_status`  tinyint(2)     NOT NULL DEFAULT '0' COMMENT '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    `refund_status` tinyint(2)     NOT NULL DEFAULT '0' COMMENT '退款状态：0申请中 1退款中 2退款成功',
    `order_price`   decimal(20, 2) NOT NULL DEFAULT '0.00' COMMENT '订单金额',
    `create_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_delete`     tinyint(2)     NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `orders_order_id_uindex` (`order_id`),
    UNIQUE KEY `orders_user_id_uindex` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单信息表';