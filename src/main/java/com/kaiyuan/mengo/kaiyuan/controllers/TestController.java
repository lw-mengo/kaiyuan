package com.kaiyuan.mengo.kaiyuan.controllers;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    @GetMapping("preview")
    public String preview(@RequestParam("fileName") String fileName, Model model) {
        String filePath = "/home/front_dev/upload/" + fileName;//读取文件
        String[] titles;
        try {
            //使用opencsv
            CSVReader reader = new CSVReader(new FileReader(filePath));
            String[] nextLine = reader.readNext();
            List<String[]> list = new ArrayList<>();
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
            return "customization::table_refresh";
        } catch (IOException e) {
            e.printStackTrace();
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
        String filePath = "F:\\upload\\";   //"/home/front_dev/upload/"
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
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        if (file == null || file.isEmpty()) {
            return "file is empty";
        }
        //获取文件名
        //String fileName = file.getOriginalFilename();
        //文件存储路径
        String filePath = "/home/front_dev/upload/" + fileName;
        System.out.println(fileName);
        System.out.println(filePath);
        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
