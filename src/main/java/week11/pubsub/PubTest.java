package week11.pubsub;

import redis.clients.jedis.JedisPool;

/**
 * @projectName: zsy-weekwork
 * @package: week11.pubsub
 * @className: PubSubTest2
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 01:06
 */
public class PubTest {

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        String channelName = "ZSY_ORDER";
        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
    }
}
