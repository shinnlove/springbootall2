/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring boot hello demo.
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloController.java, v 0.1 2018-09-01 下午10:23 shinnlove.jinsheng Exp $$
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/spring", produces = { "application/json;charset=UTF-8" })
    public String sayHello() {
        return "Hello, spring boot.";
    }

}