/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.util;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * spring boot 错误页面配置。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ErrorPageConfig.java, v 0.1 2018-09-01 下午10:41 shinnlove.jinsheng Exp $$
 */
@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

    /**
     * @see org.springframework.boot.web.server.ErrorPageRegistrar#registerErrorPages(ErrorPageRegistry)
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //1、按错误的类型显示错误的网页
        //错误类型为404，找不到网页的，默认显示404.html网页
        ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        //错误类型为500，表示服务器响应错误，默认显示500.html网页
        ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        registry.addErrorPages(page404, page500);
    }

}