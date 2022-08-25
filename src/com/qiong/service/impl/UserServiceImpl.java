package com.qiong.service.impl;

import com.qiong.mapper.UserMapper;
import com.qiong.pojo.User;
import com.qiong.service.UserService;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public User userLoginService(String uname, String pwd) {
        return userMapper.userLoginMapper(uname, pwd);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
