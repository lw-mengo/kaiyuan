package com.kaiyuan.mengo.kaiyuan.services;

import DrawSDK.Handler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiyuan.mengo.kaiyuan.dao.UserGalleryDao;
import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import com.kaiyuan.mengo.kaiyuan.entity.UserGallery;
import com.kaiyuan.mengo.kaiyuan.entity.Users;
import com.kaiyuan.mengo.kaiyuan.utility.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
     *
     * @param taskId 唯一的任务ID
     * @param name   创建者
     * @return
     */
    public String saveResult(String taskId, String name) {
        Users user = userService.findUserByName(name);
        Tasks tasks = taskService.findTask(taskId);
        Handler handler = new Handler();
        HashMap<String, String> hashMap = handler.getUrlMap(tasks.getFile_name(), tasks.getTaskid());
        Set keys = hashMap.keySet();
        for (Object key : keys
        ) {
            UserGallery userGallery = new UserGallery();
            userGallery.setCreated_time(new Timestamp(System.currentTimeMillis()));
            userGallery.setUsername(name);
            userGallery.setUid(user.getUid());
            userGallery.setImage_url("http://39.104.16.168:3000/image/bg_02.png");
            userGallery.setResult_type("关联发现2");
            userGallery.setResult_url(hashMap.get(key));
            dao.save(userGallery);
        }
        return CommonResult.success();
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
