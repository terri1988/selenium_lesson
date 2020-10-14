package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTest2 {
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
     * 打开测试界面
     * 在百度一下按钮上右键
     * */
    @Test
    public void rightClickTest() {
        driver.get("https://www.baidu.com/");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
//        实例化 Actions
        Actions actions = new Actions(driver);
//        在百度一下按钮上右键
        actions.contextClick(buttonBaidu).perform();
//        不传参时，会在页面左上角右键
        actions.contextClick().perform();
    }

    /*
     * 打开测试界面
     * 在百度一下按钮上双击
     * */
    @Test
    public void doubleClickTest() {
        driver.get("https://www.baidu.com/");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
//        实例化 Actions
        Actions actions = new Actions(driver);
//        在百度一下按钮上双击
        actions.doubleClick(buttonBaidu).perform();
//        不传参时，会在鼠标所在的位置双击
        actions.doubleClick().perform();
    }

    /*
     * 打开测试界面
     * 鼠标移动到 action 按钮，会显示 Hello world
     * */
    @Test
    public void moveTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        WebElement buttonBaidu = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
//        实例化 Actions
        Actions actions = new Actions(driver);
//        鼠标移动到 action 按钮
        actions.moveToElement(buttonBaidu).perform();
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//*[text()='Hello World!']")).getText();
        Assert.assertEquals(text, "Hello World!");
    }

    /*
     * 打开测试界面
     * 鼠标拖动到（x,y）
     * */
    @Test
    public void dropTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
//        实例化 Actions
        Actions actions = new Actions(driver);
//        鼠标拖动到（x,y）
        actions.dragAndDropBy(element, 500, 500).perform();
        Thread.sleep(3000);
    }

    /*
     * 打开测试界面
     * 把元素拖动到另一个元素上"拖我到这里"
     * */
    @Test
    public void dropTest2() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement el1 = driver.findElement(By.id("drag"));
        WebElement el2 = driver.findElement(By.xpath("/html/body/h1"));
//        实例化 Actions
        Actions actions = new Actions(driver);
//        把元素拖动到另一个元素上"拖我到这里",并释放el1
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform();
        Thread.sleep(3000);
    }

    /*
     * 打开测试界面
     * 多选下拉框，选择多个选项
     * */
    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        WebElement el1 = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
//        获取所有选项值
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
//        实例化 Actions
        Actions actions = new Actions(driver);
//      按住shift键，点第一个选项和第三个选项，在放开shift键，会选中第一个到第三个选项
        actions.keyDown(Keys.SHIFT)
                .click(list.get(0))
                .click(list.get(2))
                .keyUp(Keys.SHIFT)
                .perform();
        Thread.sleep(2000);
//      再按住ctrl键，点第三个选项，再放开ctrl键，会选中第一个和第二个选项，因为再次选择第三个选项=unselect
        actions.keyDown(Keys.CONTROL)
                .click(list.get(2))
                .keyUp(Keys.CONTROL)
                .perform();
    }

    /*
     * 打开测试界面
     * CTRL+S 保存当前页面
     * Robot 模拟键盘输入
     * */
    @Test
    public void saveHtmlTest() throws AWTException, InterruptedException {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
//        实例化 Robot
        Robot robot = new Robot();
//        按住 CONTROL 键
        robot.keyPress(KeyEvent.VK_CONTROL);
//        方法一：按住 S 键，弹出保存弹框
//        robot.keyPress(KeyEvent.VK_S);
//        方法二：用ASK码输入S 键
        int keyS = (int) new Character('S');
        System.out.println(keyS);
        robot.keyPress(keyS);
        Thread.sleep(2000);
//        在弹框中，按住Enter键保存页面
        robot.keyPress(KeyEvent.VK_ENTER);
//         释放 CONTROL 键
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    /*
     * 打开测试界面
     * 上传文件 by sendKeys: 必须是input标签
     * */
    @Test
    public void uploadTest() {
        driver.get("D:\\Selenium\\Web_auto_selenium_java_IDEA\\Code\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\terri.tao\\Desktop\\screenshot.png");
    }

    /*
     * 打开百度首页
     * 搜索 “微信下载”
     * 下载Android apk
     * */
    @Test
    public void downloadTest() {
//       打开百度首页
        driver.get("https://www.baidu.com");
//      搜索 “微信下载”
        WebElement keyField = driver.findElement(By.id("kw"));
        keyField.sendKeys("微信下载");
        driver.findElement(By.id("su")).click();
        driver.findElement(By.xpath("//*[@id=\"op_wiseapp_dltopc\"]")).click();
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
