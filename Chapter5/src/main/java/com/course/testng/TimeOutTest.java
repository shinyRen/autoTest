package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 */
public class TimeOutTest {

    @Test(timeOut = 3000) //单位为毫秒值
    public void test1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(timeOut = 3000)
    public void test2(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
