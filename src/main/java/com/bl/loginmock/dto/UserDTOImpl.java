package com.bl.loginmock.dto;

import com.bl.loginmock.model.User;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserDTOImpl {

    public UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public List<UserDTO> entityToDTO(List<User> user) {
        return user.stream().map(m -> entityToDTO(m)).collect(Collectors.toList());
    }

    public User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public List<User> dtoToEntity(List<UserDTO> userDTO) {
        return userDTO.stream().map(m -> dtoToEntity(m)).collect(Collectors.toList());
    }
}
