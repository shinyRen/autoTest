package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    /**
     * 要求客户端返回一个cookies
     * @param response
     * @return
     */
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "GET")
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息的类
        //HttpServerletResponse 装响应信息的类

        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);

        return "恭喜你获得cookies信息成功";
    }


    /**
     * 要求客户端必须携带cookies访问
     */
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        //判断对象是否为空
        if(!Objects.isNull(cookies)){
            for (Cookie cookie:cookies){
                if(cookie.getName().equals("login")
                        && cookie.getValue().equals("true")){
                    return "携带cookies信息访问成功";
                }
            }
        }

        return "你必须携带cookies信息才能访问";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式 url: key=value&key=value ，使用注解 @RequestParam
     * 我们来模拟获取商品列表
     */
    @ApiOperation(value = "需要携带参数才能访问的get请求:url: key=value&key=value",httpMethod = "GET")
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("运动鞋",400);
        myList.put("方便面",10);
        myList.put("衣服",300);

        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url: ip:port/get/with/param/10/20
     */
    @ApiOperation(value = "需要携带参数才能访问的get请求:url: ip:port/get/with/param/10/20",httpMethod = "GET")
    @RequestMapping(value = "get/with/param/{start}/{end}")
    public Map<String,Integer> myGetList(@PathVariable Integer start,
                                         @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("运动鞋",400);
        myList.put("方便面",10);
        myList.put("衣服",300);

        return myList;
    }

}
