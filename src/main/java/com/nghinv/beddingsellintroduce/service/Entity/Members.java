package com.nghinv.beddingsellintroduce.service.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shMembers")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String MemberGuiId;

    @Column(name = "MemberId")
    private int MemberId;

    @Column(name = "MemberName")
    private int MemberName;

    @Column(name = "MemberLogin")
    private int MemberLogin;

    @Column(name = "Password")
    private int Password;
}
