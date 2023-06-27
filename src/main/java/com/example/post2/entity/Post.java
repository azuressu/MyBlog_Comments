package com.example.post2.entity;

import com.example.post2.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto_increase
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "contents", nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto) {
        // 제목, 작성 내용을 수정
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
        comment.setPost(this);
    }
}
