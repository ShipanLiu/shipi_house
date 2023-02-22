package com.shipi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//因为你要去index页面，所以你 要写一个 controller
@Controller
public class IndexController {

    // go to index.html method


    // 在 / 里面， 有一个 iframe 标签， 发了 /main请求
    @RequestMapping("/")
    public String index() {
        return "frame/index";
    }

    @RequestMapping("/main")
    public String main() {
        return "frame/main";
    }
}
