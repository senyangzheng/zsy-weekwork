package com.homework.homeworkdemo.service.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @projectName: zsy-weekwork
 * @package: week11.demo
 * @className: Order
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 02:00
 */
@Component
public class OrderService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void initOrder(String orderKey) {
        redisTemplate.opsForValue().set(orderKey, "10000");
    }

    public void removeOrder(String key) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        entityIdCounter.getAndDecrement();
    }
}
