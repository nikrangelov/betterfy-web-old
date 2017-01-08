package com.betterfy.configuration;

import com.betterfy.controller.TestController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by nik on 1/8/17.
 */

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        //register(TestController.class);

        packages("com.betterfy.controller");
    }
}