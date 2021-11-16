package tests;

import driver.DriverInit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseTest {

    private WebDriver driver;
    DriverInit driverInit =  new DriverInit();

    @BeforeEach
    public void setDriver() {
        driver = driverInit.setDriver();
        BasePage.setDriver(driver);
    }

    @AfterEach
    public void closeDriver() {
        driverInit.closeDriver();
    }
}
