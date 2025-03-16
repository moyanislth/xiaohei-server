package com.lth.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Size(min = 6, max = 12, message = "用户名长度必须在6到12个字符之间")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 100, message = "密码长度必须在6到100个字符之间")
    private String password;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "昵称不能为空")
    @Size(max = 12, message = "昵称长度必须在12个字符之内")
    private String nickname;

}
