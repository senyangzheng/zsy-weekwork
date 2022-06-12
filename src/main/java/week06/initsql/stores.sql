create table zsy_test.stores
(
    id           bigint(11) auto_increment comment '主键id'
        primary key,
    store_name   varchar(100)  default ''                not null comment '商铺名称',
    store_desc   varchar(500)  default ''                not null comment '商铺简介',
    store_score  decimal(2, 2) default 0.00              not null comment '商铺分数',
    manager_name varchar(100)  default ''                not null comment '掌柜名称',
    store_status tinyint(2)    default 0                 not null comment '商户状态 0正常 1关闭',
    create_time  timestamp     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time  timestamp     default CURRENT_TIMESTAMP not null comment '更新时间',
    is_delete    tinyint(2)    default 0                 not null comment '是否删除 0否 1是'
)
    comment '商户信息表';

