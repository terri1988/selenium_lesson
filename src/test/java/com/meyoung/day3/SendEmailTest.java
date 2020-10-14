package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
        driver.get("https://mail.qq.com/");
    }

    /*
     * 登录QQ邮箱
     * 发送带有附件的邮件
     * */
    @Test
    public void sendMailTest() {
        LoginTest.login(driver, "843947059@qq.com", "TaoCong88\\\\");
//      显示等待
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("写信")));

        driver.findElement(By.linkText("写信")).click();
//        切换frame
        driver.switchTo().frame("mainFrame");
//        填入邮件收信人
        driver.findElement(By.xpath("//*[@id=\"toAreaCtrl\"]/div[2]/input")).sendKeys("843947059@qq.com");
//        Subject
        driver.findElement(By.id("subject")).sendKeys("Selenium Testing");
//        Upload file
        driver.findElement(By.name("UploadFi le")).sendKeys("D:\\Selenium\\Documnets\\upload file.txt");
//        切入子iframe页面input正文
        driver.switchTo().frame(driver.findElement(By.className("qmEditorIfrmEditArea")));
        driver.findElement(By.xpath("/html/body")).sendKeys("learnJava");
//        切回父页面
        driver.switchTo().parentFrame();
//        发送邮件
        driver.findElement(By.name("sendbtn")).click();
//        验证发送成功
//        显示等待
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("biginfo_m")));
        String text = driver.findElement(By.className("biginfo_m")).getText();
        Assert.assertEquals(text, "您的邮件已发送");
    }

    //    将登录封装为login方法， 用户名和密码设为参数，上面两个@Test可以直接调用 login 方法
    public static void login(WebDriver driver, String email, String pwd) {
        driver.switchTo().frame("login_frame");
        driver.findElement(By.id("u")).sendKeys(email);
        driver.findElement(By.id("p")).sendKeys(pwd);
        driver.findElement(By.id("login_button")).click();
    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
