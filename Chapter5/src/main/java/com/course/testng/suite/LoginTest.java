package com.course.testng.suite;

import org.testng.annotations.*;

/**
 * Created by Renchao on 2018/6/25.
 */
public class LoginTest {

    @Test
    public void loginTaoBao(){
        System.out.println("淘宝登陆成功");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @BeforeTest
    public void beforeLoginTest(){
        System.out.println("beforeLoginTest");
    }

    @AfterTest
    public void afterLoginTest(){
        System.out.println("afterLoginTest");
    }


}
