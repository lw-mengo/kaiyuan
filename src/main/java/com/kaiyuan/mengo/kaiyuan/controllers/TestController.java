package com.kaiyuan.mengo.kaiyuan.controllers;

import DrawSDK.Handler;
import com.google.gson.Gson;
import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import com.kaiyuan.mengo.kaiyuan.entity.Users;
import com.kaiyuan.mengo.kaiyuan.services.TaskInfoService;
import com.kaiyuan.mengo.kaiyuan.services.TaskService;
import com.kaiyuan.mengo.kaiyuan.services.UserGalleryService;
import com.kaiyuan.mengo.kaiyuan.services.UserService;
import com.kaiyuan.mengo.kaiyuan.utility.CommonResult;
import com.kaiyuan.mengo.kaiyuan.utility.JsonFormat;
import com.kaiyuan.mengo.kaiyuan.utility.TaskIdUtil;
import com.opencsv.CSVReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserGalleryService userGalleryService;
    @Autowired
    private TaskInfoService taskInfoService;

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("tryout")
    public String tryout() {
        return "tryout";
    }

    @RequestMapping("result")
    public String result() {
        return "result";
    }

    @RequestMapping("result_step")
    public String result_step() {
        return "result_step";
    }

    @RequestMapping("result_relation")
    public String result_relation() {
        return "result_relation";
    }

    @RequestMapping("result_community")
    public String result_community() {
        return "result_community";
    }

    @RequestMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("product")
    public String product() {
        return "result_community";
    }

    @GetMapping("customization")
    public String customization() {
        return "customization";
    }

    /*
    注册页面
     */
    @GetMapping("register")
    public String register() {
        return "register";
    }

    /**
     * 预览文件请求
     */
    @GetMapping("preview")
    @ResponseBody
    public String preview(@RequestParam("fileName") String fileName) {
        //根据文件名判断是什么类型
        String[] strings = fileName.split("\\.");
        String fileType = strings[1].toLowerCase();
        //如果是csv文件就返回
        if (fileType.equals("csv")) {
            String filePath = "/home/front_dev/upload/" + fileName;//读取文件
            String[] titles;
            //  model.addAttribute("fileName", fileName);
            try {
                //使用opencsv
                CSVReader reader = new CSVReader(new FileReader(filePath));
                String[] nextLine = reader.readNext();
                List<String[]> list = new ArrayList<>();//一定要初始化
                if (nextLine != null) {
                    titles = nextLine;
                    String[] title = titles;
                    list.add(title);

                    //     model.addAttribute("title", titles);
                }
                for (int i = 0; i < 15; i++) {
                    String[] next = reader.readNext();
                    if (next != null) {
                        list.add(next);
                    }
                }
                //   int length = list.size();
                //    model.addAttribute("dataList", list);
                return new Gson().toJson(list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //否则就是json文件
            String filePath = "/home/front_dev/upload/" + fileName;//读取文件
            String string = "";
            try {
                FileInputStream inputStream = new FileInputStream(filePath);
                InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader br = new BufferedReader(reader);
                String s = "";
                while ((s = br.readLine()) != null) {
                    string += s;
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = new JSONObject(string);
            String userJson = JsonFormat.format(jsonObject.toString());
            //   model.addAttribute("userJson", userJson);
            return userJson;
            //return "temp";
        }
        return CommonResult.fail();
    }

    @GetMapping("customization_browse")
    public String customizationBrowse() {
        return "customization_browse";
    }

    @GetMapping("customization_mission")
    public String customizationMission() {
        return "customization_mission";
    }

    @GetMapping("customization_result")
    public String customizationResult() {
        return "customization_result";
    }


    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "fail";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/home/front_dev/upload/";   //"/home/front_dev/upload/"
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "forward:result";
        } catch (Exception e) {
            System.out.println("failed");
        }
        return "upload not success";

    }

    @GetMapping("/custom_upload")
    public String custom_upload() {
        return "temp";
    }

    /**
     * 上传文件接收
     *
     * @param files     文件
     * @param fileName  文件名
     * @param cypherStr cypher查询语句
     */
    @PostMapping("/my_upload")
    @ResponseBody
    public String uploadFile(@RequestParam("files") MultipartFile[] files, @RequestParam("fileName") String[] fileName,
                             String cypherStr, HttpServletRequest request) {

        String file_name = "";
        String temp = fileName[0].split("\\.")[1].toLowerCase();
        if (temp == "csv") {
            if (files.length < 1) {
                return CommonResult.fail("need two csv files");
            }
        }
        if (files == null || files.length == 0) {
            return CommonResult.fail("can not be null");
        } else {
            //获取文件名
            //String fileName = file.getOriginalFilename();
            //文件存储路径
            for (int i = 0; i < files.length; i++) {
                String filePath = "/home/front_dev/upload/" + fileName[i];//"F:\\upload\\"
                file_name += fileName[i] + ",";
                File dest = new File(filePath);
                MultipartFile file = files[i];
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            System.out.println(file_name);
            String name = request.getAttribute("username").toString();
            Users users = userService.findUserByName(name);
            Tasks task = new Tasks();
//            TaskInfo taskInfo = new TaskInfo();
            String taskId = TaskIdUtil.getUUID();
            task.setTaskid(taskId);
            task.setCreated_name(name);
            task.setFile_path("/home/front_dev/upload/");
            if (files.length == 1) {
                task.setFile_name(fileName[0]);
            } else {
                task.setFile_name(file_name);
            }
            task.setCypher(cypherStr);
            task.setUid(users.getUid());
//            Handler handler = new Handler(taskId);//暂时不需要
//            taskInfo.setInfo(handler.getInfo());
//            taskInfo.setTaskid(taskId);
//            taskInfoService.add(taskInfo);
            taskService.addNewTask(task);//保存到task数据库
            log.info(cypherStr);
            if (cypherStr != null) {
                log.info(" execute cvs method");
                userGalleryService.saveResult(taskId, name, cypherStr);
            } else {
                log.info(" execute json method");
                cypherStr = "/home/front_dev/upload/" + fileName[0];
                userGalleryService.saveResult(taskId, name, cypherStr);
            }

//            handler.uploadData(fileName, cypherStr);

            return CommonResult.success(taskId);//返回数据里带有taskID给前端
        }
    }


    //以下均为测试页面
    @GetMapping("addTest")
    public String addTest() {
        return "test_add";
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("addTask")
    public String addTask() {
        return "add_task";
    }


}
