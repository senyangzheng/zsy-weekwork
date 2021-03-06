package week11;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import week11.demo.OrderService;
import week11.demo.RedisApplication;

import javax.annotation.Resource;

/**
 * @projectName: zsy-weekwork
 * @package: week11
 * @className: OrderTest
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 02:39
 */
@SpringBootTest(classes = OrderService.class)
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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start remove order");
                    orderService.removeOrder(ORDER_KEY);
                    System.out.println(redisTemplate.opsForValue().get("ORDER_KEY"));
                }
            }, "removeOrderThread" + i).start();
        }
    }
}
