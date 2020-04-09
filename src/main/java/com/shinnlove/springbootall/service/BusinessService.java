/**
 * Copyright (c) 1995-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Delegate service for demo.
 * 
 * @author Tony Zhao
 * @version $Id: BusinessService.java, v 0.1 2020-04-09 1:31 PM tony, zhao Exp $$
 */
@Service
public class BusinessService {

    /**
     * define your business here, any numbers of parameters.
     * 
     * @param param1 
     * @param param2
     * @return
     */
    public <T> List<T> fetchOneBusiness(T param1, String param2) {
        // do anything you like
        return new ArrayList<>();
    }

    /**
     * define your business here, any numbers of parameters.
     *
     * @param param1
     * @param param2
     * @return
     */
    public <T> List<T> fetchAnotherBusiness(T param1, String param2) {
        // do anything you like
        return new ArrayList<>();
    }

}