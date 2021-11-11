package tests;

import driver.DriverInit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.assertj.core.api.Assertions;

public class LoginTest extends DriverInit {

    public String expectedText = "Warning: No match for E-Mail Address and/or Password.";

    public WebElement waitForVisibilityOfElement(WebElement locator) {
        return new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOf(locator));
    }

    @Test
    public void loginTest() {
        waitForVisibilityOfElement(driver.findElement(By.linkText("My Account"))).click();
        waitForVisibilityOfElement(driver.findElement(By.xpath("//li[contains(@class, 'dropdown')]//following::a[text()='Login']"))).click();
        waitForVisibilityOfElement(driver.findElement(By.id("input-email"))).sendKeys("test@gmail.com");
        waitForVisibilityOfElement(driver.findElement(By.name("password"))).sendKeys("1234");
        waitForVisibilityOfElement(driver.findElement(By.xpath("//input[@type='submit']"))).click();

        String actualError = waitForVisibilityOfElement(driver
                .findElement(By.xpath("//div[contains(@class, 'alert')]"))).getText();

        Assertions.assertThat(actualError).as("error message is different").isEqualTo(expectedText);
    }
}
