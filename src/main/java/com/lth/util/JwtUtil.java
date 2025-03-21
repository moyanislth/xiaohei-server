package com.lth.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Date;
import java.util.Map;

@Slf4j
@Configuration
@ComponentScan(basePackages = "com.lth")
@PropertySource(value = "classpath:application.yml")
public class JwtUtil {

    private static String key; // 静态字段
    private static long expiration; // 静态字段

    @Value("${jwt.key}")
    private String tempKey; // 临时字段，用于注入配置值

    @Value("${jwt.expiration}")
    private long tempExpiration; // 临时字段，用于注入配置值

    // 在 Spring 初始化完成后，将配置值赋值给静态字段
    @PostConstruct
    public void init() {
        key = tempKey;
        expiration = tempExpiration;
    }
	//接收业务数据,生成token并返回,数据存储在claims中用map存储
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                // 设置过期时间为12小时   ms
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(Algorithm.HMAC256(key));
    }

	//接收token,验证token,并返回业务数据
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(key))
                .build()
                .verify(token)
                .getClaim("claims")  // 获取业务数据
                .asMap();  // 转换为map
    }



}
