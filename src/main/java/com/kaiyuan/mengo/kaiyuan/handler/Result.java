package com.kaiyuan.mengo.kaiyuan.handler;

/**
 * 异常处理，封装一个统一的返回数据
 */
public class Result {

    private boolean success;//成功为true
    private String msg;//错误消息或提示
    private Object data;

    public Result() {
        this.success = true;
        this.msg = "";
        this.data = null;
    }

    public Result(Object data) {
        this.success = true;
        this.msg = "";
        this.data = data;
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
        this.data = null;
    }

    public Result(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
