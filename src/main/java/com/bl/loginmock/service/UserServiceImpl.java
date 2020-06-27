/**********************************************************************
 * @purpose : UserServiceImpl Use For Business Logic
 * @author : Vaibhav Patil
 **********************************************************************/
package com.bl.loginmock.service;

import com.bl.loginmock.model.Login;
import com.bl.loginmock.model.User;
import com.bl.loginmock.repository.IUserRepository;
import com.bl.loginmock.util.DateAndTimeFormatUtil;
import com.bl.loginmock.util.GenerateUniqueId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository repository;

    /**+
     * @purpose : Used For Check UserName And Password Matches To Database Entries Or Not
     * @param login
     * @return : Boolean Status
     */
    @Override
    public boolean loginStatus(Login login) {
        List<User> userList = repository.findByFirstNameAndLastName(login.getUserName(),login.getPassword());
        System.out.println(userList);
            return !ObjectUtils.isEmpty(userList);
    }

    /**+
     * @purpose : Used For Validate The Data Of User And Store It
     * @param user
     * @return : Boolean Status
     */
    @Override
    public boolean registerStatus(User user) {
        user.setId(GenerateUniqueId.getUniqueId());
        user.setDate(DateAndTimeFormatUtil.currentDateAndTime());
        User user1 = (user != null && !ObjectUtils.isEmpty(user.getUserName()) &&
                !ObjectUtils.isEmpty(user.getPassword()) && !ObjectUtils.isEmpty(user.getEmail())) ?
                repository.save(user) : null;
        return user1 != null;
    }
}
