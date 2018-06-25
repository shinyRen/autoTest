package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by Renchao on 2018/6/25.
 * 异常测试：在期望结果为某一个异常的时候，比如传入了不合法的参数，然后去判断程序抛出的异常是否是预期的
 */
public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
