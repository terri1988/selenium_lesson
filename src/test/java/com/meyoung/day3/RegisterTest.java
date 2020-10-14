package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class RegisterTest {
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
     * 打开163邮箱
     * 注册一个新账号
     * */
    @Test
    public void registerMailTest() throws InterruptedException, AWTException {
        driver.get("https://mail.163.com//");
        driver.findElement(By.linkText("注册网易邮箱")).click();
        Thread.sleep(2000);
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            } else {
                driver.switchTo().window(handles);
            }
        }
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[4]/span"));
        element.click();
//      以时间戳赋值 username
        String username = String.valueOf(System.currentTimeMillis());
//      以时间戳赋值 phone: 除以1000是秒级
        String phone = String.valueOf(System.currentTimeMillis()/1000);

        driver.findElement(By.id("username")).sendKeys("a"+username);
        driver.findElement(By.id("password")).sendKeys("aaaaa88888");
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.manage().window().maximize();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[5]/a[1]")).click();

    }

    /*
     * 以时间戳赋值的 随机数
     * */
    @Test
    public void randomTest() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
