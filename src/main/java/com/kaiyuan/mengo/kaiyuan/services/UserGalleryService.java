package com.kaiyuan.mengo.kaiyuan.services;

import DrawSDK.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiyuan.mengo.kaiyuan.dao.UserGalleryDao;
import com.kaiyuan.mengo.kaiyuan.entity.UserGallery;
import com.kaiyuan.mengo.kaiyuan.entity.Users;
import com.kaiyuan.mengo.kaiyuan.factory.HandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserGalleryService {

    @Autowired
    private UserGalleryDao dao;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    /**
     * 列出所有的图库
     *
     * @return 返回json数据
     */
    public String findAll() {
        List<UserGallery> list = dao.findAll();
//        for (UserGallery userGallery:list){
//            System.out.println(userGallery.getCreated_time());
//        }
//        Gson gson = new Gson();
//         String result = gson.toJson(list);

        ObjectMapper mapper = new ObjectMapper();//jackson将对象转化为json字符串
        String result = null;
        try {
            result = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 保存结果到数据库
     * 文件是cvs还是json的情况下
     *
     * @param taskId 唯一的任务ID
     * @param name   创建者
     * @return 成功
     */
    @Async
    public void saveResult(String taskId, String name, String conf) {
        Users user = userService.findUserByName(name);
//        Tasks tasks = taskService.findTask(taskId);
//        String conf = "test";
//        System.out.println(conf);
        HandlerFactory handler = new HandlerFactory(taskId);
        //根据conf的特征来判断是json还是cvs
        if (conf.contains("json")) {
            System.out.println("执行了json");
            UserGallery userGallery = new UserGallery();
            userGallery.setCreated_time(new Timestamp(System.currentTimeMillis()));
            userGallery.setTaskid(taskId);
            userGallery.setUid(user.getUid());
            userGallery.setUsername(name);
            userGallery.setApp1(handler.getApp(1, conf));
            userGallery.setApp2("test");
            userGallery.setApp3(handler.getApp(3, conf));
            userGallery.setApp4(handler.getApp(4, conf));
            userGallery.setApp5(handler.getApp(5, conf));
            userGallery.setApp6(handler.getApp(6, conf));
            userGallery.setResult_url("no data");
            dao.save(userGallery);
            HandlerFactory.uploadData(conf);


        } else {
            System.out.println("执行了cvs");
            String[] strings = new String[]{"test1", "test2"};
            UserGallery userGallery = new UserGallery();
            userGallery.setCreated_time(new Timestamp(System.currentTimeMillis()));
            userGallery.setTaskid(taskId);
            userGallery.setUid(user.getUid());
            userGallery.setUsername(name);
            userGallery.setApp1(handler.getApp(1, conf));
            userGallery.setApp2("test2");
            userGallery.setApp3(handler.getApp(3, conf));
            userGallery.setApp4(handler.getApp(4, conf));
            userGallery.setApp5(handler.getApp(5, conf));
            userGallery.setApp6(handler.getApp(6, conf));
            userGallery.setResult_url("no data");
            HandlerFactory.uploadData(strings, conf);
            dao.save(userGallery);
        }


//        hashMap.get("app1");//全图浏览
//        hashMap.get("app2");//步进探索
//        hashMap.get("app3");//关系发现
        //利用一个循环加switch分别存入数据库
//        for (int i = 1; i < 4; i++) {
//            String temp = "app" + i;
//            switch (temp) {
//                case "app1":
//                    UserGallery userGallery = new UserGallery();
//                    userGallery.setCreated_time(new Timestamp(System.currentTimeMillis()));
//                    userGallery.setUsername(name);
//                    userGallery.setUid(user.getUid());
//                    userGallery.setImage_url("http://39.104.16.168:3000/image/bg_02.png");
//                    userGallery.setResult_type("全图浏览");
//                    userGallery.setTaskid(taskId);
//                    userGallery.setResult_url(hashMap.get(temp));
//                    dao.save(userGallery);
//                    break;
//                case "app2":
//                    UserGallery userGallery1 = new UserGallery();
//                    userGallery1.setCreated_time(new Timestamp(System.currentTimeMillis()));
//                    userGallery1.setUsername(name);
//                    userGallery1.setUid(user.getUid());
//                    userGallery1.setImage_url("http://39.104.16.168:3000/image/bg_03.png");
//                    userGallery1.setResult_type("步进探索");
//                    userGallery1.setTaskid(taskId);
//                    userGallery1.setResult_url(hashMap.get(temp));
//                    dao.save(userGallery1);
//                    break;
//                case "app3":
//                    UserGallery userGallery2 = new UserGallery();
//                    userGallery2.setCreated_time(new Timestamp(System.currentTimeMillis()));
//                    userGallery2.setUsername(name);
//                    userGallery2.setUid(user.getUid());
//                    userGallery2.setImage_url("http://39.104.16.168:3000/image/bg_01.png");
//                    userGallery2.setResult_type("关系发现");
//                    userGallery2.setTaskid(taskId);
//                    userGallery2.setResult_url(hashMap.get(temp));
//                    dao.save(userGallery2);
//                    break;
//                default:
//                    break;
//            }
//    }

//        Set keys = hashMap.keySet();
//        for (Object key : keys
//        ) {
//            UserGallery userGallery = new UserGallery();
//            userGallery.setCreated_time(new Timestamp(System.currentTimeMillis()));
//            userGallery.setUsername(name);
//            userGallery.setUid(user.getUid());
//            userGallery.setImage_url("http://39.104.16.168:3000/image/bg_02.png");
//            userGallery.setResult_type("关联发现2");
//            userGallery.setTaskid(taskId);
//            userGallery.setResult_url(hashMap.get(key));
//            dao.save(userGallery);
//        }
    }


    /**
     * 根据taskID查找任务，并返回三个数据结果
     */
    public String getResultByTaskId(String taskId) {
        List<UserGallery> lists = dao.findByTaskid(taskId);
        ObjectMapper mapper = new ObjectMapper();//jackson将对象转化为json字符串
        String result = null;
        try {
            result = mapper.writeValueAsString(lists);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }


}
