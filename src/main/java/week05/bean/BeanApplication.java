package week05.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "week05.bean")
public class BeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanApplication.class, args);
    }
}
