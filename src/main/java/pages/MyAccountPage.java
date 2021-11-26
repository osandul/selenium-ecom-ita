package pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {
    private static final String MY_ACCOUNT_PAGE_TITLE = "//h2[text()='My Account']";

    public boolean isMyAccountPageTitleDisplayed() {
        return findElementBy(By.xpath(MY_ACCOUNT_PAGE_TITLE)).isDisplayed();
    }
}
