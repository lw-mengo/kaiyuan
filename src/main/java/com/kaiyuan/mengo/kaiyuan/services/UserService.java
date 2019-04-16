package com.kaiyuan.mengo.kaiyuan.services;

import com.kaiyuan.mengo.kaiyuan.dao.UserDao;
import com.kaiyuan.mengo.kaiyuan.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    /*
    增加一个用户，用户注册时使用
     */
    public void addUser(Users user){
        userDao.save(user);
    }

    /*
    删除用户，管理员使用
     */

    /*
    查询所有用户，管理员使用
     */

    /*
    修改用户密码
     */

    /*
    根据用户名查找，登录检查使用
     */
    public Users findUserByName(String name){
        return userDao.findByUserName(name);
    }



}
