package com.bl.loginmock.repository;

import com.bl.loginmock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface IUserRepository extends JpaRepository<User,String>{
}
