package com.bl.loginmock;

import com.bl.loginmock.controller.UserController;
import com.bl.loginmock.dto.LoginDTO;
import com.bl.loginmock.dto.UserDTO;
import com.bl.loginmock.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class LoginMockTest {

    @InjectMocks
    UserController userController;

    @Mock
    IUserService userService;

    MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(userController, "userService", userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    public void sendRequest_WhenLoginPass_ReturnTrue() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("vaibhav");
        loginDTO.setPassword("vai@123");
        ObjectMapper mapper = new ObjectMapper();
        String input = mapper.writeValueAsString(loginDTO);
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(input);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().bytes("true".getBytes()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void sendRequest_WhenLoginFails_dReturnFalse() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName("dm");
        loginDTO.setPassword("vai@123");
        ObjectMapper mapper = new ObjectMapper();
        String input = mapper.writeValueAsString(loginDTO);
        Mockito.when(userService.loginStatus(Mockito.any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(input);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().bytes("false".getBytes()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void sendRequest_WhenRegisterSuccessFul_ReturnTrue() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("vaibhav");
        userDTO.setPassword("vai@123");
        userDTO.setEmail("vai@gmail.com");
        ObjectMapper mapper = new ObjectMapper();
        String input = mapper.writeValueAsString(userDTO);
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(input);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().bytes("true".getBytes()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void sendRequest_WhenUserNameIsNull_dReturnFalse() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("");
        userDTO.setPassword("vai@123");
        userDTO.setEmail("vai@gmail.com");
        ObjectMapper mapper = new ObjectMapper();
        String input = mapper.writeValueAsString(userDTO);
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(input);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().bytes("false".getBytes()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void sendRequest_WhenPasswordIsNull_dReturnFalse() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("vaibhav");
        userDTO.setPassword("");
        userDTO.setEmail("vai@gmail.com");
        ObjectMapper mapper = new ObjectMapper();
        String input = mapper.writeValueAsString(userDTO);
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(input);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().bytes("false".getBytes()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void sendRequest_WhenEmailIsNull_dReturnFalse() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("vaibhav");
        userDTO.setPassword("vai@123");
        userDTO.setEmail("");
        ObjectMapper mapper = new ObjectMapper();
        String input = mapper.writeValueAsString(userDTO);
        Mockito.when(userService.registerStatus(Mockito.any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(input);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().bytes("false".getBytes()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
