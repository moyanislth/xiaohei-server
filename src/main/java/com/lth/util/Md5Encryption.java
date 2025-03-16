package com.lth.util;

import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;

public class Md5Encryption {
    /**
     * 使用Guava标准包的MD5加密工具
     * @param input 待加密的字符串
     * @return 返回加密后的字符串
     */
    public static String generateMD5(String input) throws UnsupportedEncodingException {
        //获取MD5机密实例
        return Hashing.md5().hashBytes(input.getBytes("UTF-8")).toString();
    }

}
