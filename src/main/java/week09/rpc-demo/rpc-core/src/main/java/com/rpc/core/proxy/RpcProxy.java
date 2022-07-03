package com.rpc.core.proxy;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.proxy
 * @className: RpcProxy
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 21:37
 */
public class RpcProxy {
    private ConcurrentHashMap<String, Object> proxyCache = new ConcurrentHashMap<>();

    Object getProxy(String className) {
        return proxyCache.get(className);
    }

    Boolean isExit(String className) {
        return proxyCache.containsKey(className);
    }

    void add(String className, Object proxy) {
        proxyCache.put(className, proxy);
    }
}
