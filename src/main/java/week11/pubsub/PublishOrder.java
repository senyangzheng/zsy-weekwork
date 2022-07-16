package week11.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.Random;

/**
 * @projectName: zsy-weekwork
 * @package: week11.pubsub
 * @className: PublishOrder
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 00:33
 */
public class PublishOrder {

    public PublishOrder(JedisPool jedisPool, String channelName) {
        System.out.println("Start publisher order");
        try (Jedis jedis = jedisPool.getResource()) {
            int sleepTime = 0;
            for (int i = 0; i < 20; i++) {
                sleepTime = new Random().nextInt(10000) + 1;
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jedis.publish(channelName, "order sleep " + sleepTime);
                System.out.println("push order sleep" + sleepTime);
            }
            jedis.publish(channelName, "");
        }
    }
}
