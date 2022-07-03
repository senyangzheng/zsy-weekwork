package com.example.account.service;

import com.example.account.entity.Account;
import com.example.account.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @projectName: dubbo-demo
 * @package: com.example.account.service
 * @className: AccountServiceImpl
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 22:13
 */
@Slf4j
@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Resource
    private AccountMapper accountMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean pay(Account account) {
        boolean isSuccess = accountMapper.payment(account);
        log.info("py account : + " + account.getId() + " try result: " + isSuccess);
        log.info("py account : + " + account.getId() + " try data: " + accountMapper.queryOne(account));
        return isSuccess;
    }
}
