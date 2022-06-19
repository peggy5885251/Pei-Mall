package com.pei.peimall.dao;

import com.pei.peimall.dto.UserRegisterRequest;
import com.pei.peimall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
}
