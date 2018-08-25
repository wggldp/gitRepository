package com.example.service.impl;

import com.example.dao.UsersMapper;
import com.example.pojo.Users;
import com.example.service.IUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersImpl implements IUsers {

    @Autowired
    private UsersMapper userDao;

    @Override
    public Users findAll(){
        return  userDao.selectByPrimaryKey("1");
    }
}
