package com.lth.mapper;

import com.lth.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert("INSERT INTO user(username, password, nickname, email) VALUES(#{username}, #{password}, #{nickname}, #{email})")
    void addUser(User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findUserByUsername(String username);

    @Select("SELECT * FROM user WHERE email = #{email}")
    User findUserByEmail(String email);
}
