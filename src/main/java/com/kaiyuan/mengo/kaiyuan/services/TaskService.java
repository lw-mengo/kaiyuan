package com.kaiyuan.mengo.kaiyuan.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaiyuan.mengo.kaiyuan.dao.TaskDao;
import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskDao taskDao;

    /*
    新增一个任务
     */
    public void addNewTask(Tasks tasks) {
        taskDao.save(tasks);
    }

    /*
    查找一个任务
     */
    public Tasks findTask(String taskId) {
        return taskDao.findByTaskid(taskId);
    }

    /**
     * 列出每个用户的所有任务
     */

    public String listAllTasks(String name) {
        List<Tasks> tasksList = taskDao.findAllByCreatedNameOrderById(name);
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(tasksList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
