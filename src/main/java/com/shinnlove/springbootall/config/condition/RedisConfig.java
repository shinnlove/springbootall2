/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shinnlove.springbootall.service.RedisService;

/**
 * RedisConfig配置bean。
 * 
 * 条件配置方式之一：
 * `@ConditionalOnMissingBean`注解，只有在当前没有`RedisService`类型的bean的时候才会调用create返回一个实例。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: RedisConfig.java, v 0.1 2019-08-11 22:13 shinnlove.jinsheng Exp $$
 */
@Configuration
public class RedisConfig {

    @Bean
    @ConditionalOnMissingBean
    public RedisService createRedisService() {
        return new RedisService();
    }

}