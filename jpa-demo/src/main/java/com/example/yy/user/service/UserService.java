package com.example.yy.user.service;

import com.example.yy.user.dao.UserDao;
import com.example.yy.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ralf Chen on 2018/4/11 0011.
 */
@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    public List getList() {
        return userDao.findAll();
    }
}
