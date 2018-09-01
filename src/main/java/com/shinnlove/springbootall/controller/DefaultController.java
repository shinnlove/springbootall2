/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 默认控制器，处理根路径和错误页面(稍微有点问题，后续优化)。
 *
 * @author shinnlove.jinsheng
 * @version $Id: DefaultController.java, v 0.1 2018-09-01 下午10:26 shinnlove.jinsheng Exp $$
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Hello, welcome to spring boot.";
    }

    /**
     * 404页面
     */
    @RequestMapping(value = "/error/404")
    public String error_404() {
        return "common/404";
    }

    /**
     * 500页面
     */
    @RequestMapping(value = "/error/500")
    public String error_500() {
        return "common/500";
    }

}