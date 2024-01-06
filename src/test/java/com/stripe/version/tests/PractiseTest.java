package com.stripe.version.tests;

import com.stripe.version.constants.ConfigurationPaths;
import org.junit.jupiter.api.Test;

import static com.stripe.version.constants.ConfigurationPaths.devPropertiesPath;

public class PractiseTest {


    @Test
    public void propTest(){
        String path = System.getProperty("user.dir") + devPropertiesPath;
        System.out.println("path->"+ path);

    }


}
