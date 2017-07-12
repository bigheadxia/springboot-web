package org.leijie.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/7/12 0012
 * Time: 10:17
 */
@Controller
public class WebController {

//    @RequestMapping("/")
//    public String web(Map<String,Object> model){
//        model.put("time",new Date());
//        model.put("message","测试");
//        return "admin/web";
//    }

    @Value("${application.message}")
    private String message = "Hello World";

//    @RequestMapping("/")
//    public String web(Model model){
//        model.addAttribute("time",new Date());
//        model.addAttribute("message",message);
//        return "admin/web";
//    }

    @RequestMapping("/")
    public String web(Model model){
        model.addAttribute("time",new Date());
        model.addAttribute("message",message);
        return "admin/web2";
    }
}