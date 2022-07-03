package com.rpc.core.filter.server;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.filter.server
 * @className: BackListFilter
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:14
 */
public class BlackListFilter {

    private static ConcurrentSkipListSet blackList = new ConcurrentSkipListSet();

    public static void addBlackAddress(String address) {
        blackList.add(address);
    }

    public static boolean checkAddress(String address) {
        return blackList.contains(address);
    }
}
