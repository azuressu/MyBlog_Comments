package com.example.post2.controller;

import com.example.post2.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post/{id}")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
//
//    @PostMapping("/comment")
//
//    @PutMapping("/comment/{id}")
//
//
//    @DeleteMapping("/comment/{id}")
}
