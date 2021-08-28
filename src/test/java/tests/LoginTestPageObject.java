package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestPageObject {

    LoginPage loginPage = new LoginPage();
    public String expectedText = "Invalid password.";

    @Test(description = "login test")
    public void loginTest() {
        loginPage.openLoginPage();
        loginPage.loginButtonClick();
        loginPage.enterLoginEmail("test@gmail.com");
        loginPage.enterLoginPassword("1234");
        loginPage.clickSubmitLogin();

        Assert.assertEquals(loginPage.getErrorTextField(), expectedText);
        loginPage.closePage();
    }

}
