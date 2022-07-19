package com.pei.peimall.service;

import com.pei.peimall.dto.UserLoginRequest;
import com.pei.peimall.dto.UserRegisterRequest;
import com.pei.peimall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
    User login(UserLoginRequest userLoginRequest);
}
