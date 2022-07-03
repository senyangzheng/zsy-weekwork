package com.rpc.core.filter.client;

import com.rpc.core.api.ProviderInfo;

import java.util.List;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.filter.client
 * @className: RpcFilter
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:13
 */
public interface RpcFilter {

    List<ProviderInfo> filter(List<ProviderInfo> providers, List<String> tags);

}
