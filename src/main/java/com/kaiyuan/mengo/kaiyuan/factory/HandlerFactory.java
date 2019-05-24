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
                result += handler.getApp1(conf);
                break;
            case 2:
                result += handler.getApp2(conf);
                break;
            case 3:
                result += handler.getApp3(conf);
                break;
            case 4:
                result += handler.getApp4(conf);
                break;
            case 5:
                result += handler.getApp5(conf);
                break;
            case 6:
                result += handler.getApp6(conf);
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
