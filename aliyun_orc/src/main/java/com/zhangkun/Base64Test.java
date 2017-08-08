package com.zhangkun;

import com.aliyuncs.utils.Base64Helper;

import java.io.UnsupportedEncodingException;

/**
 * Created by zk on 2017/8/8.
 */
public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String string = "pan zhang";
        String encode = Base64Helper.encode(string, "utf-8");
        System.out.println(encode);
        System.out.println(Base64Helper.decode(encode, "utf8"));
    }
}
