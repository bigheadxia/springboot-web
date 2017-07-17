import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/7/17 0017
 * Time: 14:34
 */
public class TestCase {

    @Test
    public void checkEnv(){
        //首先打一个hello world来测试一你的IDE里testng的插件是否已经安装好
        //check if you success installed testng on your IDE
        System.out.println("Hello World, TestNG");
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //看看你电脑上能不能正确用firefox driver启动firefox
        //check if firefox driver runs successfully on your computer
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.lairen.com");

    }

    @Test
    public void checkEnv2(){
        //首先打一个hello world来测试一你的IDE里testng的插件是否已经安装好
        //check if you success installed testng on your IDE
        System.out.println("Hello World, TestNG");
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //看看你电脑上能不能正确用firefox driver启动firefox
        //check if firefox driver runs successfully on your computer
        WebDriver driver=new FirefoxDriver();
        WebDriver.Navigation navigation = driver.navigate();//获取浏览器的对象
        navigation.to("http://www.baidu.com");//控制浏览器跳转到http://www.baidu.com
        WebElement baiduTextBox = driver.findElement(By.id("kw"));//获取百度搜索文本框的ID
        baiduTextBox.sendKeys("找到文本框");//在百度搜索文本框中输入 找到文本框
        WebElement loginButton = driver.findElement(By.name("tj_login"));//获取name，与按ID进行查找类似
        loginButton.click();
    }

    @Test
    public void checkEnv3(){
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");

        WebDriver div = new FirefoxDriver();//打开火狐浏览器
        WebDriver.Navigation Rabbit = div.navigate();
        Rabbit.to("http://www.jd.com/");//跳转到京东首页
        WebElement loginButton = div.findElement(By.className("link-login"));//通过clss获取对象
        loginButton.click();//确定
//        WebElement tab = div.findElement(By.className("pageclick|keycount|201607144|2"));
//        System.out.println("-------------------------------------------------------");
//        System.out.println(tab);
//        tab.click();
        WebElement name = div.findElement(By.id("loginname"));//获取账号登录框
        name.sendKeys("HeartIsland");//输入HeartIsland
        WebElement password = div.findElement(By.id("nloginpwd"));//获取密码框
        password.sendKeys("java2015");//输入密码
        WebElement bmit = div.findElement(By.id("loginsubmit"));//获取提交按钮
        bmit.click();//单击确定
        System.out.println("OK");
    }
}
