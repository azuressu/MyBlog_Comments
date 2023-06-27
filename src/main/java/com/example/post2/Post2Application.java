package com.example.post2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableJpaAuditing        // 날짜 사용을 위해서 JpaAuditing 기능 사용을 알려줌
@SpringBootApplication
public class Post2Application {

    public static void main(String[] args) {
        SpringApplication.run(Post2Application.class, args);
    }

}
