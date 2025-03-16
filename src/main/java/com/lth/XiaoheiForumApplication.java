package com.lth;

import com.lth.controller.UserController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
@MapperScan("com.lth.mapper") // 指定 Mapper 接口所在的包
public class XiaoheiForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoheiForumApplication.class, args);
    }

}
