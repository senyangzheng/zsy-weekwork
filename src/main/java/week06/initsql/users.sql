create table zsy_test.users
(
    id            bigint(11) auto_increment comment '主键'
        primary key,
    user_name     varchar(50)    default ''                not null comment '用户名',
    pass_word     varchar(50)    default ''                not null comment '密码',
    user_type     tinyint(2)     default 0                 not null comment '用户类型 0顾客 1店家',
    real_name     varchar(30)    default ''                not null comment '姓名',
    id_card       varchar(18)    default ''                not null comment '身份证号18位（一代身份证15位）',
    phone_num     varchar(11)    default ''                not null comment '手机号',
    account_money decimal(20, 2) default 0.00              not null comment '账户金额',
    create_time   timestamp      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   timestamp      default CURRENT_TIMESTAMP not null comment '更新时间',
    is_delete     tinyint(2)     default 0                 not null comment '是否删除：0否1是'
)
    comment '用户信息表';

