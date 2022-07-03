package com.example.transaction;

import com.example.transaction.service.TransactionService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;

@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class TransactionApplication implements ApplicationRunner {

    @Resource
    private TransactionService transactionService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transactionService.transaction();
    }

}
