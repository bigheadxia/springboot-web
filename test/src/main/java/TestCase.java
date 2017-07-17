import org.openqa.selenium.WebDriver;
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

}
