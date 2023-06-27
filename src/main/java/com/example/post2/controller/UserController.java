package com.example.post2.controller;

import com.example.post2.dto.SignupRequestDto;
import com.example.post2.dto.StatusResponseDto;
import com.example.post2.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    public StatusResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }
    /* sign up 할 때, HttpservletResponse res, (res.setStatus), SignupRequestDto 를 매개변수로
     * 받아와서, 중복 확인하고 (Service로 넘겨라)
     * 맞으면, return 상태값 & 메세지 */
}