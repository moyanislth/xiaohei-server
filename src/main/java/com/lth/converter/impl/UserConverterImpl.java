package com.lth.converter.impl;

import com.lth.converter.UserConverter;
import com.lth.pojo.DTO.UserDTO;
import com.lth.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setNickname(userDTO.getNickname());

        return user;
    }

    @Override
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setNickname(user.getNickname());

        return userDTO;
    }
}

