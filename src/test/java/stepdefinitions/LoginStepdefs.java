package stepdefinitions;

import enums.elements.LoginPageInputField;
import enums.elements.TableFields;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.Assertions;

import pages.LoginPage;
import properties.PropertyLoader;


import java.util.Map;

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

    @And("I click OK button on Login page")
    public void iClickOKButtonOnLoginPage() {
        loginPage.clickSubmitButton();
        log.info("Click submit button");
    }

    @Then("Store page is displayed")
    public void storePageIsDisplayed() {
        Assertions.assertThat(loginPage.isLoginPageSubmitButtonPresent()).isTrue();
    }

    @Then("Error popup with message {string} is displayed")
    public void errorPopupWithMessageIsDisplayed(String expectedErrorText) {
        String actualErrorMessage = loginPage.getLoginErrorActualMessage();
        Assertions.assertThat(actualErrorMessage)
                .as(String.format("Wrong Error message is displayed, should be %s, but instead it is %s",
                        expectedErrorText, actualErrorMessage)).isEqualTo(expectedErrorText);
    }

    @When("I enter in the field {string} data {string} on Login page")
    public void iEnterInTheFieldEmailDataSajowiEpevaComOnLoginPage(String field, String data) {
        loginPage.inputDataToInputField(field, data);
    }


    @When("I enter in the enum field {} data {string} on Login page")
    public void iEnterInTheFieldDataOnLoginPage(LoginPageInputField field, String data) {
        loginPage.inputDataToInputEnumField(field, data);
    }


    @And("I click {string} button on Login page")
    public void iClickLoginButtonOnLoginPage(String button) {
        loginPage.clickSubmitButton();
    }

    @And("I enter text into field on Login Page:")
    public void iEnterTextIntoFieldOnLoginPage(DataTable table) {

        for (Map<String, String> row : table.asMaps()) {
            String data = row.get(TableFields.INPUT_DATA.toString());
            String field = row.get(TableFields.FIELD_NAME.toString());
            loginPage.inputDataToInputField(field, data);
        }
    }

    @Given("User is logged in on Login Page")
    public void userIsLoggedIn() {
        loginPage.headerComponent().clickAccountDropdown();
        log.info("Account dropdown is opening");
        loginPage.headerComponent().clickLoginFromDropdown();
        log.info("Login page is opening");
        loginPage.clickSubmitButton();
        log.info("Click submit button");
        String email = PropertyLoader.getProperty("USER_EMAIL");
        String password = PropertyLoader.getProperty("USER_PASSWORD");

        log.info(String.format("Entering email %s", email));

        loginPage.inputDataToInputField(LoginPageInputField.EMAIL_INPUT_FIELD.toString(), email);
        log.info(String.format("Entering password %s", password));
        loginPage.inputDataToInputField(LoginPageInputField.PASSWORD_INPUT_FIELD.toString(), password);
        log.info("Click submit button");
        loginPage.clickSubmitButton();
        log.info("Click submit button");
    }

}
