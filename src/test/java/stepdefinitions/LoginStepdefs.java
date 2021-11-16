package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import pages.LoginPage;
import tests.BaseTest;

@Log4j
public class LoginStepdefs extends BaseTest {
    private static final LoginPage loginPage = new LoginPage();

    @Given("Account page is opened in header dropdown")
    public void accountPageIsOpenedInHeaderDropdown() {
        loginPage.headerComponent().clickAccountDropdown();
        log.info("Account dropdown is opening");
    }

    @When("I enter email {string} on Login page")
    public void iEnterEmailOnLoginPage() {
    }

    @And("I enter password {string} on Login page")
    public void iEnterPasswordOnLoginPage() {
    }

    @And("I click OK button on Login page")
    public void iClickOKButtonOnLoginPage() {
    }

    @Then("Store page is displayed")
    public void storePageIsDisplayed() {
    }
}
