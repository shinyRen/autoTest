package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
public class ParameterTest {

    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name, int age){
        System.out.println("name="+name+" age="+age);
    }
}
