package com.kaiyuan.mengo.kaiyuan.dao;

import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<Tasks,Integer> {
    //根据taskid查找任务
    Tasks findByTaskid(String taskId);

    //列出每个用户的所有任务列表&列出每个用户的数据集
    List<Tasks> findAllByCreatedNameOrderById(String created_name);

}
