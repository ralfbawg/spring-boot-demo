package com.example.yy.user.dao;

import com.example.yy.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ralf Chen on 2018/4/11 0011.
 */
public interface UserDao extends JpaRepository<UserEntity,Long> {
}
