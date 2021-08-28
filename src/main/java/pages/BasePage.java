package pages;

import driver.DriverInit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static WebDriver driver;

    protected static WebDriver setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        DriverInit.setDriver(new ChromeDriver());
        driver = DriverInit.getDriver();
        return driver;
    }

    public void closeDriver() {
        DriverInit.closeDriver();
    }

    public WebElement waitForVisibilityOfElement(WebElement locator) {
        return new WebDriverWait(driver, 100000).until(ExpectedConditions.visibilityOf(locator));
    }

    public void clickOnElement(WebElement locator) {
        waitForVisibilityOfElement(locator).click();
    }

    public void sendKeysToElement(WebElement locator, String text) {
        waitForVisibilityOfElement(locator).sendKeys(text);
    }

    public String getTextFromElement(WebElement locator) {
        return waitForVisibilityOfElement(locator).getText();
    }

    protected WebElement find(WebElement locator) {
        return waitForVisibilityOfElement(locator);
    }

}
