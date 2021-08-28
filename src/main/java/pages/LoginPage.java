package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void openLoginPage() {
        setChromeDriver();
    }

    public void closePage() {
        closeDriver();
    }

    public void loginButtonClick() {
        waitForVisibilityOfElement(driver.findElement(By.className("login")));
        clickOnElement(driver.findElement(By.className("login")));
    }

    public String getErrorTextField() {
        return getTextFromElement(driver.findElement(By.xpath("//div[contains (@class, 'alert')]/ol/li")));
    }

    public void enterLoginEmail(String inputText) {
        waitForVisibilityOfElement(driver.findElement(By.id("email")));
        sendKeysToElement(driver.findElement(By.id("email")), inputText);
    }

    public void enterLoginPassword(String inputText) {
        sendKeysToElement(driver.findElement(By.name("passwd")), inputText);
    }

    public void clickSubmitLogin() {
        clickOnElement(driver.findElement(By.xpath("//button[@id='SubmitLogin']")));
    }
}
