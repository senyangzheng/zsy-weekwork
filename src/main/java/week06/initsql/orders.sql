create table zsy_test.orders
(
    id            bigint(11) auto_increment comment '主键id'
        primary key,
    order_id      varchar(30)    default ''                not null comment '订单id',
    user_id       bigint(11)                               not null comment '用户信息关联id',
    logistics_id  bigint(11)                               not null comment '物流信息关联id',
    commodity_ids varchar(255)   default ''                not null comment '商品列表',
    order_status  tinyint(2)     default 0                 not null comment '订单状态：-1关闭 0待付款 1待发货 2待收货 3待评价 4退款/售后',
    refund_status tinyint(2)     default 0                 not null comment '退款状态：0申请中 1退款中 2退款成功',
    order_price   decimal(20, 2) default 0.00              not null comment '订单金额',
    create_time   timestamp      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   timestamp      default CURRENT_TIMESTAMP not null comment '修改时间',
    is_delete     tinyint(2)     default 0                 not null comment '是否删除',
    constraint orders_order_id_uindex
        unique (order_id),
    constraint orders_user_id_uindex
        unique (user_id)
)
    comment '订单信息表';

