package hooks;

import driver.DriverInit;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
    private WebDriver driver;

    @Before
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
