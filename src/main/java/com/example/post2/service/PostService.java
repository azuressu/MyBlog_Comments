package com.example.post2.service;

import com.example.post2.dto.CommentResponseDto;
import com.example.post2.dto.PostRequestDto;
import com.example.post2.dto.PostResponseDto;
import com.example.post2.dto.StatusResponseDto;
import com.example.post2.entity.Post;
import com.example.post2.repository.CommentRepository;
import com.example.post2.repository.PostRepository;
import com.example.post2.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto, UserDetailsImpl userDetails) {
        Post post = new Post();
        post.setUser(userDetails.getUser());
        post.setTitle(requestDto.getTitle());
        post.setContents(requestDto.getContents());

        // DB에 저장
        Post savePost = postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(savePost);
        return postResponseDto;
    }

    public List<PostResponseDto> getPosts() {
        commentRepository.findAllByOrderByCreateTimeDesc().stream().map(CommentResponseDto::new).toList();
        return postRepository.findAllByOrderByCreateTimeDesc().stream().map(PostResponseDto::new).toList();
    }

    public PostResponseDto getOnePost(Long id) {
        Post post = findPost(id);
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, UserDetailsImpl userDetails) {
        Post post = findPost(id);
        // 해당 게시글을 작성한 작성자 이거나, 권한이 ADMIN인 경우는 삭제 가능
        if (post.getUser().getUsername().equals(userDetails.getUsername())
                && userDetails.getUser().getRole().getAuthority().equals("ADMIN")) {
            post.update(requestDto);
            PostResponseDto postResponseDto = new PostResponseDto(post);
            return postResponseDto;
        } else {
            return null;
        }
    }

    public StatusResponseDto deletePost(Long id, UserDetailsImpl userDetails) {
        Post post = findPost(id);
        // 해당 게시글을 작성한 작성자 이거나, 권한이 ADMIN인 경우는 삭제 가능
        if (userDetails.getUsername().equals(post.getUser().getUsername())
                && userDetails.getUser().getRole().getAuthority().equals("ADMIN")) {
            postRepository.delete(post);

            StatusResponseDto statusResponseDto = new StatusResponseDto();
            statusResponseDto.setMsg("게시글 삭제 성공");
            statusResponseDto.setStatusCode(200);
            return statusResponseDto;
        } else {
            return null;
        }
    }

    // 해당 포스트를 찾아서 반환
    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));
    }

}
