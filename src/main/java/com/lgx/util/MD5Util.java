package com.lgx.util;

import java.util.UUID;

/**
 * @author LGX_TvT
 * @date 2019-01-19 23:59
 */
public class MD5Util {

    public static String getUUIDName(String fileName){
        return UUID.randomUUID().toString().replaceAll("-","") + fileName.substring(fileName.indexOf("."));
    }
}
