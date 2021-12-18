package rest;


import io.restassured.response.Response;
import rest.dto.CreatedBoardDto;
import rest.requestSpecifications.RequestSpecifications;

import static io.restassured.RestAssured.given;

public class TrelloRestClient {

    private String id;
   static final String CREATE_BOARD_ENDPOINT = "/1/boards/";

    public void sendCreateBoardRequest(String name) {

        Response response = given().spec(RequestSpecifications.basicSpec)
                .log().all()
                .post(CREATE_BOARD_ENDPOINT +"?name="+name)
                .then().statusCode(200)
                .and().extract().response();

        id = response.as(CreatedBoardDto.class).getId();
    }

    public void sendDeleteBoardRequest() {
        given().spec(RequestSpecifications.basicSpec)
                .log().all()
                .delete(CREATE_BOARD_ENDPOINT + id)
                .then().statusCode(200);
    }

    public void sendGetBoardRequest(int statusCode) {
        given().spec(RequestSpecifications.basicSpec)
                .log().all()
                .get(CREATE_BOARD_ENDPOINT + id)
                .then().statusCode(statusCode);
    }
}

