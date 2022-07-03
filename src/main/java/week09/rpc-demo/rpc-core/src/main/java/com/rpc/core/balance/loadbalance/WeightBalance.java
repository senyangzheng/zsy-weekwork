package com.rpc.core.balance.loadbalance;

import com.rpc.core.api.ProviderInfo;

import java.util.List;
import java.util.Random;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.core.balance.loadbalance
 * @className: WeightBalance
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:11
 */
public class WeightBalance extends AbstractLoadBalance {
    public static final String NAME = "weight_balance";

    @Override
    public String select(List<ProviderInfo> providers, String serviceName, String methodName) {
        int totalWeight = 0;
        for (ProviderInfo provider : providers) {
            totalWeight += provider.getWeight();
        }

        int random = new Random().nextInt(totalWeight);
        System.out.printf("provider amount: %s, random : %d\n", providers.size(), random);
        for (ProviderInfo provider : providers) {
            random -= provider.getWeight();
            if (random <= 0) {
                return provider.getUrl();
            }
        }
        return providers.get(providers.size() - 1).getUrl();
    }
}
