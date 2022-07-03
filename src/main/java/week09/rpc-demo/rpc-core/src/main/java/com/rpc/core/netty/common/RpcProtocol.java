package com.rpc.core.netty.common;

import lombok.Data;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.netty.common
 * @className: RpcProtocol
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:30
 */
@Data
public class RpcProtocol {
    /**
     * 数据大小
     */
    private int len;

    /**
     * 数据内容
     */
    private byte[] content;
}
