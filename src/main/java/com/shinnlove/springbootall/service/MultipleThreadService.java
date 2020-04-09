/**
 * Copyright (c) 1995-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.shinnlove.springbootall.util.code.SystemResultCode;
import com.shinnlove.springbootall.util.exception.SystemException;
import com.shinnlove.springbootall.util.log.LoggerUtil;
import com.shinnlove.springbootall.util.pools.ThreadPoolUtil;

/**
 * Multiple thread to execute your business.
 * 
 * @author Tony Zhao
 * @version $Id: MultipleThreadService.java, v 0.1 2020-04-09 12:56 PM tony, zhao Exp $$
 */
@Service
public class MultipleThreadService {

    private static final Logger          LOGGER     = LoggerFactory
        .getLogger(MultipleThreadService.class);

    private static final ExecutorService dispatcher = ThreadPoolUtil.createPool("dispatch-pools", 2,
        5);

    private static final ExecutorService collector  = ThreadPoolUtil.createPool("collect-pools", 30,
        50);

    @Autowired
    private BusinessService              businessService;

    /**
     * Your business entrance.
     * 
     * @return 
     * @throws SystemException
     */
    private List doYourBusiness() throws SystemException {

        // Step1: first thread task
        CompletableFuture<List<Map>> firstTask = CompletableFuture.supplyAsync(() -> {
            // dispatch here
            List<Future<List<Map>>> dispatchTasks = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    // multiple threads
                    dispatchTasks.add(collector
                        .submit(() -> businessService.fetchOneBusiness(new HashMap(), "hello")));
                }
            }

            // collect here
            List<Map> result = new ArrayList();
            for (Future<List<Map>> task : dispatchTasks) {
                try {
                    result.addAll(task.get());
                } catch (Exception e) {
                    LoggerUtil.warn(LOGGER, "missing and skip one thread result");
                    LoggerUtil.error(LOGGER, e, e.getMessage());
                }
            }

            return result;
        }, dispatcher);

        // Step1: second thread task
        CompletableFuture<List> secondTask = CompletableFuture.supplyAsync(() -> {
            // dispatch here
            List<Future<List<Map>>> dispatchTasks = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    // multiple threads
                    dispatchTasks.add(collector.submit(
                        () -> businessService.fetchAnotherBusiness(new HashMap(), "hurui")));
                }
            }

            // collect here
            List<Map> result = new ArrayList();
            for (Future<List<Map>> task : dispatchTasks) {
                try {
                    result.addAll(task.get());
                } catch (Exception e) {
                    LoggerUtil.error(LOGGER, e, e.getMessage());
                }
            }

            return result;
        }, dispatcher);

        // Step3: define two threads combine future
        CompletableFuture<List> combineList = firstTask.thenCombine(secondTask,
            (result1, result2) -> ImmutableList.of(result1, result2));

        try {
            // Attention: main thread will wait here for two dispatch thread return.
            return combineList.get();
        } catch (Exception e) {
            LoggerUtil.error(LOGGER, e, e.getMessage());
            throw new SystemException(SystemResultCode.SYSTEM_ERROR, e, e.getMessage());
        }

    }

}