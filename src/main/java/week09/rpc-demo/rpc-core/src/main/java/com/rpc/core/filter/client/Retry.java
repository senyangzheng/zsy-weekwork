package com.rpc.core.filter.client;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.filter.client
 * @className: Retry
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:25
 */
public class Retry {

    private static int retryLimit = 0;

    public static int getRetryLimit() {
        return retryLimit;
    }

    public static void setRetryLimit(int retryLimit) {
        Retry.retryLimit = retryLimit;
    }
}
