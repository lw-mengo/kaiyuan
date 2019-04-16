package com.kaiyuan.mengo.kaiyuan.controllers;

import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import com.kaiyuan.mengo.kaiyuan.services.TaskService;
import com.kaiyuan.mengo.kaiyuan.utility.TaskIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TasksController {
    @Autowired
    private TaskService service;

    /*
    新增一个任务
     */
    @PostMapping("/addNewTask")
    @ResponseBody
    public String addNewTask(@RequestParam("name") String name) {
        String taskId = TaskIdUtil.getUUID();
        String file_path = "test";
        String file_name = "test";
        Tasks tasks = new Tasks();
        tasks.setTaskid(taskId);
        tasks.setCreate_name(name);
        tasks.setFile_name(file_name);
        tasks.setFile_path(file_path);
        tasks.setPayed(true);
        service.addNewTask(tasks);
        return "ok";
    }
}
