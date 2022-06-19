package com.pei.peimall.model;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Integer userId;
    private String email;
    private String password;
    private String phone;
    private Date createDate;
    private Date lastModifiedDate;
}
