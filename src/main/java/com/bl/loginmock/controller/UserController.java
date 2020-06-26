package com.bl.loginmock.controller;

import com.bl.loginmock.dto.LoginDTO;
import com.bl.loginmock.dto.UserDTO;
import com.bl.loginmock.model.Login;
import com.bl.loginmock.model.User;
import com.bl.loginmock.service.IUserService;
import com.bl.loginmock.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginProcess(@RequestBody LoginDTO loginDTO) {
        Login login = DTOUtil.dtoToEntity(loginDTO);
        return new  ResponseEntity<> (userService.loginStatus(login),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerProcess(@RequestBody UserDTO userDTO) {
        User user = DTOUtil.dtoToEntity(userDTO);
        return new  ResponseEntity<> (userService.registerStatus(user),HttpStatus.OK);
    }
}