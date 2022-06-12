create table zsy_test.commodities
(
    id               bigint(11) auto_increment comment '主键id'
        primary key,
    store_id         bigint(11)                               not null comment '商铺关联id',
    commodity_name   varchar(100)   default ''                not null comment '商品名称',
    commodity_desc   varchar(255)   default ''                not null comment '商品描述',
    price            decimal(20, 2) default 0.00              not null comment '商品单价',
    inventory        int(9)         default 0                 not null comment '库存',
    model            json                                     null comment '型号类型',
    specification    json                                     null comment '规格参数',
    commodity_status tinyint(2)     default 0                 not null comment '商品状态 -1下架 0正常 1预售',
    create_time      timestamp      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      timestamp      default CURRENT_TIMESTAMP not null comment '更新时间',
    is_delete        tinyint(2)     default 0                 not null comment '是否删除 0否 1是'
)
    comment '商品信息表';

