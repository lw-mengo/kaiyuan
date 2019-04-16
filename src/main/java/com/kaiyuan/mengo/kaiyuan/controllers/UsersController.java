package com.kaiyuan.mengo.kaiyuan.controllers;

import com.kaiyuan.mengo.kaiyuan.entity.Users;
import com.kaiyuan.mengo.kaiyuan.services.UserService;
import com.kaiyuan.mengo.kaiyuan.utility.DigestUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class UsersController {
    public static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    /*
    用户登录action
     */
    @PostMapping(value = "/loginAction")
    public String findUserByName(@RequestParam(name = "userName") String name, @RequestParam(name = "password") String password, HttpServletRequest request) {
        Users user = userService.findUserByName(name);
        if (user != null) {
            //必须解析密码
            String salt = user.getPassword_salt();
            password = DigestUtil.sha256Digest(password+salt);
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();//如果有session，就获取。没有就创建session
                session.setAttribute("userName",user.getUserName());
                session.setMaxInactiveInterval(30*60);//session有效时间，30分钟
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "success");
               // return "success";
                return jsonObject.toString();
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", "password_error");
              //  return "password_error";//密码错误
                return jsonObject.toString();
            }
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "user_error");
          //  return "user_error";//用户不存在
            return jsonObject.toString();
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
            userService.addUser(user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "ok");
            return jsonObject.toString();
        }
    }
}
