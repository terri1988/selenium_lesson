package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClosedBrowserTest {

    @Test
    public void closedChrome1() throws InterruptedException {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        WebDriver driver = new ChromeDriver();
//        等待5s
        Thread.sleep(5000);
//        关闭浏览器当前窗口
        driver.close();

    }

    @Test
    public void closedChrome2() throws InterruptedException {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        WebDriver driver = new ChromeDriver();
//        等待5s
        Thread.sleep(5000);
//        完全退出浏览器（推荐使用）
        driver.quit();

    }
}
