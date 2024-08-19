package com.example.test.Utils;


import com.alibaba.fastjson.JSONObject;

public class TipMap {//常用字符串以及构造json工具类
    private static final String result="result";
    private static final String isSuccess="isSuccess";
    private static final String userOrPasswordError="user or password error";
    private static final String success="success";
    private static final String noLogin="please login";
    public static JSONObject success(){//
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(isSuccess,true);
        jsonObject.put(result,success);
        return jsonObject;
    }
    public static JSONObject loginError(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(isSuccess,false);
        jsonObject.put(result,userOrPasswordError);
        return jsonObject;
    }
}
