package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rest.TrelloRestClient;

public class TrelloApiStepDefs {
    TrelloRestClient trelloRestClient = new TrelloRestClient();

    @When("I send create a new board request")
    public void iCreateANewBoard() {
        trelloRestClient.sendCreateBoardRequest();
    }

    @Then("I see {int} status code in get board info request")
    public void iSeeStatusCodeInGetBoardInfoRequest(int statusCode) {
        trelloRestClient.sendGetBoardRequest(statusCode);
    }

    @When("I send delete the board request")
    public void iSendDeleteTheBoardRequest() {
        trelloRestClient.sendDeleteBoardRequest();
    }
}
