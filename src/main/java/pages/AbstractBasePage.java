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

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriverThreadLocal(WebDriver webDriver){
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getDriverThreadLocal(){
        return DRIVER_THREAD_LOCAL.get();
    }

    public WebElement waitForVisibilityOfElement(WebElement locator) {
        return new WebDriverWait(getDriverThreadLocal(), 200).until(ExpectedConditions.visibilityOf(locator));
    }

    public WebElement findElementBy(By by) {
        return waitForVisibilityOfElement(getDriverThreadLocal().findElement(by));
    }

    public List<WebElement> waitForVisibilityOfElements(List<WebElement> locators) {
        return new WebDriverWait(getDriverThreadLocal(), 200).until(ExpectedConditions.visibilityOfAllElements(locators));
    }

    public Boolean isElementPresent(By by) {
        return !waitForVisibilityOfElements(getDriverThreadLocal().findElements(by)).isEmpty();
    }

    public void implicitlyWait(){
        getDriverThreadLocal().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitTillScriptIsLoaded(){
        getDriverThreadLocal().manage().timeouts().setScriptTimeout(30,  TimeUnit.SECONDS);
    }

    public void waitTillPageIsLoaded(){
        getDriverThreadLocal().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

    }

    public void explicitlyWait(String xpath){
        WebDriverWait wait = new WebDriverWait(getDriverThreadLocal(),40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
