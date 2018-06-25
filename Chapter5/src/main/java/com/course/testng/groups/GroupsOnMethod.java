package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
public class GroupsOnMethod {


    @Test(groups = "server")
    public void test1(){
        System.out.println("服务端组的测试方法：test1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("服务端组的测试方法：test2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("客户端组的测试方法：test3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("客户端组的测试方法：test4");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法：beforeGroupsOnServer");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法：afterGroupsOnServer");
    }


    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组运行之前运行的方法：beforeGroupsOnClient");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组运行之后运行的方法：afterGroupsOnClient");
    }


}
