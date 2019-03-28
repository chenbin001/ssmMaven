package org.ssmmaven.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssmmaven.bean.User;
import org.ssmmaven.dao.UserMapper;
import org.ssmmaven.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkLogin(String userName, String password) {
        User user = userMapper.checkLogin(userName, password);
        return user;
    }
}
