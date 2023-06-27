package com.example.post2.service;

import com.example.post2.dto.SignupRequestDto;
import com.example.post2.dto.StatusResponseDto;
import com.example.post2.entity.User;
import com.example.post2.entity.UserRoleEnum;
import com.example.post2.jwt.JwtUtil;
import com.example.post2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

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

    public StatusResponseDto signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        log.info(username);
        String inputpassword = requestDto.getPassword();

        if (Pattern.matches("^[A-Za-z\\d@$!%*?&]{8,15}$", inputpassword)) { // 특수문자도 추가
            String password = passwordEncoder.encode(requestDto.getPassword());

            // 회원 중복 확인
            Optional<User> checkUsername = userRepository.findByUsername(username);
            if (checkUsername.isPresent()) {
                throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
            }

            // 사용자 ROLE 확인 - isAdmin에서 문제가있는듯하다 ..
            UserRoleEnum role = UserRoleEnum.USER;
            if (!requestDto.getAdminToken().isBlank()) {
                if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                    throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
                }
                // 수동으로 admin의 값을 true로 설정해줌
                requestDto.setAdmin(true);
                role = UserRoleEnum.ADMIN;
            }

            // 사용자 등록
            User user = new User(username, password, role);
            userRepository.save(user);

        } else {
            System.out.println("비밀번호 패턴에 맞지 않습니다.");
        }

        StatusResponseDto statusResponseDto = new StatusResponseDto();
        statusResponseDto.setMsg("회원가입 성공");
        statusResponseDto.setStatusCode(200);

        return statusResponseDto;

    }
}