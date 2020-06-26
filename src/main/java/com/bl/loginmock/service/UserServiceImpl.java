package com.bl.loginmock.service;

import com.bl.loginmock.model.Login;
import com.bl.loginmock.model.User;
import com.bl.loginmock.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository repository;

    @Override
    public boolean loginStatus(Login login) {
        User user = (login != null && !ObjectUtils.isEmpty(login.getUserName()) && !ObjectUtils.isEmpty(login.getPassword())) ?
                repository.findById(login.getUserName()).orElse(null) : null;
            return user != null && login.getPassword().equals(user.getPassword());
    }
}
