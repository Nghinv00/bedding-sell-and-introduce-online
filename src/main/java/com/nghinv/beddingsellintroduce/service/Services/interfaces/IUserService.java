package com.nghinv.beddingsellintroduce.service.services.interfaces;

import com.nghinv.beddingsellintroduce.common.dto.UsersDto;
import com.nghinv.beddingsellintroduce.service.entity.User;

import java.util.List;

public interface IUserService {

    List<UsersDto> getUserList();

    List<UsersDto> getUserListById(List<Integer> ids);

    Iterable<UsersDto> findAll();

    List<UsersDto> search(String term);

//    User findOne(Integer id);

    void save(UsersDto contact);

    void delete(UsersDto user);

    int getCount();

}
