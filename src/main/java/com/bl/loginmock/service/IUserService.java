/**********************************************************************
 * @purpose : IUserService Interface Use For Mange Service Operations
 * @author : Vaibhav Patil
 **********************************************************************/
package com.bl.loginmock.service;

import com.bl.loginmock.model.Login;
import com.bl.loginmock.model.User;

public interface IUserService {
    boolean loginStatus(Login login);
    boolean registerStatus(User user);
}
