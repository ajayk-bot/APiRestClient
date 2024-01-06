package com.stripe.version.client;

import com.stripe.version.configuration.ConfigurationManager;
import com.stripe.version.constants.ConfigurationPaths;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

//All Rest Assured Methods or wrapper support

public class RestClient {

    private ConfigurationManager configManager;
    private Properties prop;

    public RestClient(ConfigurationManager configManager) {
        this.configManager = new ConfigurationManager();
    }

    public Properties useConfigManagerMethods(String filepath) throws IOException {
        // Properties prop = configManager.init(ConstatPaths.devPropertiesPath);
        prop = configManager.init(filepath);
        return prop;

    }

    // generate invoice
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





}
