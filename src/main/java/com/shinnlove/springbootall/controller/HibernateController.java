/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinnlove.springbootall.dao.UserRepository;
import com.shinnlove.springbootall.model.User;

/**
 * JPA控制器。
 *
 * @EnableAutoConfiguration 自动载入应用程序所有Bean。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HibernateController.java, v 0.1 2018-07-21 下午9:25 shinnlove.jinsheng Exp $$
 */
@RestController
@RequestMapping(value = "/hibernate")
@EnableAutoConfiguration
public class HibernateController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/find/{uid}")
    public User findById(@PathVariable("uid") int userId) {
        User u = userRepository.findUserById(userId);
        System.out.println(u.getName());
        return u;
    }

    @RequestMapping(value = "/name/{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return userRepository.findUserByName(name);
    }

    @RequestMapping(value = "/add")
    public void saveUser() {
        User u = new User();
        u.setAge(20);
        u.setName("金升");
        u.setPassword("Zcs198812180019");
        userRepository.save(u);
    }

}