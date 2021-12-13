package rest;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TrelloRestClient {

    public void sendCreateBoardRequest() {
        String url = "https://api.trello.com/1/boards/";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "B20 Board");
        queryParams.put("key", "ad7e2fb85d583015a2e883e97a0a6752");
        queryParams.put("token", "72815be243734e14c107ba025aa4c93d1d4948238a974b0dd0a3b36a7967b22c");
        Header header = new Header("Content-Type", "application/json");

       Response response = given()
                .contentType(ContentType.JSON)
                .header(header)
                .queryParams(queryParams)
                .post(url)
                .then().statusCode(200)
                .and().extract().response();
    }
}

