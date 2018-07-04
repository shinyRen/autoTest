package com.course.bean;

import lombok.Data;

/**
 * lombok插件
 * 功能：
 * 可以不用手动添加get、set、toString等方法
 * 用法：
 * 1.安装插件lombok
 * 2.pom.xml文件引入依赖：
 *      <dependency>
 *             <groupId>org.projectlombok</groupId>
 *             <artifactId>lombok</artifactId>
 *             <version>1.16.14</version>
 *         </dependency>
 * 3.在bean类名之前添加@Data注解
 * 4.在其他地方可以直接引用这个bean对象的get、set、toString方法
 */

@Data
public class User {
    private String userName;
    private String password;
    private String name;
    private String age;
    private String sex;
}
