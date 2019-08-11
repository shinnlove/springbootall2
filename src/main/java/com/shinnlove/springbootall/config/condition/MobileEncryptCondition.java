/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config.condition;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.shinnlove.springbootall.service.MobileEncryptService;

/**
 * spring-boot条件配置方式之一：
 * 通过实现`Condition`接口配合`@Conditional`注解使用。
 * 
 * `@Configuration`让配置生效；
 * `@Bean`让创建出来的service成为一个bean；
 * `@Conditional`注解会校验当前条件是否满足。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: MobileEncryptCondition.java, v 0.1 2019-08-11 22:36 shinnlove.jinsheng Exp $$
 */
@Configuration
public class MobileEncryptCondition {

    @Bean
    @Conditional(EncryptCondition.class)
    public MobileEncryptService createEncryptService() {
        return new MobileEncryptService();
    }

    static class EncryptCondition implements Condition {

        /**
         * 特别重要：这个重写的方法中直接返回了spring的上下文，并且能返回环境类。
         * 
         * @param context 
         * @param metadata
         * @return
         */
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            // 加入自定义的条件
            Resource res = context.getResourceLoader().getResource("salt.txt");
            Environment env = context.getEnvironment();
            return res.exists() && env.containsProperty("mobile.encrypt.enabled");
        }

    }

}