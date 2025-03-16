package com.lth.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Post {

    private int id;
    private String owner;
    private String cover;
    private String title;
    private String content;
    private Timestamp createTime;
    private String partition;
    private int likeCount;
    private int commentCount;
    private int status;

}
