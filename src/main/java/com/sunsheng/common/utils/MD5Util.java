package com.sunsheng.common.utils;

//import org.apache.commons.codec.digest.DigestUtils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密
 */
public class MD5Util {
//    public static void main(String[] args){
//        MD5Util md5Util = new MD5Util();
//        String pwd = md5Util. md5toPassword("123456");
//        System.out.println(pwd);
//    }

    /**
     * md5多重加密
     * @param sStr
     * @return
     */
    public String getDigestMD5(String sStr){
        String s = sStr;
        for (int i = 0; i < 10; i++) {
            s = DigestUtils.md5Hex(s);
//            System.out.println("-->"+s);
        }
        return s;
    }

    /**
     * 加密密码，默认加密16遍
     * @param sStr
     * @return
     */
    public String md5toPassword(String sStr){
        String s = sStr;
        for (int i = 0; i < 16; i++) {
            s = DigestUtils.md5Hex(s);
        }
        return s;
    }
}
