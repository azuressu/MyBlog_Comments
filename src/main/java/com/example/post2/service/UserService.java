package com.example.post2.service;

import com.example.post2.dto.SignupRequestDto;
import com.example.post2.dto.StatusResponseDto;
import com.example.post2.entity.MyBlogErrorCode;
import com.example.post2.entity.User;
import com.example.post2.entity.UserRoleEnum;
import com.example.post2.exception.MyBlogException;
import com.example.post2.jwt.JwtUtil;
import com.example.post2.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ADMIN_TOKEN
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    public StatusResponseDto signup(HttpServletResponse res, SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        log.info(username);

        String password = passwordEncoder.encode(requestDto.getPassword());

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new MyBlogException(MyBlogErrorCode.IN_USED_USERNAME, null);
        }

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (!requestDto.getAdminToken().isBlank()) {
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new MyBlogException(MyBlogErrorCode.WRONG_ADMIN_TOKEN, null);
            }
            // 수동으로 admin의 값을 true로 설정해줌
            requestDto.setAdmin(true);
            role = UserRoleEnum.ADMIN;
        }

        // 사용자 등록
        User user = new User(username, password, role);
        userRepository.save(user);

        StatusResponseDto statusResponseDto = new StatusResponseDto();
        statusResponseDto.setMsg("회원가입 성공");
        statusResponseDto.setStatusCode(200);

        return statusResponseDto;
    }
}