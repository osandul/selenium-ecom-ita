package stepdefinitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.MyAccountPage;

public class MyAccountPageStepdefs {

    private static final MyAccountPage myAccountPage = new MyAccountPage();

    @Then("My Account page is displayed")
    public void myAccountPageIsDisplayed() {
        Assertions.assertThat(myAccountPage.isMyAccountPageTitleDisplayed()).isTrue();
    }

}
