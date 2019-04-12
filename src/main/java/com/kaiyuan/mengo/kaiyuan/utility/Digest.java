package com.kaiyuan.mengo.kaiyuan.utility;

import org.apache.tomcat.util.buf.HexUtils;

import java.security.MessageDigest;

public class Digest {
    /**
     *
     * @param str 明文密码字符串
     * @param alg 加密方式
     * @param charencoding 编码格式
     * @return 加密后的hash值
     */
    public static String digest(String str, String alg, String charencoding) {
        try {
            byte[] data = str.getBytes(charencoding);
            MessageDigest md = MessageDigest.getInstance(alg);
            return HexUtils.toHexString(md.digest(data));
        } catch (Exception e) {
            throw new RuntimeException("digest fail!", e);
        }
    }
}
