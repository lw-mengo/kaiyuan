package com.kaiyuan.mengo.kaiyuan.controllers;

import com.kaiyuan.mengo.kaiyuan.entity.Users;
import com.kaiyuan.mengo.kaiyuan.services.UserService;
import com.kaiyuan.mengo.kaiyuan.utility.DigestUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UsersController {
    public static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    /*
    用户登录action
     */
    @PostMapping(value = "/loginAction")
    public String findUserByName(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password) {
        Users user = userService.findUserByName(name);
        log.info(name);
        if (user != null) {
            //必须解析密码
            String salt = user.getPassword_salt();
            password = DigestUtil.sha256Digest(password+salt);
            if (user.getPassword().equals(password)) {
                return "success";
            } else {
                return "password_error";
            }
        } else {
            return "user_error";
        }
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam("userName") String name, @RequestParam("password") String password) {
        Users users = userService.findUserByName(name);
        //判断是否存在相同的用户名
        if (users != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "exist");
            return jsonObject.toString();
        } else {
            Users user = new Users();
            String salt = UUID.randomUUID().toString();//用UUID生成随机盐
            password = DigestUtil.sha256Digest(password+salt);//加密
            //存入数据库
            user.setUserName(name);
            user.setPassword(password);
            user.setPassword_salt(salt);
            log.info(password);
            userService.addUser(user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "ok");
            return jsonObject.toString();
        }
    }
}
