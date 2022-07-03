package com.rpc.core.api;

import lombok.Data;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.api
 * @className: RpcResponse
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:08
 */
@Data
public class RpcResponse {

    /**
     * 响应结果
     */
    private Object result;

    /**
     * 函数是否执行成功
     */
    private Boolean status;

    /**
     * 执行失败的异常信息
     */
    private Exception exception;
}
