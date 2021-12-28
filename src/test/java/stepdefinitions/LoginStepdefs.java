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


public class LoginStepdefs {
    private static final LoginPage loginPage = new LoginPage();

    @Given("Login page is opened in header dropdown")
    public void accountPageIsOpenedInHeaderDropdown() {
        loginPage.headerComponent().clickAccountDropdown();
        loginPage.headerComponent().clickLoginFromDropdown();
    }

    @And("I click OK button on Login page")
    public void iClickOKButtonOnLoginPage() {
        loginPage.clickSubmitButton();
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
        loginPage.headerComponent().clickLoginFromDropdown();
        loginPage.clickSubmitButton();
        String email = PropertyLoader.getProperty("USER_EMAIL");
        String password = PropertyLoader.getProperty("USER_PASSWORD");

        loginPage.inputDataToInputField(LoginPageInputField.EMAIL_INPUT_FIELD.toString(), email);

        loginPage.inputDataToInputField(LoginPageInputField.PASSWORD_INPUT_FIELD.toString(), password);

        loginPage.clickSubmitButton();

    }

}
