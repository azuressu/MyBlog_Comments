package com.example.post2.controller;

import com.example.post2.dto.CommentRequestDto;
import com.example.post2.dto.CommentResponseDto;
import com.example.post2.dto.PostRequestDto;
import com.example.post2.dto.StatusResponseDto;
import com.example.post2.security.UserDetailsImpl;
import com.example.post2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {


    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 작성
    @PostMapping("/post/{id}/comment")
    public CommentResponseDto createComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.createComment(id, requestDto, userDetails);
    }

    // 댓글 수정
    @PutMapping("/post/{id}/comment/{commentid}")
    public CommentResponseDto updateComment(@PathVariable Long id, @PathVariable Long commentid, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.updateCommnet(id, commentid, requestDto, userDetails);
    }

    @DeleteMapping("/post/{id}/comment/{commentid}")
    public StatusResponseDto deleteComment(@PathVariable Long id, @PathVariable Long commentid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.deleteComment(id, commentid, userDetails);
    }
}
