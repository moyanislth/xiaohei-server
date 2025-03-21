package com.lth.service;

import com.lth.pojo.DTO.UserDTO;
import com.lth.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    //    通过id查找用户
    User findUserById(Integer userId);
    //    更新用户信息
    @Transactional
    User updateUser(Integer userId, UserDTO userDTO);

    void deleteUser(Integer userId);
}
