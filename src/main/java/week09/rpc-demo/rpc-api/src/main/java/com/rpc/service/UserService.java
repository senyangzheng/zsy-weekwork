package com.rpc.service;

import com.rpc.model.User;

/**
 * @projectName: rpc-demo
 * @package: com.rpc.service
 * @className: UserService
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/3 17:00
 */
public interface UserService {
    /**
     * find by id
     * @param id id
     * @return user
     */
    User findById(Integer id);
}
