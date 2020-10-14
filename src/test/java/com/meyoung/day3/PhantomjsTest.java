package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomjsTest {

//     PhantomJS是一个无界面的,可脚本编程的WebKit浏览器引擎
    @Test
    public void pjsTest() throws InterruptedException {
//        设置 phantomjs driver 路径
        System.setProperty("phantomjs.binary.path", "D:\\java-workspace\\SeleniumIDEA\\drivers\\phantomjs.exe");
//        打开 PhantomJS 浏览器
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String a = driver.getTitle();
        System.out.println(a);
        driver.quit();
    }
}
