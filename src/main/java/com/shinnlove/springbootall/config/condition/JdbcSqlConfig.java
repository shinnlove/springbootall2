/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 条件配置方式之一：有无指定bean来决定是否配置bean。
 * 
 * 本例数据源存在的情况下，才会配置JDBC。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: JdbcSqlConfig.java, v 0.1 2019-08-11 22:10 shinnlove.jinsheng Exp $$
 */
@Configuration
@ConditionalOnBean(DataSource.class)
public class JdbcSqlConfig {
}