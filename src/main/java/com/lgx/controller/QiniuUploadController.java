package com.lgx.controller;

import com.lgx.util.MD5Util;
import com.lgx.util.QiniuUtil;
import com.lgx.vo.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LGX_TvT
 * @date 2019-01-19 23:29
 */
@Controller
public class QiniuUploadController {


    /**
     * 七牛云上传
     */
    @RequestMapping(value = "/QiniuUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo QiniuUpload(@RequestParam("file") MultipartFile image) {
        System.out.println(image.getContentType());
        ResultInfo result = new ResultInfo();
        if (image.isEmpty()) {
            result.setCode(400);
            result.setMsg("文件为空，请重新上传");
            return result;
        }

        try {
            //使用base64方式上传到七牛云
            String info = new QiniuUtil().upload(MD5Util.getUUIDName(image.getResource().getFilename()), image.getBytes());
            result.setCode(200);
            result.setMsg("文件上传成功");
            result.setInfo(info);
            return result;
        } catch (Exception e) {
            result.setCode(500);
            result.setMsg("文件上传发生异常！");
            return result;
        }
    }

}
