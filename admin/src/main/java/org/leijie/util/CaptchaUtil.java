package org.leijie.util;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 生成验证码
 * @author LEE
 * 2014年9月11日
 */
public class CaptchaUtil {

	public static final String CAPTCHA_INPUT_NAME = "j_captcha";// 验证码输入表单名称
	public static final String CAPTCHA_IMAGE_URL = "/captcha.jpg";// 验证码图片URL
	public static final Integer IMAGE_HEIGHT = 41;// 验证码图片高度
	public static final Integer IMAGE_WIDTH = 79;// 验证码图片宽度
	public static final Integer MIN_FONT_SIZE = 18;// 验证码最小字体
	public static final String RANDOM_WORD = "123456789";// 随机字符
//	public static final String IMAGE_PATH =  ClassLoader.getSystemResource("captcha").getPath();// 随机背景图片路径
	public static final String IMAGE_PATH =  "/captcha/";// 随机背景图片路径
	public static final int CAPTCHA_EXCEED_TIME = 60;//图形验证码过期时间s

	public  static List<BufferedImage> images= Lists.newArrayList();

	
	// 验证码随机字体
	public  static final Font[] RANDOM_FONT = new Font[] {
			new Font("nyala", Font.BOLD, MIN_FONT_SIZE), 
			new Font("Arial", Font.BOLD, MIN_FONT_SIZE),
			new Font("Bell MT", Font.BOLD, MIN_FONT_SIZE), 
			new Font("Credit valley", Font.BOLD, MIN_FONT_SIZE),
			new Font("Impact", Font.BOLD, MIN_FONT_SIZE) 
	};

	// 验证码随机颜色
	public static  final Color[] RANDOM_COLOR = new Color[] {
			new Color(255, 255, 255), 
			new Color(255, 220, 220), 
			new Color(220, 255, 255), 
			new Color(220, 220, 255),
			new Color(255, 255, 220), 
			new Color(220, 255, 220) 
	};

	public static Map<String,Object> create(String randomCodeKey){
		if(CaptchaUtil.images.isEmpty()){
			File dir=new File(IMAGE_PATH);
			if(dir!=null){
				File[] fileList=dir.listFiles();
				for(File file:fileList){
					try {
						BufferedImage image= ImageIO.read(file);
						if(image!=null){
							images.add(image);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		BufferedImage bg= getRandBackgrount();
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();// 获取图形上下文
		Random random = new Random();//生成随机类
		g.drawImage(bg, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT,null);
		String sRand="";// 取随机产生的认证码(4位数字)
		for (int i=0;i<4;i++){
			int a=random.nextInt(RANDOM_WORD.length()-1);
			String rand=RANDOM_WORD.substring(a,a+1);
			sRand=sRand.concat(rand);
			g.setColor(getRandColor());
			g.setFont(getRandFont());
			g.drawString(rand,16*i+6,30);
		}
		return ImmutableMap.of("image",image,"sRand",sRand);
	}

	/**
	 * 随机背景图片
	 * @return
	 */
	public static BufferedImage getRandBackgrount() {
		Random random = new Random();
		return images.get(random.nextInt(images.size()));
	}
	/**
	 * 随机颜色
	 * @return
	 */
	public static Color getRandColor() {
		Random random = new Random();
		return RANDOM_COLOR[random.nextInt(RANDOM_COLOR.length)];
	}
	/**
	 * 随机字体
	 * @return
	 */
	public static Font getRandFont(){
		Random random = new Random();
		return RANDOM_FONT[random.nextInt(RANDOM_FONT.length)];
	}

}
