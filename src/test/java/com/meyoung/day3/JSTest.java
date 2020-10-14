package com.meyoung.day3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
//        全局等待（隐式等待），每一个findElement都会等待10s，如果10s内找到了，就会立刻向下进行
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*
     * 打开百度首页
     * 用js的方法改文本框value的值
     * js可以修改前端的校验
     * */
    @Test
    public void exJSTest() throws InterruptedException {
//       打开百度首页
        driver.get("https://www.baidu.com");
//
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //直接在下面操作value的值，执行js脚本,在id为search=key的地方把value的值输入“selenium怎么学”
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"selenium怎么学\")");
        Thread.sleep(5000);
        driver.quit();
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
