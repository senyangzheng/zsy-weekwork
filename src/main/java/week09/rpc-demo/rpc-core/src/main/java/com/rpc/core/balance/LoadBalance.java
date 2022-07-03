package com.rpc.core.balance;

import com.rpc.core.api.ProviderInfo;

import java.util.List;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.balance.loadbalance
 * @className: LoadBalance
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:09
 */
public interface LoadBalance {
    /**
     * 从当前Provider列表中，通过负载均衡，返回其中一个Provider的请求地址
     *
     * @param providers   provider list
     * @param serviceName service name
     * @param methodName  method name
     * @return provider host url
     */
    String select(List<ProviderInfo> providers, String serviceName, String methodName);

}
