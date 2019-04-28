package com.kaiyuan.mengo.kaiyuan.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kaiyuan.mengo.kaiyuan.dao.UserGalleryDao;
import com.kaiyuan.mengo.kaiyuan.entity.UserGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGalleryService {

    @Autowired
    private UserGalleryDao dao;

    /**
     * 列出所有的图库
     * @return 返回json数据
     */
    public String findAll(){
        List<UserGallery> list = dao.findAll();
//        for (UserGallery userGallery:list){
//            System.out.println(userGallery.getCreated_time());
//        }
//        Gson gson = new Gson();
//         String result = gson.toJson(list);

        ObjectMapper mapper = new ObjectMapper();//jackson将对象转化为json字符串
        String result  = null;
        try {
            result = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
