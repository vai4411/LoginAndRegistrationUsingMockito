/**********************************************************************
 * @purpose : Login Model Use For Convert Login Data Into Object
 * @author : Vaibhav Patil
 **********************************************************************/
package com.bl.loginmock.model;

public class Login {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
