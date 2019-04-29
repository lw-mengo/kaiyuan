package com.kaiyuan.mengo.kaiyuan.dao;

import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Tasks,Integer> {
    //根据taskid查找任务
    Tasks findByTaskid(String taskId);
}
