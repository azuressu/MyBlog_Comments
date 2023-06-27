package com.example.post2.dto;

import com.example.post2.entity.Comment;
import com.example.post2.service.CommentService;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private Long id;
    private String username;
    private String commentcontents;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getUser().getUsername();
        this.commentcontents = comment.getCommentcontents();
        this.createTime = comment.getCreateTime();
        this.modifyTime = comment.getModifyTime();
    }
}
