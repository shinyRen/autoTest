package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @Api中的value的值和 @RequestMapping 的值相对应，@Api中的值是对RequestMapping的说明，必须一致；
 */
@Api(value = "v1", description = "这是我的第一个版本的Demo")
@RequestMapping("v1")
@Log4j
public class DemoController {

    //首先获取一个执行sql语句的对象
    @Autowired //启动即加载（即自动注入）
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount" ,method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){

       //参数statement的值就是mysql.xml文件中select标签中的id（所以id必须唯一）
       return template.selectOne("getUserCount");
    }


}
