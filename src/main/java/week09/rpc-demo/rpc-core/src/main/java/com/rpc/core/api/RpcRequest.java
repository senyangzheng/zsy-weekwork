package com.rpc.core.api;

import lombok.Data;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.api
 * @className: RpcRequest
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:07
 */
@Data
public class RpcRequest {
    /**
     * 接口类名称
     */
    private String serviceClass;

    /**
     * 方法名
     */
    private String method;

    /**
     * 参数
     */
    private Object[] argv;

    private String group;

    private String version;
}
