package week11.pubsub;

import redis.clients.jedis.JedisPool;

/**
 * @projectName: zsy-weekwork
 * @package: week11.pubsub
 * @className: PubsubTest
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 00:33
 */
public class PubsubTest {

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        String channelName = "ZSY_ORDER";
        SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
    }
}
