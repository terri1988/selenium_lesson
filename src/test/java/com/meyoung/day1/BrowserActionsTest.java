package com.meyoung.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsTest {
    //    创建公共参数 driver，每个test里都可以直接调用，并且可以在@AfterMethod里直接调用并关闭
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
    }

    //打开百度首页
    @Test
    public void getTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
    }

    //后退
    @Test
    public void backTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
//        浏览器后退
        driver.navigate().back();
    }

    //前进
    @Test
    public void forwardTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
//        等待3s浏览器后退
        Thread.sleep(3000);
        driver.navigate().back();

//        等待3s浏览器前进
        Thread.sleep(3000);
        driver.navigate().forward();
    }

    //刷新
    @Test
    public void refreshTest() throws InterruptedException {
//        打开Google首页
        driver.get("https://www.google.cn");
//        等待3s浏览器刷新
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    //设置浏览器大小 300*300和最大化浏览器
    @Test
    public void winTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
//        实例化dimension，设置浏览器大小 500*600
        Dimension dimension = new Dimension(300, 300);
        driver.manage().window().setSize(dimension);
//        等待3s最大化浏览器
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    //获取当前页面URL，校验当前页面URL是不是百度地址
    @Test
    public void getURLTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
//        获取当前页面URL
        String url = driver.getCurrentUrl();
        System.out.println("Current URL is " + url);
//        校验当前页面URL是不是百度地址
        Assert.assertEquals(url, "https://www.baidu.com/", "Current url is not baidu");
    }

    //获取当前页面title
    @Test
    public void getTitleTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
//        获取当前页面URL
        String title = driver.getTitle();
        System.out.println("Current title is " + title);
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
//        等待5s
        Thread.sleep(5000);
        driver.quit();
    }
}
