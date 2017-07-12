package org.tdcg.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/7/12 0012
 * Time: 09:29
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "";
    }

}
