package com.heima.model.comment.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CommentReplyDto {

    /**
     * 评论id
     */
    private String commentId;

    /**
     * 最小时间
     */
    private Date minDate;
}