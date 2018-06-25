package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
public class MultiThreadOnAnnotation {

    /**
     * invocationCount：重复调用该方法的次数
     * threadPoolSize：线程池中的线程数
     */
    @Test(invocationCount = 10, threadPoolSize = 5)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
