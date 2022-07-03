package com.example.server.service;


import com.rpc.core.annotation.ProviderService;
import com.rpc.core.exection.CustomException;
import com.rpc.model.Order;
import com.rpc.service.OrderService;

/**
 * @author lw
 */
@ProviderService(service = "com.rpc.demo.service.OrderService")
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findById(Integer id) {
        return new Order(1, "RPC", 1);
    }

    @Override
    public Order findError() {
        throw new CustomException("Custom exception");
    }
}
