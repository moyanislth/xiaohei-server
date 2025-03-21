package com.lth.converter;

import com.lth.pojo.DTO.UserDTO;
import com.lth.pojo.User;

public interface UserConverter {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}
