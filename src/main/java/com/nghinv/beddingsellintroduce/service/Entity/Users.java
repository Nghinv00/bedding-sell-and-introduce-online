package com.nghinv.beddingsellintroduce.service.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "qtUsers")

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;

    // Mapping thông tin biến với tên cột trong Database
    @Column(name = "UserName")
    private String UserName;

    @Column(name = "UserLogin")
    private String UserLogin;

    @Column(name = "Password")
    private String Password;

    // Nếu không đánh dấu @Column thì sẽ mapping tự động theo tên biến
    private int SortOrder;

    private String ImageFile;

    private String Address;

    private int Sex;

    private String Email;

    private String Tel;

    private String Phone;

    private boolean IsAdmin;

    @Column(name ="Notes")
    private String Notes;
}
