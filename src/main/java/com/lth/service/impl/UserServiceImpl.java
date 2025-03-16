package com.lth.service.impl;

import com.lth.mapper.UserMapper;
import com.lth.pojo.User;
import com.lth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> userlist() {
        return userMapper.getAllUsers();
    }

    @Override
    public void addUser(User user) {

        userMapper.addUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }
}
