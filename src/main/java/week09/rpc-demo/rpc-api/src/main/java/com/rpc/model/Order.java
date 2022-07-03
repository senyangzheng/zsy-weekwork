package com.rpc.model;

import lombok.Data;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.model
 * @className: Order
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 16:41
 */
@Data
public class Order {
    private Integer id;
    private String name;
    private Integer userId;

    public Order(Integer id, String name, Integer userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }
}
