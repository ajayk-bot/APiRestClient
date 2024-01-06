package com.stripe.version.spotifyTest;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class BasicTest {


    String accessToken;

    @Test
    public void getClientbearerToken() {
        RestAssured.baseURI = "https://accounts.spotify.com";
        String endPoint = "/api/token";
        String grantType = "client_credentials";
        String clientId = "16230815af5f4562bcb76b681da42110";
        String clientSecret = "0831c12dd25b427f9c77bdd84aa7998d";

        Response response = RestAssured.given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("grant_type", grantType)
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .when()
                .post(endPoint)
                .then()
                .statusCode(200) // Assuming a successful response code is 200
                .log().all().extract().response();

        // Extracting values from the response JSON
        accessToken = response.jsonPath().getString("access_token");
        String tokenType = response.jsonPath().getString("token_type");
        int expiresIn = response.jsonPath().getInt("expires_in");

        // Printing the extracted values
        System.out.println("Access Token: " + accessToken);
        System.out.println("Token Type: " + tokenType);
        System.out.println("Expires In: " + expiresIn + " seconds");

    }

    public void getArtist() {
        RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("https://api.spotify.com/v1/artists/4Z8W4fKeB5YxbusRsdQVPb");
    }
}
