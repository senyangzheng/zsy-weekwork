package com.rpc.core.proxy;

import com.google.common.base.Joiner;
import com.rpc.core.balance.loadbalance.WeightBalance;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.proxy
 * @className: RpcClient
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:15
 */
public interface RpcClient {
    /**
     * create proxy
     * @param serviceClass service class
     * @param url server url
     * @param <T> T
     * @return proxy class
     */
    <T> T create(final Class<T> serviceClass, final String url);
}
