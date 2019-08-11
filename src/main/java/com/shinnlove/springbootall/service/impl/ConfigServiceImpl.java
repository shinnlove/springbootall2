/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.shinnlove.springbootall.config.DIYPropertyConfig;
import com.shinnlove.springbootall.service.ConfigService;

/**
 * Service层，专门用来对Controller层透出各类注入的服务配置。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: ConfigServiceImpl.java, v 0.1 2019-08-11 21:03 shinnlove.jinsheng Exp $$
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    /** spring-boot会在上下文中自动创建一个env */
    @Autowired
    private Environment       env;

    /** 自定义配置 */
    @Autowired
    private DIYPropertyConfig diyPropertyConfig;

    /** 通过Value获取上下文属性配置 */
    @Value("${server.tomcat.accesslog.enabled:false}")
    private boolean           logEnabled;

    @Override
    public String getConfigStrFromEnv() {
        return env.getProperty("JAVA_HOME") + env.getProperty("diy.ip");
    }

    @Override
    public int getConfigValueFromEnv() {
        // 默认getProperty都当做字符串了，要获取整型需要转型、但是注意别抛错
        return env.getProperty("diy.port", Integer.class);
    }

    @Override
    public String getPropertiesConfig() {
        return diyPropertyConfig.getIp() + ":" + diyPropertyConfig.getPort();
    }

    @Override
    public String getValueFromValueSpEL() {
        return "logEnabled:" + logEnabled;
    }

}