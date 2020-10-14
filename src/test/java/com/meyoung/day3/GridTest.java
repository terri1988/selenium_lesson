package com.meyoung.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
//用hub跑test
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
//        创建一个 DesiredCapabilities 类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.3.123:4444/wd/hub"),dc);
        driver.get("https://mail.163.com//");
        Thread.sleep(50000);
        driver.quit();
    }
}
