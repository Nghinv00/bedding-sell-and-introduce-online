package com.nghinv.beddingsellintroduce.service.repository.interfaces;

import com.nghinv.beddingsellintroduce.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<User, Long> {
}
