/**
 * eBay.com Inc.
 * Copyright (c) 1995-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;

/**
 * This is recommend controller for swagger2 testing.
 *
 * @author tony, zhao
 * @version $Id: RecommendController.java, v 0.1 2020-01-30 3:20 PM tony, zhao Exp $$
 */
@Api(value = "recommend controller", tags = { "all recommendation requests" })
@RestController
@RequestMapping("/recommend")
public class RecommendController {

    /**
     * This is method that says hello.
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "say hello to the candidate")
    @ApiResponses(value = { @ApiResponse(code = 0, message = "success"),
                            @ApiResponse(code = 10001, message = "system error") })
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(@ApiParam("candidate name") @RequestParam("name") String name) {
        return "Hello " + name;
    }

}