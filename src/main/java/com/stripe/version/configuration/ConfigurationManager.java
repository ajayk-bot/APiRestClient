package com.stripe.version.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationManager.class);
    private FileInputStream inputStream;
    private Properties prop;
    public Properties init(String configFile) throws IOException {
        prop = new Properties();
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + configFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        prop.load(inputStream);
        return prop;

    }
}
