package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu1(){
        System.out.println("GroupsOnClass222中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupsOnClass222中的stu2运行");
    }
}
