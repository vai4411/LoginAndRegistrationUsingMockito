package com.bl.loginmock.service;

import com.bl.loginmock.model.User;
import com.bl.loginmock.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
