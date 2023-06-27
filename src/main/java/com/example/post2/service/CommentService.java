package com.example.post2.service;

import com.example.post2.dto.CommentRequestDto;
import com.example.post2.dto.CommentResponseDto;
import com.example.post2.dto.PostRequestDto;
import com.example.post2.dto.StatusResponseDto;
import com.example.post2.entity.Comment;
import com.example.post2.entity.Post;
import com.example.post2.repository.CommentRepository;
import com.example.post2.repository.PostRepository;
import com.example.post2.security.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {


    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    public CommentResponseDto createComment(Long id, CommentRequestDto requestDto, UserDetailsImpl userDetails) {
        Post post = findPost(id);

        // 작성한 댓글
        Comment comment = new Comment(requestDto);
        comment.setUser(userDetails.getUser());
        comment.setPost(post);
        commentRepository.save(comment);

        // 게시글의 댓글 리스트에 댓글 추가하기
        post.addComment(comment);

        // 정렬한 내용을 할 때마다 넣어주어야 하는가 ..? 아니면 그냥 정렬하기만 하면 되는건가 ?

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }

    @Transactional
    public CommentResponseDto updateCommnet(Long id, Long commentid, CommentRequestDto requestDto, UserDetailsImpl userDetails) {
        // 해당 게시글이 있는지 확인
        Post post = findPost(id);
        // 해당 댓글이 있는지 확인
        Comment comment = findComment(commentid);
        // 댓글 작성자와 Token의 작성자가 같은지 확인
        if (comment.getUser().getUsername().equals(userDetails.getUsername())) {
            // 있으면 댓글 내용 업데이트
            comment.update(requestDto);
            // ResponseDto에 내용 담아서 반환
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            return commentResponseDto;
        } else {
            return null;
        }

    }

    public StatusResponseDto deleteComment(Long id, Long commentid, UserDetailsImpl userDetails) {
        Post post = findPost(id);
        Comment comment = findComment(commentid);

        if (comment.getUser().getUsername().equals(userDetails.getUsername())) {
            commentRepository.delete(comment);

            StatusResponseDto statusResponseDto = new StatusResponseDto();
            statusResponseDto.setMsg("댓글 삭제 성공");
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

    private Comment findComment(Long commentid) {
        return commentRepository.findById(commentid).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다"));
    }
}
