package com.szmt.sec.service;

import com.szmt.sec.po.Users;

/**
 * Created by Administrator on 2015-11-10.
 */
public interface UserService {
    Users selectByPrimaryKey(String uname);
    int insert(Users record);
}
