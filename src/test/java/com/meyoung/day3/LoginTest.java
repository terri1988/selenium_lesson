package com.meyoung.day3;

import po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
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
     * 通过“退出”验证登陆成功
     * */
    @Test
    public void loginSuccessMailTest() {
//      driver 控制权转交， 切换frame

        driver.switchTo().frame("login_frame");
        driver.findElement(By.id("u")).sendKeys("843947059@qq.com");
//      password中的“\”,需要多加一个“\”
        driver.findElement(By.id("p")).sendKeys("TaoCong88\\\\");
        driver.findElement(By.id("login_button")).click();
//      显示等待
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
//      通过“退出”验证登陆成功
        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout, "退出");
    }

    /*
     * 登录QQ邮箱
     * 输入错误账号密码，验证登陆失败
     * 登录信息用方法login
     * */
    @Test
    public void loginFailMailTest() throws InterruptedException {
        LoginTest.login(driver, "843947059@qq.com", "TaoCong88");
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

//    用com.po.page下的LoginPage元素库中的元素 （PO模式）
    public static void loginPo(WebDriver driver, String email, String pwd) {
        driver.switchTo().frame("login_frame");
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginbutton).click();

    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
