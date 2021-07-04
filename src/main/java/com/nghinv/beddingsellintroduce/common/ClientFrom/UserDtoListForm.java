package com.nghinv.beddingsellintroduce.common.clientFrom;

import com.nghinv.beddingsellintroduce.common.dto.UsersDto;

import java.util.ArrayList;
import java.util.List;

public class UserDtoListForm {
    private List<UsersDto> userList;

    public List<UsersDto> getUserList() {
        return userList;
    }

    public UserDtoListForm() {
        this.userList = new ArrayList<UsersDto>();
    }

    public UserDtoListForm(List<UsersDto> userList) {
        this.userList = userList;
    }

    public void setUserList(List<UsersDto> userList) {
        this.userList = userList;
    }

    public void addUserDto(UsersDto user) {
        this.userList.add(user);
    }
}
