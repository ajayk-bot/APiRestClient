package com.stripe.version.stripeTests;

import com.stripe.version.client.RestClient;
import com.stripe.version.configuration.ConfigurationManager;
import com.stripe.version.constants.ApiEndPoints;
import com.stripe.version.constants.ApiStatus;
import com.stripe.version.constants.ConfigurationPaths;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.stripe.version.client.RestClient.generateInvoicePrefix;

public class CustomerTest {


    private ConfigurationManager con;
    private Properties prop;
    private RestClient restclient = new RestClient(con);

    @Test
    public void createCustomer() throws IOException {

        // Create a HashMap to hold the customer details
        Map<String, Object> customerDetails = new HashMap<>();
        // Customer information
        customerDetails.put("email", "test1@gmail.com");
        customerDetails.put("name", "Test11");
        customerDetails.put("description", "Test11 got added");
        // Address information
        Map<String, Object> address = new HashMap<>();
        address.put("city", "IN");
        address.put("country", "India");
        address.put("line1", "Hinjiwadi");
        address.put("line2", "near infosys");
        address.put("postal_code", "431002");
        address.put("state", "Maharashtra");
        customerDetails.put("address", address);

        // Additional customer details
        customerDetails.put("phone", "9890081662");
        customerDetails.put("balance", "4500");

        // Shipping information
        Map<String, Object> shippingAddress = new HashMap<>();
        shippingAddress.put("line1", "shippingline1");
        shippingAddress.put("city", "cityshipping");
        shippingAddress.put("line2", "shippingline2");
        shippingAddress.put("country", "US");
        shippingAddress.put("postal_code", "543433");
        shippingAddress.put("state", "Chandighar");

        Map<String, Object> shippingDetails = new HashMap<>();
        shippingDetails.put("address", shippingAddress);
        shippingDetails.put("name", "shippingName");
        shippingDetails.put("phone", "+91 8055053234");
        customerDetails.put("shipping", shippingDetails);

        // Additional parameters
        customerDetails.put("invoice_prefix", generateInvoicePrefix());
        customerDetails.put("next_invoice_sequence", "1");
        customerDetails.put("preferred_locales[0]", "YES");
        customerDetails.put("preferred_locales[1]", "No");
        customerDetails.put("metadata[order_id]", 6735);
        customerDetails.put("tax_exempt", "exempt");

        String secretKey;
        try {
            prop = restclient.useConfigManagerMethods(ConfigurationPaths.devPropertiesPath);
            secretKey = prop.getProperty("secretkey");
            System.out.println(secretKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Response response =
                RestAssured.given().
                        log().all().baseUri(ApiEndPoints.baseURI).
                        auth().basic(secretKey, "").body(customerDetails)
                        .when().post(ApiEndPoints.basePath).then()
                        .log().all()
                        .statusCode(ApiStatus.OK_RESPONSE)
                        .log().all().extract().response();

    }


}
