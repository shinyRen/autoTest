package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by Renchao on 2018/6/25.
 */
public class DataProviderTest {


    @Test(dataProvider = "providerData") //必须是注解了@DataProvider的方法名
    public void testDataProvider(String name, int age){
        System.out.println("name="+name+" age="+age);
    }

    @Test(dataProvider = "methodData") //必须是注解了@DataProvider的方法名
    public void test1(String name, int age){
        System.out.println("test111方法：name="+name+" age="+age);
    }

    @Test(dataProvider = "methodData") //必须是注解了@DataProvider的方法名
    public void test2(String name, int age){
        System.out.println("test222方法：name="+name+" age="+age);
    }

    @DataProvider
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"张三",10},{"李四",20},{"王五",30}
        };
        return o;
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){ //通过方法的反射，根据方法名为不同的方法提供不同的参数
        Object[][] result = null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},{"lisi",25}
            };
            System.out.println("method.getName().equals(\"test1\")");
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",30},{"zhangliu",40}
            };
            System.out.println("method.getName().equals(\"test2\")");
        }
        return result;
    }

}
