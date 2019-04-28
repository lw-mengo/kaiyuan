package com.kaiyuan.mengo.kaiyuan.utility;

import java.security.Key;

public class KeyUtil implements Key {
    @Override
    public String getAlgorithm() {
        return "HS256";
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }
}
