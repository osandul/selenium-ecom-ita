package tests;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    private static final String loginErrorExpectedText = "Warning: No match for E-Mail Address and/or Password.";

    @Test
    void errorAllertValidationOnLoginPage() {
        loginPage = new LoginPage();
        loginPage.headerComponent().clickAccountDropdown();
        loginPage.headerComponent().clickLoginFromDropdown();
        loginPage.inputEmailToEmailField("test@gmail.com");
        loginPage.inputPasswordToEmailField("1234");
        loginPage.clickSubmitButton();
        String loginErrorActualMessage = loginPage.getLoginErrorActualMessage();
        Assertions.assertThat(loginErrorActualMessage).as("error message is different")
                .isEqualTo(loginErrorExpectedText);
    }
}
