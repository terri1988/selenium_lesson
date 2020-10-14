/*
* 元素定位优先级 ID (非随机数)> Name > Xpath > 其他
* */
package com.meyoung.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
    }

//    定位 byID:唯一
//    如果 ID 内包含随机数，则不要用ID定位元素，因为ID是随时变化的
    @Test
    public void byIDTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位搜索文本框
        WebElement keyField = driver.findElement(By.id("kw"));
    }

    //    定位 byName：不唯一，需查重
    @Test
    public void byNameTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位搜索文本框
        WebElement keyField = driver.findElement(By.name("wd"));
    }

    //    定位 byclassName：不唯一，需查重
    @Test
    public void byClassNameTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位“换一换”
        WebElement keyField = driver.findElement(By.className("hot-refresh-text"));
    }

    //    定位 byLinkText：必须是<a>标签里的linktext才支持
    @Test
    public void byLinkTextTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位“地图”
        WebElement keyField = driver.findElement(By.linkText("地图"));
    }

    //    定位 byPartialLinkText：必须是<a>标签里的Partiallinktext才支持
    @Test
    public void byPartialLinkTextTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位“地图”
        WebElement keyField = driver.findElement(By.partialLinkText("地"));
    }

    //    定位 byTagName：放入列表
    @Test
    public void bytagNameTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位tagName=“input”
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }

    //    定位 byXpath：尽量用相对路径
    @Test
    public void byXpathTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位"百度一下"按钮
        driver.findElement(By.xpath("//*[@id=\"su\"]"));
    }

    //    定位一组元素 byXpath: index 从零开始
    @Test
    public void byXpathListTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位百度首页左上角一组元素
        List<WebElement> XpathList = driver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
//        打印列表第一个元素
        String text = XpathList.get(0).getText();
        System.out.println(text);
//      将列表所有元素全部打印
        for (int i = 0; i < XpathList.size(); i++) {
            String textlist = XpathList.get(i).getText();
            System.out.println(textlist);
        }

    }

    //    定位 byCSS
    @Test
    public void byCSSTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      定位百度图片
        driver.findElement(By.cssSelector("#lg > map > area"));
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
