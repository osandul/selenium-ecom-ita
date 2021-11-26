package pages;

import enums.elements.LoginPageInputField;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_INPUT_FIELD = "//input[@name='%s']";
    private static final String SUBMIT_LOGIN_BUTTON = "//input[@type='submit']";
    private static final String LOGIN_ERROR_ALLERT = "//div[contains(@class, 'alert')]";


    public void inputDataToInputField(String field, String email) {
        findElementBy(By.xpath(String.format(LOGIN_PAGE_INPUT_FIELD, field))).sendKeys(email);
    }

    public void inputDataToInputEnumField(LoginPageInputField field, String email) {
        findElementBy(By.xpath(String.format(LOGIN_PAGE_INPUT_FIELD, field.toString()))).sendKeys(email);
    }

    public void clickSubmitButton() {
        findElementBy(By.xpath(SUBMIT_LOGIN_BUTTON)).click();
    }

    public String getLoginErrorActualMessage() {
        return findElementBy(By.xpath(LOGIN_ERROR_ALLERT)).getText();
    }

    public Boolean isLoginPageSubmitButtonPresent() {
        return isElementPresent(By.xpath(SUBMIT_LOGIN_BUTTON));
    }
}
