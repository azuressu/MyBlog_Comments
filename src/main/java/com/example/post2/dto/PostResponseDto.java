package com.example.post2.dto;

import com.example.post2.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PostResponseDto {

    private Long id;
    private String username;
    private String contents;
    private String title;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private List<CommentResponseDto> commentList = new ArrayList<>();

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUser().getUsername();
        this.contents = post.getContents();
        this.createTime = post.getCreateTime();
        this.modifyTime = post.getModifyTime();

        // post에 저장된 commentList Comment들을 하나씩 저장해준다
        if (post.getCommentList().size() > 0) {
            for (int i=post.getCommentList().size()-1; i>=0; i--) {
                this.commentList.add(new CommentResponseDto(post.getCommentList().get(i)));
            }
        }
    }
}