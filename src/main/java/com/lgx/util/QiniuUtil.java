package com.lgx.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.ByteArrayInputStream;


/**
 * 七牛对象存储操作工具类
 */
public class QiniuUtil {
    /**
     * 设置好账号的ACCESS_KEY和SECRET_KEY
     */
    private String ACCESS_KEY = "s0eJJARqdLyOJY4YycB7gVhg5kbpNH5075iRSU6C";
    private String SECRET_KEY = "xOew9fTCNK_bRsvapeI4sdxQVzDkETvnIS2tz9XW";

    /**
     * 要上传的空间
     */
    private String bucketname = "lgx-bucket";

    /**
     * 外链URL
     */
    private String  URL = "http://smallwg.top/";

    /**
     * 密钥配置
     */
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);


    private Zone z = Zone.autoZone();
    private Configuration c = new Configuration(z);


    /**
     * 创建上传对象
     */
    private UploadManager uploadManager = new UploadManager(c);


    /**
     * 上传图片
     */
    public String upload(String key, byte[] imgBytes){
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(imgBytes);
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(bucketname);
            try {
                Response response = uploadManager.put(byteInputStream,key,upToken,null, null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return URL + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (Exception ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return null;
    }
}
