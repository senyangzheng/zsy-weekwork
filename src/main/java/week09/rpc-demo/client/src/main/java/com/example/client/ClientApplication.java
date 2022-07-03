package com.example.client;

import com.alibaba.fastjson.parser.ParserConfig;
import com.rpc.core.balance.loadbalance.WeightBalance;
import com.rpc.core.filter.client.Retry;
import com.rpc.core.proxy.RpcByteBuddy;
import com.rpc.core.proxy.RpcClient;
import com.rpc.core.proxy.RpcClientJdk;
import com.rpc.model.Order;
import com.rpc.model.User;
import com.rpc.service.OrderService;
import com.rpc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class ClientApplication {

    public static void main(String[] args) {
        RpcClient jdk = new RpcClientJdk();
        UserService userService = jdk.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        if (user == null) {
            log.info("Client service invoke Error");
            return;
        }
        System.out.println("find user id=1 from server: " + user.getName());

        RpcClient buddy = new RpcByteBuddy();
        OrderService orderService = buddy.create(OrderService.class, "http://localhost:8080/");
        Order order = orderService.findById(1992129);
        if (order == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println(String.format("find order name=%s, user=%d",order.getName(),order.getUserId()));

    }

}
