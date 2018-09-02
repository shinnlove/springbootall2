/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnlove.springbootall.model.User;
import com.shinnlove.springbootall.repository.UserService;

/**
 * 用户控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserController.java, v 0.1 2018-07-21 下午5:04 shinnlove.jinsheng Exp $$
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    /** 用户Service仓储 */
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = { "application/json;charset=UTF-8" })
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = { "application/json;charset=UTF-8" })
    public Object findAllUser(@PathVariable("pageNum") int pageNum,
                              @PathVariable("pageSize") int pageSize) {

        return userService.findAllUser(pageNum, pageSize);
    }

}