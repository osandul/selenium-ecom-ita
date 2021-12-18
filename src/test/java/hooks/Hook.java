package hooks;

import driver.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.BasePage;


public class Hook {
    private WebDriver driver;

    @Before("@ui")
    public void getDriver() {
        driver = new DriverInit().setDriver();
        BasePage.setDriver(driver);
    }

    @After
    public void quitDriver() {
        if (driver != null)
            BasePage.getDriver().quit();
    }
}
