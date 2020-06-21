package com.bjsxt.service.impl;

import com.bjsxt.mapper.UserMapper;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper usersMapper;
    @Override
    public void addUsers(User user) {
         usersMapper.insert(user);
    }
}
