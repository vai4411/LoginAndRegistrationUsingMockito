package com.bl.loginmock.controller;

import com.bl.loginmock.dto.LoginDTO;
import com.bl.loginmock.service.IUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    IUserService userService;

    @Before
    public void init() {
        ReflectionTestUtils.setField(loginController, "userService", userService);
    }

    @Test
    public void loginStatus_ShouldReturnTrue() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("rp");
        loginDTO.setPassword("rp@123");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(true);
        ResponseEntity<Boolean> result = loginController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertTrue(result.getBody());
    }
}

