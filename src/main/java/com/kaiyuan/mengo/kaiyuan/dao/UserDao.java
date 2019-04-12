package com.kaiyuan.mengo.kaiyuan.dao;

import com.kaiyuan.mengo.kaiyuan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users,Integer> {
    //根据用户名查询数据库

     Users findByUserName(String name);
}
