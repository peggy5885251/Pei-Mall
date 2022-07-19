package com.pei.peimall.service.Impl;

import com.pei.peimall.dao.UserDao;
import com.pei.peimall.dto.UserLoginRequest;
import com.pei.peimall.dto.UserRegisterRequest;
import com.pei.peimall.model.User;
import com.pei.peimall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊的 email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if (user != null){
            log.warn("該 email {} 已經被 {} 註冊", userRegisterRequest.getEmail(), "Pei");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);
        // 註冊帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        if(user == null ){
            log.warn("找不到這個user email {}",user.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        if(user.getPassword().equals(hashedPassword)){
            return user;
        }else {
            log.warn("密碼錯誤 password{}", user.getPassword());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
