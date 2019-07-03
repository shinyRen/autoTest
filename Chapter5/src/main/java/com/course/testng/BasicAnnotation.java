package com.course.testng;

import org.testng.annotations.*;

/**
 * Created by Renchao on 2018/6/25.
 */
public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1: testCase1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2: testCase2");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod: 这是在测试方法之前运行的方法");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod: 这是测试方法之后运行的方法");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass: 这是在类运行之前运行的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass: 这是在类运行之后运行的方法");
    }


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite在类运行之前");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite在类运行之后");
    }

}
