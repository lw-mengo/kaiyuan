package com.kaiyuan.mengo.kaiyuan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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
    public String result_community(){
        return "result_community";
    }

    @RequestMapping("about")
    public String about(){
        return "about_new";
    }

    @GetMapping("product")
    public String product(){
        return "result_community";
    }

    @GetMapping("customization")
    public String customization(){
        return "customization";
    }
    @GetMapping("customization_browse")
    public String customizationBrowse(){
        return "customization_browse";
    }

    @GetMapping("customization_mission")
    public String customizationMission(){
        return "customization_mission";
    }

    @GetMapping("customization_result")
    public String customizationResult(){
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
}
