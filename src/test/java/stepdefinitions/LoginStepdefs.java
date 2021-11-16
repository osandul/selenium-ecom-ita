package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.Assertions;
import pages.LoginPage;

@Log4j
public class LoginStepdefs {
    private static final LoginPage loginPage = new LoginPage();

    @Given("Login page is opened in header dropdown")
    public void accountPageIsOpenedInHeaderDropdown() {
        loginPage.headerComponent().clickAccountDropdown();
        log.info("Account dropdown is opening");
        loginPage.headerComponent().clickLoginFromDropdown();
        log.info("Login page is opening");
    }

    @When("I enter email {string} on Login page")
    public void iEnterEmailOnLoginPage(String email) {
        loginPage.inputEmailToEmailField(email);
        log.info(String.format("email %s is entered", email));
    }

    @And("I enter password {string} on Login page")
    public void iEnterPasswordOnLoginPage(String password) {
        loginPage.inputPasswordToEmailField(password);
        log.info(String.format("password %s is entered", password));
    }

    @And("I click OK button on Login page")
    public void iClickOKButtonOnLoginPage() {
        loginPage.clickSubmitButton();
        log.info("Click submit button");
    }

    @Then("Store page is displayed")
    public void storePageIsDisplayed() {
    }

    @Then("Error popup with message {string} is displayed")
    public void errorPopupWithMessageIsDisplayed(String expectedErrorText) {
        String actualErrorMessage = loginPage.getLoginErrorActualMessage();
        Assertions.assertThat(actualErrorMessage)
                .as(String.format("Wrong Error message is displayed, should be %s, but instead it is %s",
                        expectedErrorText, actualErrorMessage)).isEqualTo(expectedErrorText);
    }
}
