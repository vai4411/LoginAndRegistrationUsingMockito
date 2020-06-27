package com.bl.loginmock.repository;

import com.bl.loginmock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{

    @Query("SELECT a FROM User a WHERE a.userName = ?1 AND a.password = ?2")
    List<User> findByFirstNameAndLastName(String userName, String password);

}
