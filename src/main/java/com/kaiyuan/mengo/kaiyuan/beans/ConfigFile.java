package com.kaiyuan.mengo.kaiyuan.beans;

/*
配置文件的属性，
最终要写入一个.conf的文件
 */

public class ConfigFile {

    private String searchName;//搜索时使用的字段
    private String nodeTitle;//节点标题
    private String nodeAttribute;//节点度的属性名
    private String nodeImageAttribute;//节点图片的属性名

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
