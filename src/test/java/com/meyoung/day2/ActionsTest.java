//部分case失败是因为没有切换权柄
package com.meyoung.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
    }

    //    点击百度首页“新闻”链接并校验当前URL
    @Test
    public void clickTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      点击“新闻”
        WebElement newslink = driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        newslink.click();
        String currenturl = driver.getCurrentUrl();
        Assert.assertEquals(currenturl, "http://news.baidu.com/", "CurrentURL incorrect");
    }

    //    打开百度首页,输入关键字并搜索，并校验搜索结果title是否等于“selenium_百度搜索”
    @Test
    public void sendkeysTest() throws InterruptedException {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      输入关键字并搜索
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement baiduButton = driver.findElement(By.id("su"));
        baiduButton.click();
        /*  校验搜索结果title是否等于“selenium_百度搜索”
         *   需要加等待时间，否则可能没有搜索出结果就返回了title值
         * */
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "selenium_百度搜索");
    }

    //    打开百度首页,输入关键字并搜索，在搜索结果页面清空搜索框
    @Test
    public void clearTest() throws InterruptedException {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      输入关键字并搜索
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement baiduButton = driver.findElement(By.id("su"));
        baiduButton.click();
        /*  校验搜索结果title是否等于“selenium_百度搜索”
         *   需要加等待时间，否则可能没有搜索出结果就返回了title值
         * */
        Thread.sleep(2000);
        keys.clear();

    }

    /*
     * 打开百度首页,获取“新闻”文本
     * getText获取的是标签中间的值，不能从搜索框获取
     * */
    @Test
    public void getTextTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
        String news = driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]")).getText();
        System.out.println(news);
        Assert.assertEquals(news, "新闻");
    }

    /*
     * 打开百度首页,获取文本框的tagname
     * 校验是否为input
     * */
    @Test
    public void getTagNameTest() {
        driver.get("https://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName, "input");
    }

    /*
     * 打开百度首页,判断按钮显示的文本值为“百度一下”
     * */
    @Test
    public void getAttributeTest() {
        driver.get("https://www.baidu.com");
        String attribute = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute, "百度一下");
    }

    /*
     * 打开百度首页,判断是否显示“百度一下”按钮
     * */
    @Test
    public void isDisplayedTest() {
        driver.get("https://www.baidu.com");
        boolean a = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(a);
    }

    /*
     * 打开测试页面index.html
     * 判断Volvo单选框被选中
     * */
    @Test
    public void isSelectedTest() {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
//        点击Volvo单选框，再判断单选框是否被选中
        element.click();
        boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /*
     * 打开测试页面i
     * 判断submit按钮处于未激活状态
     * */
    @Test
    public void isEnabledTest() {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        boolean c = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(c);
    }

    /*
     * 截图百度首页
     * */
    @Test
    public void shotTest() {
        driver.get("https://www.baidu.com");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile (file, new File("D:\\Selenium\\Web_auto_selenium_java_IDEA\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
