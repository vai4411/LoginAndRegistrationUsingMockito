/************************************************************************
 * @purpose : DTOUtil Use For Conversion Of DTO To Model And Model To DTO
 * @author : Vaibhav Patil
 ************************************************************************/
package com.bl.loginmock.util;

import com.bl.loginmock.dto.LoginDTO;
import com.bl.loginmock.dto.UserDTO;
import com.bl.loginmock.model.Login;
import com.bl.loginmock.model.User;

public class DTOUtil {

    /**+
     * @purpose : Convert User To User DTO
     * @param user
     * @return : User DTO
     */
    public static UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    /**+
     * @purpose : Convert User DTO To User
     * @param userDTO
     * @return : User
     */
    public static User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    /**+
     * @purpose : Convert Login To Login DTO
     * @param login
     * @return : Login DTO
     */
    public static LoginDTO entityToDTO(Login login) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(login.getUserName());
        loginDTO.setPassword(login.getPassword());
        return loginDTO;
    }


    /**+
     * @purpose : Convert Login DTO To Login
     * @param loginDTO
     * @return : Login
     */
    public static Login dtoToEntity(LoginDTO loginDTO) {
        Login login = new Login();
        login.setUserName(loginDTO.getUserName());
        login.setPassword(loginDTO.getPassword());
        return login;
    }


}
