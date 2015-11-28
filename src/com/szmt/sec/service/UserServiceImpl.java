package com.szmt.sec.service;

import com.szmt.sec.mapper.UsersMapper;
import com.szmt.sec.po.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015-11-10.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UsersMapper usersMapper;

    //    查询管理员用户名和密码
    @Override
    public Users selectByPrimaryKey(String uname) {
        return usersMapper.selectByPrimaryKey(uname);
    }

    //    新增一个管理员
    @Override
    public int insert(Users record) {
        usersMapper.insert(record);
        return 0;
    }


}
