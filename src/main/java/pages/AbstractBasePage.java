package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractBasePage {
    @Getter
    private static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebElement waitForVisibilityOfElement(WebElement locator) {
        return new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOf(locator));
    }

    public WebElement findElementBy(By by) {
        return waitForVisibilityOfElement(driver.findElement(by));
    }

    public List<WebElement> waitForVisibilityOfElements(List<WebElement> locators) {
        return new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfAllElements(locators));
    }

    public Boolean isElementPresent(By by) {
        return !waitForVisibilityOfElements(driver.findElements(by)).isEmpty();
    }

    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitTillScriptIsLoaded(){
        driver.manage().timeouts().setScriptTimeout(30,  TimeUnit.SECONDS);
    }

    public void waitTillPageIsLoaded(){
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

    }

    public void explicitlyWait(String xpath){
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
