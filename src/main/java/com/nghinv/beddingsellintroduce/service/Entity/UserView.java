package com.nghinv.beddingsellintroduce.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "userGetUserNameAndUserLogin")
public class UserView {

    public UserView() {

    }
    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserLogin")
    private String userLogin;

    @Column(name = "IsAdmin")
    private Boolean isAdmin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

}
