/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.shinnlove.springbootall.dao.mapper.UserMapper;
import com.shinnlove.springbootall.model.User;
import com.shinnlove.springbootall.repository.UserService;

/**
 * 定义用户仓储并配置成服务bean。
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserServiceImpl.java, v 0.1 2018-07-21 下午5:05 shinnlove.jinsheng Exp $$
 */
@Repository(value = "userService")
public class UserServiceImpl implements UserService {

    /** 静态报错没事，spring-boot会自动生成mapper的bean */
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

}