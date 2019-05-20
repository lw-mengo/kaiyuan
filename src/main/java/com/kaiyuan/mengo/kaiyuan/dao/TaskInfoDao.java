package com.kaiyuan.mengo.kaiyuan.dao;

import com.kaiyuan.mengo.kaiyuan.entity.TaskInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskInfoDao extends JpaRepository<TaskInfo, Integer> {

    TaskInfo findByTaskid(String taskId);
}
