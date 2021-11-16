package pages;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LoginPage extends BasePage {

    private static final String EMAIL_INPUT_FIELD = "input-email";
    private static final String PASSWORD_INPUT_FIELD = "password";
    private static final String SUBMIT_LOGIN_BUTTON = "//input[@type='submit']";
    private static final String LOGIN_ERROR_ALLERT = "//div[contains(@class, 'alert')]";

    public void inputEmailToEmailField(String email) {
        findElementBy(By.id(EMAIL_INPUT_FIELD)).sendKeys(email);
    }

    public void inputPasswordToEmailField(String password) {
        findElementBy(By.name(PASSWORD_INPUT_FIELD)).sendKeys(password);
    }

    public void clickSubmitButton() {
        findElementBy(By.xpath(SUBMIT_LOGIN_BUTTON)).click();
    }

    public String getLoginErrorActualMessage() {
        return findElementBy(By.xpath(LOGIN_ERROR_ALLERT)).getText();
    }
}
