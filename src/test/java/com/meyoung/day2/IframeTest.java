package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
    }

    /*
     * 打开测试界面
     * driver控制权交给iFrame
     * 点击iframe内的百度链接
     * driver控制权交回原页面
     * 点击外部“登录界面”
     * */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
//      driver控制权交给iFrame
//      通过ID或者Name方式转交控制权
//        driver.switchTo().frame("aa");
//        通过webelement方式转交控制权
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
//        driver控制权交回原页面
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
