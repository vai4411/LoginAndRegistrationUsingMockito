package com.bl.loginmock.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @Column(unique = true,name = "userName")
    public String userName;
    private String password;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println("userName: " + userName);
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
