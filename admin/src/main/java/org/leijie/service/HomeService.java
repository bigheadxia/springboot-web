package org.leijie.service;

import org.leijie.util.CaptchaUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/9/6 0006
 * Time: 15:44
 */
@RequestScope
@Service
public class HomeService {

    public BufferedImage sendCaptchaVcode(String randomCodeKey ){
        Map<String,Object> map= CaptchaUtil.create(randomCodeKey);
        // TODO 验证码放入缓存 方便后边校验
        return (BufferedImage)map.get("image");
    }
}
