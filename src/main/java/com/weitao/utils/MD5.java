package com.weitao.utils;

import org.springframework.util.DigestUtils;

/**
 * Created by lzr on 2018/9/4.
 */
public class MD5 {
    public static String md5(String text)
    {
        String encodeStr= DigestUtils.md5DigestAsHex(text.getBytes());
        return encodeStr;
    }
}
