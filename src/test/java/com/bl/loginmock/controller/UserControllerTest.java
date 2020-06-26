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
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    IUserService userService;

    @Before
    public void init() {
        ReflectionTestUtils.setField(userController, "userService", userService);
    }

    @Test
    public void loginStatus_WhenPassLoginDTO_ShouldReturnTrue() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("rp");
        loginDTO.setPassword("rp@123");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(true);
        ResponseEntity<Boolean> result = userController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertTrue(result.getBody());
    }

    @Test
    public void loginStatus_WhenPassLoginDTO_ShouldReturnFalse() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("rp");
        loginDTO.setPassword("rp@123");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

}

