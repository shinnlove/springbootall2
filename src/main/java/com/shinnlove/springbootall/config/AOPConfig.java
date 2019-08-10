/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.shinnlove.springbootall.controller.HelloController;
import com.shinnlove.springbootall.util.log.LoggerUtil;

/**
 * spring-boot AOPConfig配置，打上了@Aspect标签可以保证这是一个AspectJ的切面。
 * 
 * 特别注意：为这个bean打上`@Configuration`注解或者`@Component`注解都可以让它成为一个spring上下文中的bean，并且被AspectJ框架扫描代理到。
 * TODO：这两个注解对于切面类在spring-boot应用中的区别是什么？
 * 
 * @author shinnlove.jinsheng
 * @version $Id: AOPConfig.java, v 0.1 2019-08-10 21:19 shinnlove.jinsheng Exp $$
 */
@Configuration
@Aspect
public class AOPConfig {

    /** logback日志框架配好，在`@Configuration`或`@Component`中就能拿到对象。 */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * 一个简单的AspectJ环绕切面，表达式中不定参数用..表示。
     * 
     * @param jp 
     * @return              具体返回值看切面是位于哪一层，如果是在service就可以抛错；如果是controller层直接返回默认错误json。
     * @throws Throwable
     */
    @Around("execution(* com.shinnlove.springbootall.controller.HelloController.*(..))")
    public Object simpleAop(final ProceedingJoinPoint jp) throws Throwable {
        // 这里记得强行转换一下变成方法签名，就可以获得方法本身名称了
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        // 参数可以直接取出
        Object[] args = jp.getArgs();

        LoggerUtil.info(LOGGER, "methodName:" + method.getName());
        LoggerUtil.info(LOGGER, "args:" + Arrays.asList(args));

        Object result;
        try {
            // 调用原有的方法
            result = jp.proceed();
        } catch (Throwable t) {
            LoggerUtil.error(LOGGER, t, "业务方法执行出错，ex=" + t.getMessage());
            throw t;
        }

        return result;
    }

}