package driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverInit {

    public WebDriver driver;

    @BeforeEach
    public void setDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

}
