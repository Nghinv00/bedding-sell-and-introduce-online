package com.nghinv.beddingsellintroduce.common.Dto;

import com.nghinv.beddingsellintroduce.common.Annotation.PhoneAnnotation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
public class UsersDto implements Serializable {

    public UsersDto() {
//        action = false;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public boolean getAction() { return action; }

    public void setAction(boolean action) { this.action = action; }

    private boolean action;

//    @Id
//    @NotNull
//    @Min(1)
    private Integer userId;

//    @NotBlank(message ="UserName Not blank")
//    @NotNull(message ="UserName not null")
//    @NotEmpty(message ="UserName Not Empty")
    private String userName;

//    @NotBlank(message ="UserLogin not blank")
//    @Length(min = 2, max = 10)
    private String userLogin;

//    @NotBlank(message ="password Not blank")
//    @NotNull(message ="password not null")
//    @NotEmpty(message ="password not empty")
    private String password;

//    @PhoneAnnotation(message = "Phone Number is invalid")
    private String phone;

//
//    private int SortOrder;
//
//    private String ImageFile;
//
//    private String Address;
//
//    private int Sex;
//
//    private String Email;
//
//    private String Tel;
//
//    private boolean IsAdmin;
//
//    private String Notes;

}
