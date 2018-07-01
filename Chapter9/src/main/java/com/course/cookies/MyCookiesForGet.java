package com.course.cookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    //用来读取配置文件
    private ResourceBundle bundle;

    //用来存储cookies信息的变量
    private CookieStore cookieStore;


    @BeforeTest
    public void beforeTest(){
        //默认识别properties文件，所以可以只写文件名的前缀部分，即不写后缀名
        //自动会找到src/main/resources下面的properties文件
       bundle = ResourceBundle.getBundle("application",Locale.CHINA);
       url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies1() throws IOException {
        String result;
        //从配置文件拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;

        //测试代码逻辑书写
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }

    @Test
    public void testGetCookies2() throws IOException {
        String result;
        //从配置文件拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;

        //测试代码逻辑书写
        CloseableHttpClient client;
        //设置cookies信息
        this.cookieStore = new BasicCookieStore();
        client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies
        List<Cookie> cookies = this.cookieStore.getCookies();
        for (int i = 0; i < cookies.size(); i++) {
            System.out.println("cookie: " + cookies.get(i).getName() + " = " +cookies.get(i).getValue());
        }
    }

    @Test(dependsOnMethods = "testGetCookies2")
    public void testGetWithCookies() throws IOException {
        String result;
        //从配置文件拼接测试的url
        String uri = bundle.getString("getWithCookies.uri");
        String testUrl = this.url + uri;

        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);

        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);
        if (statusCode == 200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

    }

}
