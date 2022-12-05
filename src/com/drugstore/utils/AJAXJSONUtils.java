package com.drugstore.utils;

import com.alibaba.fastjson.JSON;

/**
 * @author 周万宁
 * @className AJAXJSON
 * @create 2022/12/5-14:32
 * @description ajax数据工具
 */
public class AJAXJSONUtils<T> {

    public String respJson(T t){
        String json = JSON.toJSONString(t);
        AJAXJSON s = new AJAXJSON("请求成功", "200", json);
        return JSON.toJSONString(s);
    }
}
