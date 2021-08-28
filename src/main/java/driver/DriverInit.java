package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverInit {

    public static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        driver.get("http://automationpractice.com/");
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                setDriver(new ChromeDriver());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            getDriver().quit();
            driver = null;
        }
    }
}
