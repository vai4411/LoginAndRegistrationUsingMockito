package com.bl.loginmock.controller;

import com.bl.loginmock.dto.LoginDTO;
import com.bl.loginmock.dto.UserDTO;
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
    public void loginStatus_WhenLoginCredentialsCorrect_ShouldReturnTrue() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("rp");
        loginDTO.setPassword("rp@123");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(true);
        ResponseEntity<Boolean> result = userController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertTrue(result.getBody());
    }

    @Test
    public void loginStatus_WhenLoginCredentialsIncorrect_ShouldReturnFalse() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("dm");
        loginDTO.setPassword("dm@123");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

    @Test
    public void loginStatus_WhenLoginDetailsIsNull_ShouldReturnFalse() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("");
        loginDTO.setPassword("");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

    @Test
    public void loginStatus_WhenUserNameIsNull_ShouldReturnFalse() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("");
        loginDTO.setPassword("dm@123");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

    @Test
    public void loginStatus_WhenPasswordIsNull_ShouldReturnFalse() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("dm");
        loginDTO.setPassword("");
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.loginProcess(loginDTO);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

    @Test
    public void registerProcessStatus_WhenValidCredentials_ShouldReturnTrue() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("rp");
        userDTO.setPassword("rp@123");
        userDTO.setEmail("rp@gmail.com");
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(true);
        ResponseEntity<Boolean> result = userController.registerProcess(userDTO);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertTrue(result.getBody());
    }

    @Test
    public void registerProcessStatus_WhenUserNameIsNull_ShouldReturnFalse() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("");
        userDTO.setPassword("rp@123");
        userDTO.setEmail("rp@gmail.com");
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.registerProcess(userDTO);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

    @Test
    public void registerProcessStatus_WhenPasswordIsNull_ShouldReturnFalse() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("rp");
        userDTO.setPassword("");
        userDTO.setEmail("rp@gmail.com");
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.registerProcess(userDTO);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

    @Test
    public void registerProcessStatus_WhenEmailIsNull_ShouldReturnFalse() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("rp");
        userDTO.setPassword("rp@123");
        userDTO.setEmail("");
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = userController.registerProcess(userDTO);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertFalse(result.getBody());
    }

}

