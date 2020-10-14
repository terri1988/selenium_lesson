package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

//打开浏览器
public class OpenBrowserTest {

    @Test
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }

//    @Test
//    public void openFirefox() {
//        System.setProperty("webdriver.gecko.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//
//    }
}
