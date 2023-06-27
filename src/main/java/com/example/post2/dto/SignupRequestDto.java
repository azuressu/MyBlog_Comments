package com.example.post2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    /* Username과 Password를 Client에서 전달받는다
     * username은 최소 4자 이상, 10자 이하이며 알파벳 소문자 (a-z), 숫자 (0-9)로 구성
     * password는 최소 8자 이상, 15자 이하이며 알파벳 대소문자(a-z, A-Z), 숫자(0-9)로 구성
     * DB에 중복된 username이 없다면 회원을 저장하고, Client로 성공했다는 메시지와 상태코드를 반환한다 */

    @NotBlank
    @Size(min = 4, max = 10)
    @Pattern(regexp = "^[a-z0-9]*$", message = "알파벳 소문자와 숫자만 입력 가능합니다")
    private String username;

    @NotBlank
    @Size(min = 8, max = 15)
    @Pattern(regexp = "^[A-Za-z0-9@$!%*?&]*$", message = "알파벳 대소문자와 숫자, 특수문자만 입력 가능합니다")
    private String password;

    private boolean admin = false;
    private String adminToken = "";

}

