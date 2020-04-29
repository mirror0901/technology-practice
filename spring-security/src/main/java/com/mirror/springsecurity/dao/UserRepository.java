package com.mirror.springsecurity.dao;

import com.mirror.springsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-29 20:53
 **/
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    UserEntity findByUsername(String username);

}
