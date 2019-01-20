package com.lgx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制层
 * @author LGX_TvT
 * @date 2019-01-19 21:22
 */
@Controller
public class PageController {


    /**
     * 跳转到主页面
     */
    @RequestMapping("/index")
    public String hello(){
        return "/index";
    }
}
