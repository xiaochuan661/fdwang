package com.mine.product.fdwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {


    //首页配置
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //错误页面配置
    @RequestMapping("/404")
    public String p404(){
        return "404";
    }
    @RequestMapping("/500")
    public String p500(){
        return "500";
    }

    //食材相关页面的配置
    @RequestMapping("/material/add")
    public String materialAdd() {
        return "material/add";
    }
}
