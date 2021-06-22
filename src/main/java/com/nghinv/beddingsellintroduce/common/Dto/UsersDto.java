package com.nghinv.beddingsellintroduce.common.Dto;

import com.nghinv.beddingsellintroduce.common.Annotation.PhoneAnnotation;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class UsersDto implements Serializable {

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserLogin() {
        return UserLogin;
    }

    public void setUserLogin(String userLogin) {
        UserLogin = userLogin;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private int UserId;

    @NotNull
    private String UserName;

    @NotNull
    @Length(min = 5, max = 10)
    private String UserLogin;

    @NotNull
    private String Password;

    private int SortOrder;

    private String ImageFile;

    private String Address;

    private int Sex;

    private String Email;

    private String Tel;

    @PhoneAnnotation(message = "Phone Number is invalid")
    private String Phone;

    private boolean IsAdmin;

    private String Notes;

}
