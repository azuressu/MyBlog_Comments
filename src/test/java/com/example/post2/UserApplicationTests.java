package com.example.post2;

import com.example.post2.dto.SignupRequestDto;
import com.example.post2.entity.User;
import com.example.post2.entity.UserRoleEnum;
import com.example.post2.repository.UserRepository;
import com.example.post2.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.regex.Pattern;

@SpringBootTest
public class UserApplicationTests {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Test
    @DisplayName("Admin 회원가입")
    void test1() {
        SignupRequestDto signupRequestDto = new SignupRequestDto();
        signupRequestDto.setAdminToken("AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC");
        signupRequestDto.setUsername("admin");
        signupRequestDto.setPassword("admin1234");

        String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

        String username = signupRequestDto.getUsername();
        System.out.println(username);

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (signupRequestDto.isAdmin()) {
            if (!ADMIN_TOKEN.equals(signupRequestDto.getAdminToken())) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        System.out.println(role);


    }
}
