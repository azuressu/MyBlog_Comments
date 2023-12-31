package com.example.post2.service;

import com.example.post2.dto.CommentRequestDto;
import com.example.post2.dto.CommentResponseDto;
import com.example.post2.dto.StatusResponseDto;
import com.example.post2.entity.Comment;
import com.example.post2.entity.Post;
import com.example.post2.entity.User;
import com.example.post2.repository.CommentRepository;
import com.example.post2.repository.PostRepository;
import com.example.post2.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
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

    // 댓글 작성
    public CommentResponseDto createComment(Long id, CommentRequestDto requestDto, User user) {
        Post post = findPost(id);

        // 작성한 댓글
        Comment comment = new Comment(requestDto);
        comment.setUser(user);
        comment.setPost(post);
        commentRepository.save(comment);

        // 게시글의 댓글 리스트에 댓글 추가하기
        post.addComment(comment);

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }

    @Transactional
    public CommentResponseDto updateCommnet(Long id, Long commentid, CommentRequestDto requestDto, User user, HttpServletResponse res) {
        // 해당 게시글이 있는지 확인
        findPost(id);
        // 해당 댓글이 있는지 확인
        Comment comment = findComment(commentid);
        // 해당 댓글을 작성한 작성자 이거나, 권한이 ADMIN인 경우 댓글 수정 가능
        if (comment.getUser().getUsername().equals(user.getUsername())
                || user.getRole().getAuthority().equals("ROLE_ADMIN")) {
            // 있으면 댓글 내용 업데이트
            comment.update(requestDto);
            // ResponseDto에 내용 담아서 반환
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            return commentResponseDto;
        } else {
            try {
                status(400, "작성자만 삭제/수정할 수 있습니다.", res);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } // else
    }

    public StatusResponseDto deleteComment(Long id, Long commentid, User user) {
        // 해당 게시글이 있는지 확인
        findPost(id);
        // 해당 댓글이 있는지 확인
        Comment comment = findComment(commentid);
        // 해당 댓글을 작성한 작성자 이거나, 권한이 ADMIN인 경우 댓글 삭제 가능
        if (comment.getUser().getUsername().equals(user.getUsername())
                || user.getRole().getAuthority().equals("ROLE_ADMIN")) {
            // 있으면 댓글 삭제
            commentRepository.delete(comment);
            // 상태 ResponseDto에 담아서 반환
            StatusResponseDto statusResponseDto = new StatusResponseDto();
            statusResponseDto.setMessage("댓글 삭제 성공");
            statusResponseDto.setStatusCode(200);
            return statusResponseDto;
        } else {
            StatusResponseDto statusResponseDto = new StatusResponseDto();
            statusResponseDto.setMessage("작성자만 삭제/수정할 수 있습니다.");
            statusResponseDto.setStatusCode(400);
            return statusResponseDto;
        }
    }

    // 해당 포스트를 찾아서 반환
    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));
    }
    // 해당 댓글을 찾아서 반환
    private Comment findComment(Long commentid) {
        return commentRepository.findById(commentid).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다"));
    }

    // 상태 코드 반환하기
    public void status(int statusCode, String message, HttpServletResponse response) throws IOException {
        // 응답 데이터를 JSON 형식으로 생성
        String jsonResponse = "{\"statusCode\": " + statusCode + ", \"message\": \"" + message + "\"}";

        // Content-Type 및 문자 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // PrintWriter를 사용하여 응답 데이터 전송
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
    }
}
