package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsSelectTest {
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
     * 打开 Open New window
     * 在新页面打开 baidu
     * 再返回老页面
     * */
    @Test
    public void testWinTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(2000);
//      获取driver所在页面的句柄值
        String handle1 = driver.getWindowHandle();
//      for循环判定是否为第一页面句柄如果不是就控制权转交
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
//      将控制权转交给这个页面
            driver.switchTo().window(handles);
        }
//        在新页面打开 baidu
        driver.findElement(By.linkText("baidu")).click();
//        再返回老页面
        driver.switchTo().window(handle1);
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
