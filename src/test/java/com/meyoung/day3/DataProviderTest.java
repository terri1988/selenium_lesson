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
import org.testng.annotations.DataProvider;

public class DataProviderTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
//        设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver", "D:\\java-workspace\\SeleniumIDEA\\drivers\\chromedriver.exe");
//        实例化设置chromeDriver路径
        driver = new ChromeDriver();
        driver.get("https://mail.qq.com/");
    }

    //    使用数据驱动同时测多个登录数据
    @DataProvider(name = "userlist")
    public Object[][] test1() {
        return new Object[][]{
                {"user1", "123"},
                {"user2", "1234"}
        };
    }

    /*
     * 登录QQ邮箱
     * 输入错误账号密码，验证登陆失败
     * 登录信息用方法login
     * */
    @Test(dataProvider = "userlist")
    public void loginFailMailTest(String username, String password) throws InterruptedException {
        LoginTest.login(driver, username, password);
//      显示等待,否则可能找不到错误提示
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("err_m")));
        Thread.sleep(3000);
        String error = driver.findElement(By.className("err_m")).getText();
        Assert.assertEquals(error, "你输入的帐号或密码不正确，请重新输入。");
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
        Thread.sleep(2000);
        driver.quit();
    }

}
