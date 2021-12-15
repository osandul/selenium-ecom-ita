package rest;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import rest.dto.CreatedBoardDto;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TrelloRestClient {

    private String id;
    String boardManagementUrl = "https://api.trello.com/1/boards/";
    Header header = new Header("Content-Type", "application/json");

    public void sendCreateBoardRequest() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "B20Board");
        queryParams.put("key", "ad7e2fb85d583015a2e883e97a0a6752");
        queryParams.put("token", "72815be243734e14c107ba025aa4c93d1d4948238a974b0dd0a3b36a7967b22c");

        Response response =  given()
                .contentType(ContentType.JSON)
                .header(header)
                .queryParams(queryParams)
                .log().all()
                .post(boardManagementUrl)
                .then().statusCode(200)
                .and().extract().response();

        CreatedBoardDto createdBoard = response.as(CreatedBoardDto.class);
        id = createdBoard.getId();
    }

    public void sendDeleteBoardRequest() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("key", "ad7e2fb85d583015a2e883e97a0a6752");
        queryParams.put("token", "72815be243734e14c107ba025aa4c93d1d4948238a974b0dd0a3b36a7967b22c");

        given()
                .header(header)
                .queryParams(queryParams)
                .log().all()
                .delete(boardManagementUrl + id)
                .then().statusCode(200);
    }

    public void sendGetBoardRequest(int statusCode){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("key", "ad7e2fb85d583015a2e883e97a0a6752");
        queryParams.put("token", "72815be243734e14c107ba025aa4c93d1d4948238a974b0dd0a3b36a7967b22c");
        given()
                .header(header)
                .queryParams(queryParams)
                .log().all()
                .get(boardManagementUrl + id)
                .then().statusCode(statusCode);
    }
}

