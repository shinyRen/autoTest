package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run"); // 如果依赖的测试方法运行失败，那么该方法将会被忽略执行
    }
}
