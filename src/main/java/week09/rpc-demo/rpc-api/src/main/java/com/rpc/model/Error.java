package com.rpc.model;

import lombok.Data;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.model
 * @className: ERROR
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:00
 */
@Data
public class Error {
    private Integer status;
    private String message;

    public Error(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
