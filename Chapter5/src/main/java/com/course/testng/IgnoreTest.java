package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3");
    }
}
