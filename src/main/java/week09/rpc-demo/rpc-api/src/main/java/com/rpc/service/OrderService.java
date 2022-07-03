package com.rpc.service;

import com.rpc.model.Order;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.service
 * @className: OrderService
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:00
 */
public interface OrderService {
    /**
     * find by id
     * @param id id
     * @return order
     */
    Order findById(Integer id);

    /**
     * return exception
     * @return exception
     */
    Order findError();
}
