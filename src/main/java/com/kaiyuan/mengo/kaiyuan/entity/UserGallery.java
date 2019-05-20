package com.kaiyuan.mengo.kaiyuan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_gallery")
public class UserGallery {


    private int id;

    private String username;
    private String result_url;
    private String image_url;
    private String result_type;
    private Timestamp created_time;
    private int uid;
    private String preview;
    private String preview_online;
    private String taskid;

    private String app1;
    private String app2;
    private String app3;
    private String app4;
    private String app5;
    private String app6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResult_url() {
        return result_url;
    }

    public void setResult_url(String result_url) {
        this.result_url = result_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getPreview_online() {
        return preview_online;
    }

    public void setPreview_online(String preview_online) {
        this.preview_online = preview_online;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getResult_type() {
        return result_type;
    }

    public void setResult_type(String result_type) {
        this.result_type = result_type;
    }

    public String getApp1() {
        return app1;
    }

    public void setApp1(String app1) {
        this.app1 = app1;
    }

    public String getApp2() {
        return app2;
    }

    public void setApp2(String app2) {
        this.app2 = app2;
    }

    public String getApp3() {
        return app3;
    }

    public void setApp3(String app3) {
        this.app3 = app3;
    }

    public String getApp4() {
        return app4;
    }

    public void setApp4(String app4) {
        this.app4 = app4;
    }

    public String getApp5() {
        return app5;
    }

    public void setApp5(String app5) {
        this.app5 = app5;
    }

    public String getApp6() {
        return app6;
    }

    public void setApp6(String app6) {
        this.app6 = app6;
    }
}
