package com.tester.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/26.
 */
public class TestMethodsDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa","bbb");
    }

    @Test
    public void logDemo(){
        Reporter.log("这是记录的日志");
        throw new RuntimeException("这是自己抛出的运行时异常");
    }
}
