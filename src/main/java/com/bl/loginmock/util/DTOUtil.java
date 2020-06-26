package com.bl.loginmock.util;

import com.bl.loginmock.dto.LoginDTO;
import com.bl.loginmock.dto.UserDTO;
import com.bl.loginmock.model.Login;
import com.bl.loginmock.model.User;

public class DTOUtil {

    public static UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public static User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public static LoginDTO entityToDTO(Login login) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(login.getUserName());
        loginDTO.setPassword(login.getPassword());
        return loginDTO;
    }


    public static Login dtoToEntity(LoginDTO loginDTO) {
        Login login = new Login();
        login.setUserName(loginDTO.getUserName());
        login.setPassword(loginDTO.getPassword());
        return login;
    }


}
