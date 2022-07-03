package com.example.account.entity;

import lombok.Data;

/**
 * @projectName: dubbo-demo
 * @package: com.example.account.entity
 * @className: Account
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 22:09
 */
@Data
public class Account {
    private Long id;

    private String name;

    private Long cny_wallet;

    private Long us_wallet;
}
