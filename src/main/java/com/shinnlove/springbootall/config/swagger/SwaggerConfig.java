/**
 * eBay.com Inc.
 * Copyright (c) 1995-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import io.swagger.annotations.ApiOperation;

/**
 * This is swagger configuration in Spring-Boot.
 * 
 * @author tony, zhao
 * @version $Id: SwaggerConfig.java, v 0.1 2020-01-30 3:26 PM tony, zhao Exp $$
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /** API info */
    private static final String API_TITLE       = "项目名：Swagger和Spring-Boot整合";
    private static final String API_DESCRIPTION = "接口名：Swagger的API文档";
    private static final String VERSION         = "1.0";

    @Bean
    public Docket createRestAPI() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            // any controller which used @ApiOperation annotation will be scanned
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any()).build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(API_TITLE).description(API_DESCRIPTION).version(VERSION)
            .build();
    }

}