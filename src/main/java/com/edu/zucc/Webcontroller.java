package com.edu.zucc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liujiapeng on 2018/1/4.
 */
@Controller
@RequestMapping("/")
public class Webcontroller {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
