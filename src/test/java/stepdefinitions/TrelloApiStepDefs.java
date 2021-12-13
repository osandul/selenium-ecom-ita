package stepdefinitions;

import io.cucumber.java.en.When;
import rest.TrelloRestClient;

public class TrelloApiStepDefs {
    TrelloRestClient trelloRestClient = new TrelloRestClient();

    @When("I create a new board")
    public void iCreateANewBoard() {
     trelloRestClient.sendCreateBoardRequest();
    }
}
