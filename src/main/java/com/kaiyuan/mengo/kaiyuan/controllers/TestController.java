package com.kaiyuan.mengo.kaiyuan.controllers;

import com.kaiyuan.mengo.kaiyuan.utility.JsonFormat;
import com.opencsv.CSVReader;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
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

    @GetMapping("addTest")
    public String addTest(){
        return "test_add";
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("preview")
    public String preview(@RequestParam("fileName") String fileName, Model model) {
        //根据文件名判断是什么类型
        String[] strings = fileName.split("\\.");
        String fileType = strings[1].toLowerCase();
        //如果是csv文件就返回
        if (fileType.equals("csv")) {
            String filePath = "/home/front_dev/upload/" + fileName;//读取文件
            String[] titles;
            model.addAttribute("fileName", fileName);
            try {
                //使用opencsv
                CSVReader reader = new CSVReader(new FileReader(filePath));
                String[] nextLine = reader.readNext();
                List<String[]> list = new ArrayList<>();//一定要初始化
                if (nextLine != null) {
                    titles = nextLine;
                    model.addAttribute("title", titles);
                }
                for (int i = 0; i < 15; i++) {
                    String[] next = reader.readNext();
                    if (next != null) {
                        list.add(next);
                    }
                }
                int length = list.size();
                System.out.println(length);
                model.addAttribute("dataList", list);
                return "preview";
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
            System.out.println(userJson);
            model.addAttribute("userJson", userJson);
            return "temp";
        }
        return "fail";
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

    @PostMapping("/my_upload")
    public String uploadFile(@RequestParam("files") MultipartFile[] files, @RequestParam("fileName") String[] fileName) {
        if (files == null || files.length == 0) {
            return "fail";
        }
        //获取文件名
        //String fileName = file.getOriginalFilename();
        //文件存储路径
        for (int i = 0; i < files.length; i++) {
            String filePath = "/home/front_dev/upload/" + fileName[i];//"F:\\upload\\"
            System.out.println(fileName[i]);
            System.out.println(filePath);
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
        return "fail";
    }
}
