package com.nghinv.beddingsellintroduce.service.services.implement;

import com.nghinv.beddingsellintroduce.common.dto.UsersDto;
import com.nghinv.beddingsellintroduce.service.entity.User;
import com.nghinv.beddingsellintroduce.service.repository.interfaces.UserRepository;
import com.nghinv.beddingsellintroduce.service.repository.interfaces.UserViewRepository;
import com.nghinv.beddingsellintroduce.service.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserViewRepository userViewRepository;

    public List<UsersDto> getUserList() {

//       return userRepository.findAll();
        return null;
    }

    public List<UsersDto> getUserListById(List<Integer> ids) {

//        return userRepository.findAllById(ids);
        return null;
    }

    @Override
    public Iterable<UsersDto> findAll() {
//        return userRepository.findAll();
        return null;
    }

    @Override
    public List<UsersDto> search(String term) {
//        return userRepository.findByNameContaining(term);
        return null;
    }

//    @Override
//    public User findOne(User user) {
//        return userRepository.findOne(user);
//    }

    @Override
    public void save(UsersDto user) {
//        userRepository.save(user);
    }

    @Override
    public void delete(UsersDto user) {
//        userRepository.delete(user);
    }

//    Sort sort = new Sort(new Sort.Order(Direction.ASC, "lastName"));
//    Pageable pageable = new PageRequest(0, 10, sort);

    public int getCount() {
        long count = userViewRepository.count();
        return (int)count;
    }

}
