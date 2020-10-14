package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
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
     * 下拉框选择vivo
     * 第二次选择huawei
     * 第三次选择iphone
     * */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        WebElement selectEl = driver.findElement(By.id("moreSelect"));
//        实例化 Select 类
        Select select = new Select(selectEl);
//       下拉框选择vivo: selectByIndex
        select.selectByIndex(2);
        Thread.sleep(2000);
//       第二次选择huawei: selectByValue
        select.selectByValue("huawei");
        Thread.sleep(2000);
//       第三次选择iphone: selectByVisibleText
        select.selectByVisibleText("iphone");
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
