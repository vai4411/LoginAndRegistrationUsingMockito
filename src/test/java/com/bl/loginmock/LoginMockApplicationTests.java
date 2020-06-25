package com.bl.loginmock;

import com.bl.loginmock.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginMockApplicationTests {

    @InjectMocks
    LoginController loginController;

    @Test
    void contextLoads() {
    }

}
