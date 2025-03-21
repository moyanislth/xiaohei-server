package com.lth.controller;

import com.lth.pojo.DTO.UserDTO;
import com.lth.util.JwtUtil;
import com.lth.util.Md5Encryption;
import com.lth.util.Response;
import com.lth.pojo.User;
import com.lth.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
    * 登陆要求：
    *   用户名密码对应
    */
    @PostMapping("/login")
    public Response<Object> login(String username, String password) throws UnsupportedEncodingException {

        User user = userService.findUserByUsername(username);
        if (user == null || !user.getPassword().equals(Md5Encryption.generateMD5(password))) {
            return new Response<>().fail("用户名或密码错误");
        }

        // 生成token
        Map<String,Object> map = new HashMap<>();
        map.put("userId",user.getId());
        map.put("username",username);

        String token = JwtUtil.genToken(map);

        return new Response<>().success(token);
    }

    /**
    * 注册要求：
    *   用户名唯一
    *   邮箱唯一
    */
    @PostMapping("/register")
    public Response<Object> register(@Validated User user) throws UnsupportedEncodingException {


        // 验证用户是否存在
        User user1 = userService.findUserByUsername(user.getUsername());
        if (user1 != null) {
            return new Response<>().fail("用户已存在");
        }
        // 验证邮箱是否存在
        User user2 = userService.findUserByEmail(user.getEmail());
        if (user2 != null) {
            return new Response<>().fail("邮箱已存在");
        }

        // 密码加密存储
        user.setPassword(Md5Encryption.generateMD5(user.getPassword()));

        try {
            userService.addUser(user);
        } catch (Exception e) {
            return new Response<>().fail(e.getMessage());
        }

        return new Response<>().success("注册成功");
    }

    /**调试用：
    *   获取所有用户信息
    */
    @GetMapping("/info")
    public Response<Object> userlist() {

        List<User> users = userService.userlist();

        return new Response<>().success(users);
    }

    /**
    * 获取特定用户信息
    */
    @GetMapping("/users/{userId}")
    public Response<Object> getUser(@PathVariable("userId") Integer userId) {

        User user = userService.findUserById(userId);

        return new Response<>().success(user);
    }

    /**
    * 更新用户信息
    */
    @PutMapping("/users/{userId}")
    public Response<Object> updateUser(@PathVariable("userId") Integer userId, @Validated UserDTO userDTO) {

        User user = null;
        try {
            user = userService.updateUser(userId, userDTO);
        } catch (Exception e) {
            return new Response<>().fail(e.getMessage());
        }

        return new Response<>().success(user);
    }

    /**
     * 删除用户/销号
     */
    @DeleteMapping("/users/{userId}")
    public Response<Object> deleteUser(@PathVariable("userId") Integer userId) {

        try {
            userService.deleteUser(userId);
        } catch (Exception e) {
            return new Response<>().fail(e.getMessage());
        }

        return new Response<>().success("删除成功");
    }
}
