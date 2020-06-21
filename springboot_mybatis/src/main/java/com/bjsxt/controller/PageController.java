package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//实现页面跳转controller
@Controller

public class PageController {
    //页面跳转方法
    @RequestMapping("/{page}")//restful风格
    public  String  showpages(String page){
        System.out.println("----------------运行到这了---------------page=");
        return  "page";
    }
}
