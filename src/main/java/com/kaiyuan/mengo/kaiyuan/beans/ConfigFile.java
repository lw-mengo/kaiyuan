package com.kaiyuan.mengo.kaiyuan.beans;

/*
配置文件的属性，
最终要写入一个.conf的文件
 */

public class ConfigFile {

    private String searchName;
    private String nodeTitle;
    private String nodeAttribute;
    private String nodeImageAttribute;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }

    public String getNodeAttribute() {
        return nodeAttribute;
    }

    public void setNodeAttribute(String nodeAttribute) {
        this.nodeAttribute = nodeAttribute;
    }

    public String getNodeImageAttribute() {
        return nodeImageAttribute;
    }

    public void setNodeImageAttribute(String nodeImageAttribute) {
        this.nodeImageAttribute = nodeImageAttribute;
    }
}
