package com.kaiyuan.mengo.kaiyuan.services;

import com.kaiyuan.mengo.kaiyuan.dao.TaskInfoDao;
import com.kaiyuan.mengo.kaiyuan.entity.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskInfoService {
    @Autowired
    private TaskInfoDao infoDao;

    public String getTaskInfo(String taskId) {
        TaskInfo taskInfo = infoDao.findByTaskid(taskId);
        return taskInfo.getInfo();
    }


    public void add(TaskInfo taskInfo){
       infoDao.save(taskInfo);
    }
}
