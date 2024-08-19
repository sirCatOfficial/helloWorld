package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.Utils.TipMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    //使用session验证登录，但是不同主机和浏览器可以同时登录同一账号
    public JSONObject login(HttpServletRequest request, String userName, String password){//登录api返回json
        System.out.println(userName+" "+password);
        if(userName.equals("test")&&password.equals("123456")){
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);//登录成功，将userName存入session作为后续验证身份凭证。session会在一段时间后自动过期
            return TipMap.success();
        }
        return TipMap.loginError();
        //通过Service层代码调用Mapper层的sql语句访问数据库，不过现在用不到
//        HashMap map;
//        try {
//            map= new CustomerService.findByPhone(phone).get(0);
//            System.out.println(map);
//        }catch (Exception e){
//            return TipMap.accountError();
//        }
//        if (((String) map.get("password")).equals(password)) {
//            HttpSession session = request.getSession();
//            session.setAttribute("cid", map.get("id"));
//            session.setAttribute("name",map.get("name"));
//            return TipMap.success();
//        }
//        return TipMap.passwordError();
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public JSONObject logout(HttpSession session, SessionStatus sessionStatus){//退出登录
        session.invalidate();
        sessionStatus.setComplete();
        return TipMap.success();
    }
}

