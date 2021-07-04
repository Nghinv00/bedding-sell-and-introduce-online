package com.nghinv.beddingsellintroduce.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "User")
@Table(name = "qtUsers")
@NamedStoredProcedureQuery(name = "User.plus1",
        procedureName = "plus1inout",
                        parameters = {
                            @StoredProcedureParameter(mode = ParameterMode.IN, name = "arg", type = Integer.class),
                            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class)
                        })
public class User {

    public User() {

    }
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

    @Column(name ="Notes")
    private String Notes;

    // Nếu không đánh dấu @Column thì sẽ mapping tự động theo tên biến
    private Integer SortOrder;

    private String ImageFile;

    private String Address;

    private Integer Sex;

    private String Email;

    private String Tel;

    private String Phone;

    private Boolean IsAdmin;

    private Integer UnitId;

    private Integer DepartmentId;

    private Integer PositionId;

    private Boolean Status;

    private Date CreateDate;

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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Integer getSortOrder() {
        return SortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        SortOrder = sortOrder;
    }

    public String getImageFile() {
        return ImageFile;
    }

    public void setImageFile(String imageFile) {
        ImageFile = imageFile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getSex() {
        return Sex;
    }

    public void setSex(Integer sex) {
        Sex = sex;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Boolean getAdmin() {
        return IsAdmin;
    }

    public void setAdmin(Boolean admin) {
        IsAdmin = admin;
    }

    public Integer getUnitId() {
        return UnitId;
    }

    public void setUnitId(Integer unitId) {
        UnitId = unitId;
    }

    public Integer getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        DepartmentId = departmentId;
    }

    public Integer getPositionId() {
        return PositionId;
    }

    public void setPositionId(Integer positionId) {
        PositionId = positionId;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
