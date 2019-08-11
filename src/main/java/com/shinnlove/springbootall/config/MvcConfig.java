/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局定制spring-boot的MVC特性：包括拦截器、跨域访问、格式化、URI路由等。
 * 
 * 原来在spring的dispatcher-servlet中配置的文件都需要在这里写代码注入进来。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: MvcConfig.java, v 0.1 2019-08-11 23:32 shinnlove.jinsheng Exp $$
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截器
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置跨域访问
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 配置格式化
    }

}