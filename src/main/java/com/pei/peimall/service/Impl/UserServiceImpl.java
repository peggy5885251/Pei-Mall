package com.pei.peimall.service.Impl;

import com.pei.peimall.dao.UserDao;
import com.pei.peimall.dto.UserRegisterRequest;
import com.pei.peimall.model.User;
import com.pei.peimall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
