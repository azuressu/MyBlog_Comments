package com.example.post2.exception;

import com.example.post2.entity.MyBlogErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)        // response로 들어가는 에러 코드를 400으로 통일
public class MyBlogException extends RuntimeException{ // 실행 중에 발생한 예외이다 !

    private final MyBlogErrorCode errorCode;


    public MyBlogException(MyBlogErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorMessage(), cause, false, false);
        this.errorCode = errorCode;
    }

    public MyBlogErrorCode getErrorCode() { return this.errorCode; }
}
