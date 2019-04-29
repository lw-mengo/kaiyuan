package com.kaiyuan.mengo.kaiyuan.services;

import com.kaiyuan.mengo.kaiyuan.dao.TaskDao;
import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskDao taskDao;

    /*
    新增一个任务
     */
    public void addNewTask(Tasks tasks){
        taskDao.save(tasks);
    }

    /*
    查找一个任务
     */

    public Tasks findTask(String taskId){
        return taskDao.findByTaskid(taskId);
    }
}
