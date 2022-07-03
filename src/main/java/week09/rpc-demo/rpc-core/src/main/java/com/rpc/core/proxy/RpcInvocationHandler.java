package com.rpc.core.proxy;

import com.alibaba.fastjson.JSON;
import com.rpc.core.api.RpcRequest;
import com.rpc.core.api.RpcResponse;
import com.rpc.core.filter.client.Retry;
import com.rpc.core.netty.client.RpcNettyClientSync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.proxy
 * @className: RpcInvocationHandler
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 21:38
 */
@Slf4j
public class RpcInvocationHandler implements InvocationHandler, MethodInterceptor {

    private final Class<?> serviceClass;
    private final String group;
    private final String version;
    private final String url;

    private int retryTime = 0;

    <T> RpcInvocationHandler(Class<T> serviceClass, String url) {
        this.serviceClass = serviceClass;
        this.group = "default";
        this.version = "default";
        this.url = url;
        System.out.println("Client Service Class Reflect: " + group + ":" + version);
    }

    <T> RpcInvocationHandler(Class<T> serviceClass, String group, String version, String url) {
        this.serviceClass = serviceClass;
        this.group = group;
        this.version = version;
        this.url = url;
        System.out.println("Client Service Class Reflect: " + group + ":" + version);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            return process(serviceClass, method, args);
        } catch (Exception e) {
            if (retryTime < Retry.getRetryLimit()) {
                log.info("send to rpc server exception, will retry");
                retryTime += 1;
                invoke(proxy, method, args);
            } else {
                log.info("retry limit, end");
                retryTime = 0;
            }
        }
        return null;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) {
        try {
            return process(serviceClass, method, args);
        } catch (Exception e) {
            if (retryTime < Retry.getRetryLimit()) {
                log.info("send to rpc server exception, will retry");
                retryTime += 1;
                intercept(o, method, args, methodProxy);
            } else {
                log.info("retry limit, end");
                retryTime = 0;
            }
        }
        return null;
    }

    /**
     * 发送请求到服务端
     * 获取结果后序列号成对象，返回
     *
     * @param service service name
     * @param method  service method
     * @param params  method params
     * @return object
     */
    private Object process(Class<?> service, Method method, Object[] params) {
        log.info("Client proxy instance method invoke");

        // 自定义了Rpc请求的结构 RpcRequest,放入接口名称、方法名、参数
        log.info("Build Rpc request");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setServiceClass(service.getName());
        rpcRequest.setMethod(method.getName());
        rpcRequest.setArgv(params);
        rpcRequest.setGroup(group);
        rpcRequest.setVersion(version);


        // 客户端使用的 netty，发送请求到服务端，拿到结果（自定义结构：rpcfxResponse)
        log.info("Client send request to Server");
        RpcResponse rpcResponse;
        try {
            rpcResponse = RpcNettyClientSync.getInstance().getResponse(rpcRequest, url);
        } catch (InterruptedException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        log.info("Client receive response Object");
        assert rpcResponse != null;
        if (!rpcResponse.getStatus()) {
            log.info("Client receive exception");
            rpcResponse.getException().printStackTrace();
            return null;
        }

        // 序列化成对象返回
        log.info("Response:: " + rpcResponse.getResult());
        return JSON.parse(rpcResponse.getResult().toString());
    }
}
