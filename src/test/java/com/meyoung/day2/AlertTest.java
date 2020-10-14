package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
    }

    /*
     * 打开“UI自动化测试”主页
     * 点击Alert按钮
     * 在alert警告框点击确定按钮
     * */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Thread.sleep(2000);
//        把driver的控制权转交给alert
        Alert alert = driver.switchTo().alert();
//        获取警告框的文本
        String text = alert.getText();
//        在alert上点击确认按钮
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    /*
     * 打开“UI自动化测试”主页
     * 点击Confirm按钮
     * 在Confirm警告框点击取消按钮
     * 再次点击确定按钮
     * */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(2000);
//        把driver的控制权转交给alert
        Alert alert = driver.switchTo().alert();
//        在alert上点击取消按钮
        alert.dismiss();
        Thread.sleep(2000);
//        再次点击确定按钮
        alert.accept();
    }

    /*
     *  打开“UI自动化测试”主页
     * 点击Prompt按钮
     * 在Prompt 弹窗中，输入“这个是Prompt”
     * 点击确定按钮
     * 再次点击确定按钮
     * */
    @Test
    public void promptTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
//        把driver的控制权转交给alert
        Alert alert = driver.switchTo().alert();
//        在Prompt 弹窗中，输入“这个是Prompt”
        alert.sendKeys("this is prompt");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
//        再次点击确定按钮
        alert.accept();
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
