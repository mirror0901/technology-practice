package com.mirror.ouath2.authserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AuthServerApplicationTests {

    @Test
    void contextLoads() {

        String encode = new BCryptPasswordEncoder().encode("123");
        System.out.println(encode);

    }

}
