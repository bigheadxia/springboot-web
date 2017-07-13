package org.leijie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/7/13 0013
 * Time: 16:37
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
