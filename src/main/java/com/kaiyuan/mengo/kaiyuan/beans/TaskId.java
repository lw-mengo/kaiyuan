package com.kaiyuan.mengo.kaiyuan.beans;

public class TaskId {

    private static String taskId;

    public TaskId(String taskId) {
        this.taskId = taskId;
    }

    public static String getTaskId() {
        return taskId;
    }


}
