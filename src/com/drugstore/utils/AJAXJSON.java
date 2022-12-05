package com.drugstore.utils;

/**
 * @author 周万宁
 * @className AJAXJSON
 * @create 2022/12/5-14:37
 * @description ajax json数据
 */
public class AJAXJSON {
    private String message;
    private String data;
    private String state;

    public AJAXJSON(String message, String data, String state) {
        this.message = message;
        this.data = data;
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
