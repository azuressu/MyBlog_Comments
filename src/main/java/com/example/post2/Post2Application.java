package com.example.post2;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.time.ZoneId;
import java.util.TimeZone;

@EnableJpaAuditing        // 날짜 사용을 위해서 JpaAuditing 기능 사용을 알려줌
@SpringBootApplication
public class Post2Application {

    @PostConstruct
    public void setDefaultTimezone() {
        // DB에는 고정된 타임존을 지정하여 삽입하는 것이 일반적이므로, 해당 어플리케이션의 타임존을 UTC로 고정
        // -> default에는 해당 pc의 타임존 세팅을 따라간다.
        // 일반적으로 +09:00(KST)인데, 한국에서만 서비스하는 백엔드의 경우에는 타임존 세팅이 크게 상관 없으나,
        // 여러 국가에서 서비스를 해야하는 경우에는 타임존을 무조건 통일해주어야 한다.
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("UTC")));
    }

    public static void main(String[] args) {
        SpringApplication.run(Post2Application.class, args);
    }

}
