package com.example.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(HttpServletRequest request){//HelloWord api
        String userName=(String)request.getSession().getAttribute("userName");
        if(userName!=null)//验证身份已登录才能访问
            return "HelloWord";
        return "please Login";
    }
}
