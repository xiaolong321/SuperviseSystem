package com.wy.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Administrator on 2017/2/22.
 */
public class MD5Util {
    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString() ;
    }
}
