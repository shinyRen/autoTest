package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass333中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass333中的teacher2运行");
    }
}
