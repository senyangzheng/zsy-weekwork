package com.homework.homeworkdemo.redis;

import com.homework.homeworkdemo.HomeworkDemoApplication;
import com.homework.homeworkdemo.service.redis.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @projectName: zsy-weekwork
 * @package: week11
 * @className: OrderTest
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 02:39
 */
@SpringBootTest(classes = HomeworkDemoApplication.class)
public class OrderTest {

    private static final String ORDER_KEY = "zsy_order";
    @Resource
    private OrderService orderService;

    @Resource
    private RedisTemplate redisTemplate;


    @Test
    public void initOrder() {
        orderService.initOrder(ORDER_KEY);
    }

    @Test
    public void removeOrder() {
        for (int i = 0; i < 10; i++) {
            System.out.println("start remove order");
            orderService.removeOrder(ORDER_KEY);
            System.out.println(redisTemplate.opsForValue().get(ORDER_KEY));
        }
    }
}
