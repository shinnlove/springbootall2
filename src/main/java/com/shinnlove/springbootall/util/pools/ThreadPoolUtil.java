/**
 * Copyright (c) 1995-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.util.pools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Thread util tools for create pools.
 * 
 * @author Tony Zhao
 * @version $Id: ThreadPoolUtil.java, v 0.1 2020-04-09 12:50 PM tony, zhao Exp $$
 */
public class ThreadPoolUtil {

    /**
     * Create your own thread pool.
     * 
     * @param threadGroupName 
     * @param core
     * @param maximum
     * @return
     */
    public static ThreadPoolExecutor createPool(String threadGroupName, int core, int maximum) {
        return new ThreadPoolExecutor(core, maximum, 300L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(50), new NamedThreadFactory(threadGroupName),
            (r, executor) -> {
                System.out.println("multi thread handle was abandoned");
                // suggest logger here, but you could still thrown out as wished
                // throw new RejectedExecutionException("There are too many multi thread requests.");
            });
    }

}