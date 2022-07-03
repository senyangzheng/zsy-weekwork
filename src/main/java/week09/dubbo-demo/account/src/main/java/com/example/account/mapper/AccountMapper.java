package com.example.account.mapper;

import com.example.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @projectName: dubbo-demo
 * @package: com.example.account.mapper
 * @className: AccountMapper
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 22:09
 */
@Mapper
@Repository
public interface AccountMapper {
    /**
     * pay for money
     * @param account account
     */
    @Update("update `account` set us_wallet = us_wallet + #{us_wallet}, cny_wallet = cny_wallet + " +
            "#{cny_wallet} where us_wallet >= #{us_wallet} and cny_wallet >= #{cny_wallet} and id = #{id}")
    boolean payment(Account account);

    /**
     * query one
     * @param account account
     * @return account
     */
    @Select("select * from himly_dubbo_account where id = #{id}")
    Account queryOne(Account account);
}
