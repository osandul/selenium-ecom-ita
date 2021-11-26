import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"json:build/cucumber.json",
                "html:build/site/cucumber-pretty"},
        stepNotifications = true,
        strict = true)
public class Runner{


}
