package com.rpc.model;

import lombok.Data;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.model
 * @className: User
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 16:41
 */
@Data
public class User {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
