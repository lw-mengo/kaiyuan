package com.kaiyuan.mengo.kaiyuan.factory;

import DrawSDK.Handler;

/**
 * 用来解耦sdk
 */
public class HandlerFactory {

    private static Handler handler;

    public HandlerFactory(String taskId) {
        this.handler = new Handler(taskId);
    }

    public static String getApp(int i, String conf) {
        String result="";
        switch (i) {
            case 1:
                result += handler.getApp1(conf);//过滤
                break;
            case 2:
                result += handler.getApp2(conf);//步进探索
                break;
            case 3:
                result += handler.getApp3(conf);//关联路径
                break;
            case 4:
                result += handler.getApp4(conf);//社区
                break;
            case 5:
                result += handler.getApp5(conf);//抽样
                break;
            case 6:
                result += handler.getApp6(conf);//高级过滤
                break;
        }
        return result;
    }

    public static void uploadData(String[] csvFiles,String cypher){
        handler.uploadData(csvFiles,cypher);
    }

    public static void uploadData(String json){
        handler.uploadData(json);
    }

    public static String  getInfo(){
        return handler.getInfo();
    }


}
