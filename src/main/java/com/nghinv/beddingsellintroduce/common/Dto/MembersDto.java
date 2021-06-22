package com.nghinv.beddingsellintroduce.common.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class MembersDto implements Serializable {


    public String getMemberGuiId() {
        return memberGuiId;
    }

    public void setMemberGuiId(String memberGuiId) {
        this.memberGuiId = memberGuiId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLogin() {
        return memberLogin;
    }

    public void setMemberLogin(String memberLogin) {
        this.memberLogin = memberLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String memberGuiId;

    @NotEmpty(message = "{MembersDto.MemberId}")
//    @NotEmpty(message = "{Please enter a MemberId1}")
    private Integer memberId;

    @NotEmpty(message = "{MembersDto.MemberName}")
//    @NotEmpty(message = "Please enter a MemberName1")
    private String memberName;

    @NotEmpty(message = "{MembersDto.MemberLogin}")
//    @NotEmpty(message = "Please enter a MemberLogin1")
    private String memberLogin;

    @NotEmpty(message = "{MembersDto.Password}")
//    @NotEmpty(message = "Please enter a Password1")
    private String password;
}
