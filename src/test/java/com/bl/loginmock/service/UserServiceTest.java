package com.bl.loginmock.service;

import com.bl.loginmock.model.Login;
import com.bl.loginmock.model.User;
import com.bl.loginmock.repository.IUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    IUserRepository userRepository;

    @Before
    public void init() {
        ReflectionTestUtils.setField(userService,"repository",userRepository);
    }

    @Test
    public void loginStatus_WhenUserNameAndPasswordMatches_ShouldReturnTrue() {
        Login login = new Login();
        login.setUserName("rp");
        login.setPassword("rp@123");
        User user = new User();
        user.setUserName("rp");
        user.setPassword("rp@123");
        user.setEmail("rp@gmail.com");
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(java.util.Optional.of(user));
        boolean result = userService.loginStatus(login);
        Assert.assertTrue(result);
    }

    @Test
    public void loginStatus_WhenUserNameAndPasswordNotMatches_ShouldReturnFalse() {
        Login login = new Login();
        login.setUserName("rp");
        login.setPassword("rp@123");
        User user = new User();
        user.setUserName("rp");
        user.setPassword("dm@123");
        user.setEmail("rp@gmail.com");
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(java.util.Optional.of(user));
        boolean result = userService.loginStatus(login);
        Assert.assertFalse(result);
    }
}
