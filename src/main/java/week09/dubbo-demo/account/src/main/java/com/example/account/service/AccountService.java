package com.example.account.service;

import com.example.account.entity.Account;
import org.dromara.hmily.annotation.Hmily;

/**
 * @projectName: dubbo-demo
 * @package: com.example.account.service
 * @className: AccountService
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 22:12
 */
public interface AccountService {

    @Hmily
    boolean pay(Account account);
}
