package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
//        全局等待（隐式等待），每一个findElement都会等待10s，如果10s内找到了，就会立刻向下进行
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    /*
     * 打开测试界面
     * 点击wait按钮，全局等待方法
     * 获取文本，并判断是否为“wait for display”
     * */
    @Test
    public void waitTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text, "wait for display");
    }

    /*
     * 打开测试界面
     * 点击wait按钮，显示等待方法（推荐）
     * 获取文本，并判断是否为“wait for display”
     * */
    @Test
    public void waitTest2() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
//      显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text, "wait for display");
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
