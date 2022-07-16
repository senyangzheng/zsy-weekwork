package week11.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @projectName: zsy-weekwork
 * @package: week11.demo
 * @className: RedisApplication
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 02:41
 */
@SpringBootConfiguration
@ComponentScan(basePackages = "week11.demo")
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
