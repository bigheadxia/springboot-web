package org.leijie.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

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
//        return "web/web";
//    }

    @Value("${application.message}")
    private String message = "Hello World";

//    @RequestMapping("/")
//    public String web(Model model){
//        model.addAttribute("time",new Date());
//        model.addAttribute("message",message);
//        return "web/web";
//    }

    @RequestMapping("/")
    public String web(Model model){
        model.addAttribute("time",new Date());
        model.addAttribute("message",message);
        return "web/web2";
    }
    static int i = 1;
    @RequestMapping("/call")
    public void callback(HttpServletResponse response, @RequestParam int id) throws IOException, InterruptedException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        Random random = new Random();
        System.out.println("-----------"+i+"--------id="+id+"-----");
        Thread.sleep(5000);
        writer.write("data: 您有3条未指派订单，请及时处理！"+"\n\n");
        i++;
        writer.close();
    }
}
