package com.kaiyuan.mengo.kaiyuan.utility;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/*
用来返回json数据状态
 */
public class CommonResult {
    private static final String STATUS = "status";
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String ERROR = "error";

    public static String success() {
        Map<String, String> map = new HashMap<>();
        map.put(STATUS, SUCCESS);
        String result = new Gson().toJson(map);
        return result;
    }
    public static String success(String msg) {
        Map<String, String> map = new HashMap<>();
        map.put(STATUS, SUCCESS);
        map.put("data",msg);
        String result = new Gson().toJson(map);
        return result;
    }

    public static String fail() {
        Map<String, String> map = new HashMap<>();
        map.put(STATUS, FAIL);
        String result = new Gson().toJson(map);
        return result;
    }

    public static String error() {
        Map<String, String> map = new HashMap<>();
        map.put(STATUS, ERROR);
        String result = new Gson().toJson(map);
        return result;
    }
}
