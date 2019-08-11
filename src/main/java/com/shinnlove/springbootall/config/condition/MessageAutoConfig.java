/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * spring-boot条件配置方式之一：
 * `@ConditionalOnProperty`根据name来读取`application.yml`中的属性；
 * 根据其值与havingValue的值比较结果决定配置是否生效；havingValue缺省值是true，只要属性不为false，都能生效；
 * matchIfMissing为true意味着如果Environment中没有包含name名的属性，配置也能生效，默认为false。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: MessageAutoConfig.java, v 0.1 2019-08-11 22:25 shinnlove.jinsheng Exp $$
 */
@ConditionalOnProperty(name = "message.center.enabled", havingValue = "true", matchIfMissing = true)
public class MessageAutoConfig {
}