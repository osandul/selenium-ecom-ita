package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.assertj.core.api.Assertions;
import pages.BasePage;
import pages.LoginPage;

public class LoginTest extends BasePage {
    LoginPage loginPage;

    private static final String loginErrorExpectedText = "Warning: No match for E-Mail Address and/or Password.";
    private static final String MY_ACCOUNT_BUTTON = "My Account";
    private static final String LOGIN_DROPDOWN_BUTTON = "//li[contains(@class, 'dropdown')]//following::a[text()='Login']";
    private static final String EMAIL_INPUT_FIELD = "input-email";
    private static final String PASSWORD_INPUT_FIELD = "password";
    private static final String SUBMIT_LOGIN_BUTTON = "//input[@type='submit']";
    private static final String LOGIN_ERROR_ALLERT = "//div[contains(@class, 'alert')]";

    @Test
    void loginTest() {
        findElementBy(By.linkText(MY_ACCOUNT_BUTTON)).click();
        findElementBy(By.xpath(LOGIN_DROPDOWN_BUTTON)).click();
        findElementBy(By.id(EMAIL_INPUT_FIELD)).sendKeys("test@gmail.com");
        findElementBy(By.name(PASSWORD_INPUT_FIELD)).sendKeys("1234");
        findElementBy(By.xpath(SUBMIT_LOGIN_BUTTON)).click();

        String loginErrorActualMessage = findElementBy(By.xpath(LOGIN_ERROR_ALLERT)).getText();

        Assertions.assertThat(loginErrorActualMessage).as("error message is different")
                .isEqualTo(loginErrorExpectedText);
    }

    @Test
    void errorAllertValidationOnLoginPage() {
        loginPage= new LoginPage(driver);
        loginPage.clickAccountDropdown();
        loginPage.clickLoginFromDropdown();
        loginPage.inputEmailToEmailField("test@gmail.com");
        loginPage.inputPasswordToEmailField("1234");
        loginPage.clickSubmitButton();
        String loginErrorActualMessage = loginPage.getLoginErrorActualMessage();
        Assertions.assertThat(loginErrorActualMessage).as("error message is different")
                .isEqualTo(loginErrorExpectedText);
    }
}
