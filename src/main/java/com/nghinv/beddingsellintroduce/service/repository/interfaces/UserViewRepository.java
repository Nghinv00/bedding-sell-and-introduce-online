package com.nghinv.beddingsellintroduce.service.repository.interfaces;

import com.nghinv.beddingsellintroduce.service.entity.User;
import com.nghinv.beddingsellintroduce.service.entity.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface UserViewRepository extends JpaRepository<UserView, Integer> {


}
