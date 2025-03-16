package com.lth.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    private int id;
    private String owner;
    private int postId;
    private int commentId;
    private int like;
    private Timestamp createTime;
}
