package com.course.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.scripts.JS;
import netscape.javascript.JSObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {


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
    public void testPostWithCookies() throws IOException {
        //从配置文件拼接测试的url
        String uri = bundle.getString("postWithCookies.uri");
        String testUrl = this.url + uri;

        //声明一个携带cookies信息的Client对象
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        //声明一个post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数（json格式）,在pom.xml文件中先添加json依赖（例如：fastjson）
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");//必须是字符串

        //设置请求头信息（header）
        post.setHeader("content-type","application/json"); //有多少头信息，就添加多少个setHeader
        post.setHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");

        //将参数信息添加到post方法中
        StringEntity entity = new StringEntity(param.toJSONString(),"utf-8");
        post.setEntity(entity);

        //声明一个对象来进行响应结果的存储
        String result;

        //执行post方法
        HttpResponse response = client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //处理结果，就是判断返回结果是否符合预期
        //将返回的响应结果字符串转化为json对象
        JSONObject resultJson = JSON.parseObject(result);

        //获取结果json对象的值
        String success = resultJson.getString("huahansan");
        String status = resultJson.getString("status");

        //具体的判断返回结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);

    }



}
