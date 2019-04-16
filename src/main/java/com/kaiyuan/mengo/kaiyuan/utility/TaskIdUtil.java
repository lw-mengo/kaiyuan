package com.kaiyuan.mengo.kaiyuan.utility;

import java.util.UUID;

/*
生成指定位数的UUID
标准 UUID是8+4+4+4+12
截取即可
 */
public class TaskIdUtil {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String[] taskId = uuid.toString().split("-");
        return  taskId[0];
    }

}
