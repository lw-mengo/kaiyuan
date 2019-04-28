package com.kaiyuan.mengo.kaiyuan.utility;

import java.util.Random;

/**
 * 生成一个8位随机数
 */
public class UIDUtil {

    public static int getUid(){
        Random random = new Random();
        String uid = "";
        for (int i =0;i<8;i++){
            uid+=random.nextInt(10);
        }
        return Integer.parseInt(uid);
    }


}
