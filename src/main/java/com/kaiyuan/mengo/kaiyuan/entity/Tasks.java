package com.kaiyuan.mengo.kaiyuan.entity;

import javax.persistence.*;

@Entity
@Table(name = "task_table")
public class Tasks {
    @Id
    @GeneratedValue
    private int id;

    private String taskid;

    @Column(name = "created_name")
    private String createdName;

    private String file_path;

    private String file_name;

    private int uid;

    private boolean payed;
    private String cypher;

    public String getCypher() {
        return cypher;
    }

    public void setCypher(String cypher) {
        this.cypher = cypher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getCreated_name() {
        return createdName;
    }

    public void setCreated_name(String created_name) {
        this.createdName = created_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

}
