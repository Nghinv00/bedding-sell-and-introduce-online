package com.nghinv.beddingsellintroduce.service.entity;

import javax.persistence.*;

@Entity
@Table(name = "shMembers")
public class Member {

    public Member() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MemberGuiId")
    private String MemberGuiId;

    @Column(name = "MemberId")
    private int MemberId;

    @Column(name = "MemberName")
    private int MemberName;

    @Column(name = "MemberLogin")
    private int MemberLogin;

    @Column(name = "Password")
    private int Password;

    public String getMemberGuiId() {
        return MemberGuiId;
    }

    public void setMemberGuiId(String memberGuiId) {
        MemberGuiId = memberGuiId;
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        MemberId = memberId;
    }

    public int getMemberName() {
        return MemberName;
    }

    public void setMemberName(int memberName) {
        MemberName = memberName;
    }

    public int getMemberLogin() {
        return MemberLogin;
    }

    public void setMemberLogin(int memberLogin) {
        MemberLogin = memberLogin;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}
