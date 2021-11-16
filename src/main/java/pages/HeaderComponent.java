package pages;

import org.openqa.selenium.By;

public class HeaderComponent extends AbstractBasePage {

    private static final String MY_ACCOUNT_BUTTON = "//span[contains(text(), 'Account')]";
    private static final String LOGIN_DROPDOWN_BUTTON = "//li[contains(@class, 'dropdown')]//following::a[text()='Login']";

    public void clickAccountDropdown() {
        findElementBy(By.xpath(MY_ACCOUNT_BUTTON)).click();
    }

    public void clickLoginFromDropdown() {
        findElementBy(By.xpath(LOGIN_DROPDOWN_BUTTON)).click();
    }
}
