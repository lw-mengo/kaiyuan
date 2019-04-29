package com.kaiyuan.mengo.kaiyuan.controllers;

import com.kaiyuan.mengo.kaiyuan.beans.ConfigFile;
import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import com.kaiyuan.mengo.kaiyuan.services.TaskService;
import com.kaiyuan.mengo.kaiyuan.utility.CommonResult;
import com.kaiyuan.mengo.kaiyuan.utility.TaskIdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class TasksController {
    @Autowired
    private TaskService service;

    private Logger  logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 向数据库增加一个任务
     * @param name  增加任务的用户名
     * @return 返回状态 成功
     */
    @PostMapping("/addNewTask")
    @ResponseBody
    public String addNewTask(@RequestParam("name") String name) {
        String taskId = TaskIdUtil.getUUID();
        String file_path = "test";
        String file_name = "test";
        Tasks tasks = new Tasks();
        tasks.setTaskid(taskId);
        tasks.setCreated_name(name);
        tasks.setFile_name(file_name);
        tasks.setFile_path(file_path);
        tasks.setPayed(true);
        service.addNewTask(tasks);
        return "ok";
    }

    /**
     * @param configFile 需要这个实例里的四个参数
     * @return 返回成功与否的json
     */
    @PostMapping("getConfig")
    @ResponseBody
    public String getConfig(@RequestBody ConfigFile configFile){
        if (configFile!=null){
            logger.info(configFile.getNodeAttribute());
            return CommonResult.success();
        }else {
            return CommonResult.fail();
        }

    }

    /*
      TODO-查找任务
     */
}
