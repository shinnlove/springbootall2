/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 直接读取spring-boot的application.yml文件中配置，并注册成为一个配置bean。
 * 
 * @author shinnlove.jinsheng
 * @version $Id: DIYConfig.java, v 0.1 2019-08-11 20:50 shinnlove.jinsheng Exp $$
 */
@Configuration
@ConfigurationProperties("diy")
public class DIYPropertyConfig {

    private String ip;
    private String port;

    /**
     * Getter method for property ip.
     *
     * @return property value of ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Setter method for property ip.
     *
     * @param ip value to be assigned to property ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Getter method for property port.
     *
     * @return property value of port
     */
    public String getPort() {
        return port;
    }

    /**
     * Setter method for property port.
     *
     * @param port value to be assigned to property port
     */
    public void setPort(String port) {
        this.port = port;
    }

}