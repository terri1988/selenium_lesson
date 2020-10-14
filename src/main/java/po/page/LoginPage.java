package po.page;

import org.openqa.selenium.By;
//将QQ邮箱，登录页面所有需要定位的元素都定义在这个元素库
public class LoginPage {
    //    QQ邮箱，定义email文本框的定位方式
    public static By emailInput = By.id("u");
    //     QQ邮箱，定义password文本框的定位方式
    public static By pwdInput = By.id("p");
    //    QQ邮箱，登录按钮的定位方式
    public static By loginbutton = By.id("login_button");
}
