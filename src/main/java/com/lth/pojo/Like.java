package com.lth.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Like {
    private int id;
    private int userId;
    private int postId;
    private int commentId;
    private Timestamp createTime;
}
