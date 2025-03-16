package com.lth.service;

import com.lth.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //    所有用户信息
    List<User> userlist();
    //    添加用户
    void addUser(User user);
    //    通过用户名查找用户
    User findUserByUsername(String username);
    //    通过邮箱查找用户
    User findUserByEmail(String email);
}
