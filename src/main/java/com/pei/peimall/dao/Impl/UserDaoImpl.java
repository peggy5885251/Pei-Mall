package com.pei.peimall.dao.Impl;

import com.pei.peimall.dao.UserDao;
import com.pei.peimall.dto.UserRegisterRequest;
import com.pei.peimall.model.User;
import com.pei.peimall.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {
        String sql = "INSERT INTO user(email, password, phone, created_date, last_modified_date) " +
                " VALUES (:email, :password, :phone, now() , now()) ";

        Map<String, Object> map = new HashMap<>();
        map.put("email", userRegisterRequest.getEmail());
        map.put("password", userRegisterRequest.getPassword());
        map.put("phone", userRegisterRequest.getPhone());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int userId = keyHolder.getKey().intValue();
        return userId ;
    }

    @Override
    public User getUserById(Integer userId) {

        String sql = " SELECT * " +
                " FROM user " +
                " WHERE user_id = :userId ";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        List<User> list = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
        if (list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }

    }

    @Override
    public User getUserByEmail(String email) {
        String sql = " SELECT * " +
                " FROM user " +
                " WHERE email = :email ";
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }
}
