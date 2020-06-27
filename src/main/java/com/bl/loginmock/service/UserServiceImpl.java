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

    @Override
    public boolean loginStatus(Login login) {
        List<User> userList = repository.findByFirstNameAndLastName(login.getUserName(),login.getPassword());
        System.out.println(userList);
            return !ObjectUtils.isEmpty(userList);
    }

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
