package com.lth.service.impl;

import com.lth.converter.UserConverter;
import com.lth.mapper.UserMapper;
import com.lth.pojo.DTO.UserDTO;
import com.lth.pojo.User;
import com.lth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserConverter userConverter;

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

    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public User updateUser(Integer userId, UserDTO userDTO) {

        User user = userMapper.findUserById(userId);

        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setNickname(userDTO.getNickname());
        user.setPassword(userDTO.getPassword());

       userMapper.updateUser(user);

        user = userMapper.findUserById(userId);
        return user;
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

}
