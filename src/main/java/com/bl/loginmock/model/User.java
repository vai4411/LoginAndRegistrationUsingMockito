package com.bl.loginmock.model;

public class User {

    private String username;
    private String password;
    private String email;
    private int id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("username: " + username);
        this.username = username;
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
