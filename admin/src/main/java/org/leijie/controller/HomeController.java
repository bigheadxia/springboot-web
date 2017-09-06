package org.leijie.controller;

import org.leijie.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/7/13 0013
 * Time: 16:37
 */
@Controller
public class HomeController {
    private final Logger LOGGER = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private HomeService homeService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/send-captcha-vcode", method = RequestMethod.GET)
    public Object sendCaptchaVcode(@RequestParam("r") String r, HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream sos = null;
        try {
            sos = response.getOutputStream();
            BufferedImage challenge = homeService.sendCaptchaVcode(r);
            ImageIO.write(challenge, "jpg", sos);
            sos.flush();
        } catch (Exception e) {
            LOGGER.error("--sendCaptchaVcode--",e);
        } finally {
            if (sos != null){
                try {
                    sos.close();
                } catch (IOException e) {
                    LOGGER.error("--sendCaptchaVcode--",e);
                }
            }
        }
        return null;
    }
}
