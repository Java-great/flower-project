package com.itheima.controller;

import com.itheima.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {
    @Value("${name}")
    private String name;

    @Value("${city[0]}")
    private String city0;

    @Value("${student[1].name}")
    private String studentname;

    @Value("${person.name}")
    private String personName;


    @Value("${maps.name}")//value注解只能获简单的值对象
    private String name1;

    @Autowired
    private Environment environment;
    
    @Autowired
    private Student student;

    @RequestMapping("/show")
    public String showHello() {
        System.out.println("name = " + name);
        System.out.println("city[0] = " + city0);
        System.out.println("students[1].name = " + studentname);
        System.out.println("person.name = " + personName);
        System.out.println("maps.name = " + name1);
        
        System.out.println("environment name>>>>"+environment.getProperty("name"));
        System.out.println(">>>>"+student.getAge());

        return "hello world";
    }
}