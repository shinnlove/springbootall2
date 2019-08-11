/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import com.shinnlove.springbootall.service.client.JedisClient;

/**
 * spring-boot条件配置方式之一：某个类是否在Classpath下。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: JedisConfig.java, v 0.1 2019-08-11 22:22 shinnlove.jinsheng Exp $$
 */
@Configuration
@ConditionalOnClass(JedisClient.class)
public class JedisConfig {

}