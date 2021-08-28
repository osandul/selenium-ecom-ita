package tests;

import driver.DriverInit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestTestNG {

    public WebDriver setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        DriverInit.setDriver(new ChromeDriver());
        return  DriverInit.getDriver();
    }
    WebDriver driver = setChromeDriver();
    public String expectedText = "Invalid password.";

    public WebElement waitForVisibilityOfElement(WebElement locator) {
        return new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOf(locator));
    }

    @Test(description = "login test")
    public void loginTest() {
        driver.manage().window().maximize();
        waitForVisibilityOfElement(driver.findElement(By.className("login"))).click();
        waitForVisibilityOfElement(driver.findElement(By.id("email"))).sendKeys("test@gmail.com");
        waitForVisibilityOfElement(driver.findElement(By.name("passwd"))).sendKeys("1234");
        waitForVisibilityOfElement(driver.findElement(By.xpath( "//button[@id='SubmitLogin']"))).click();

        Assert.assertEquals(waitForVisibilityOfElement(driver
                .findElement(By.xpath("//div[contains (@class, 'alert')]/ol/li"))).getText(), expectedText);
        driver.close();
    }
}
