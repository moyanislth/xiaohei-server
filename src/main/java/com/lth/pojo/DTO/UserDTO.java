package com.lth.pojo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @Size(min = 6, max = 12, message = "用户名长度必须在6到12个字符之间")
    private String username;

    @Size(max = 12, message = "昵称长度必须在12个字符之内")
    private String nickname;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Size(min = 6, max = 100, message = "密码长度必须在6到100个字符之间")
    private String password;
}
