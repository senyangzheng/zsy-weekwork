package com.example.server.service;

import com.rpc.core.annotation.ProviderService;
import com.rpc.model.User;
import com.rpc.service.UserService;

/**
 * @author lw
 */
@ProviderService(service = "com.rpc.service.UserService", weight = 2)
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC weight 2");
    }
}
