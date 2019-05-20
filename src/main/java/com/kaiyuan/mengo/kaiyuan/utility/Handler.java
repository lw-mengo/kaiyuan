package com.kaiyuan.mengo.kaiyuan.utility;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

//每个数据集对应一个handler，初始化的时候给一个Taskid就行了。
public class Handler {


    String taskId;
    String igraph_poolPath;
    String igServer_poolPath;
    String dbPATH;

    public Handler() {
        //do nothing
    }

    public Handler(String id) {
        //这里我会做一些初始化，你调用构造函数时，传进来一个taskid就行了。
        this.taskId = id;
    }


    //  cypher 语句由用户提供，不需要保存到数据库。
    //  csvfile是绝对路径（同jsonFile）
    //  返回值标记是否成功导入数据库
    public boolean uploadData(String[] csvFiles, String cypher) {
        return true;
    }

    public boolean uploadData(String jsonFile) {
        return true;
    }


    /**
     * conf是表示用户配置项的json字符串
     * 对应关系：
     * url1：导航 例：39.106.16.168:xx/xxx/xxx.html
     * url2：探索
     * url3：关系
     * url4：社区
     * url5：过滤
     * url6：高级过滤
     */
    public String getApp1(String conf) {
        return "url1";
    }

    public String getApp2(String conf) {
        return "url2";
    }

    public String getApp3(String conf) {
        return "url3";
    }

    public String getApp4(String conf) {
        return "url4";
    }

    public String getApp5(String conf) {
        return "url5";
    }

    public String getApp6(String conf) {
        return "url6";
    }

    //标准json格式，可解析
    public String getInfo() {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Map> map3 = new HashMap<>();
        map1.put("type1", 123);
        map1.put("type2", 456);
        map2.put("edgetype1", 321);
        map2.put("edgetype2", 654);
        map3.put("nodes", map1);
        map3.put("edges", map2);
        String json = new Gson().toJson(map3);
        return json;
    }

}