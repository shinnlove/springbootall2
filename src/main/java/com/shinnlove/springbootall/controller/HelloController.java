/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnlove.springbootall.util.code.SystemResultCode;
import com.shinnlove.springbootall.util.exception.SystemException;
import com.shinnlove.springbootall.util.log.LoggerUtil;

/**
 * Spring boot hello demo.
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloController.java, v 0.1 2018-09-01 下午10:23 shinnlove.jinsheng Exp $$
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    /** 默认日志门面 */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * 欢迎页，并使用logback打日志。
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/spring", produces = { "application/json;charset=UTF-8" })
    public String logbackWelcome() {
        LoggerUtil.info(LOGGER, "欢迎来到spring boot，这是info日志。");
        LoggerUtil.warn(LOGGER, "欢迎来到spring boot，这是warn日志。");
        LoggerUtil.error(LOGGER, new SystemException(SystemResultCode.SYSTEM_ERROR),
            "欢迎来到spring boot，这是自定义系统错误日志。");
        return "Hello, spring boot.";
    }

    /**
     * 使用thymeleaf模板。
     *
     * @param modelMap
     * @param personName
     * @return
     */
    @RequestMapping(value = "/{name}")
    public String sayHello(ModelMap modelMap, @PathVariable("name") String personName) {
        modelMap.addAttribute("name", personName);
        // 返回views文件夹下的hello.html视图模板
        return "views/hello";
    }

}