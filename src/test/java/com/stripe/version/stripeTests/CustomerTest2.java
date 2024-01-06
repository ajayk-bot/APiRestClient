package com.stripe.version.stripeTests;

import com.stripe.version.pojo.Customer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class CustomerTest2 {

    //  Publishable key -> pk_test_51MsID0SEF9s6KwaUDX3N7nql8OWV0spwxeZ7lM5dlc7vEyYE3EDFXnQfpJvnd3kDp3RjfMlt2HCKo0EmKHE07UAk007q8EHpxs

    // Secret key -> sk_test_51MsID0SEF9s6KwaU9OG0M5LOI1HHbdk8fMUXFlNWmZvETBGdkA3uFMkXk3pBqkPCFLbIwbeNmDhyicnJ0kHQddi000TgX41jNR

    //https://json2csharp.com/code-converters/json-to-pojo
    // create invoice prefix
    public static String generateInvoicePrefix() {
        int length = 5;
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }
        return builder.toString();
    }


    @Ignore
    @Test
    public void createCustomer() {
        String secretKey = "sk_test_51MsID0SEF9s6KwaU9OG0M5LOI1HHbdk8fMUXFlNWmZvETBGdkA3uFMkXk3pBqkPCFLbIwbeNmDhyicnJ0kHQddi000TgX41jNR";
        RestAssured.baseURI = "https://api.stripe.com/";

        Customer customer = new Customer();





//        Response response =
//                RestAssured.given().
//                        log().all().baseUri("https://api.stripe.com/").
//                        auth().basic(secretKey, "").formParams(customerDetails)
//                        .when().post("v1/customers").then()
//                        .log().all()
//                        .statusCode(200) // Assuming a successful response code is 200
//                        .log().all().extract().response();

    }


}
