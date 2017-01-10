package com.betterfy.controller;

import com.betterfy.entity.User;
import com.betterfy.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.nio.charset.StandardCharsets;

/**
 * Created by nik on 1/8/17.
 */

@Component
@Path("/test")
public class TestController {

    final String SALT = "LongStringForExtraSecurity@#$!%^&*(*)1234567890";

    @GET
    @Produces("application/json")
    @Path("/free")
    public String testFree() {
        /*System.out.println("controller");
        User user = new User();

        try {
            userRepository.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
        */
        final String hashedpassword = Hashing.sha256().hashString(("your input"+SALT), StandardCharsets.UTF_8).toString();
        return  hashedpassword;
        //return "Jersey: Up and Running!";
    }

    @GET
    @Produces("application/json")
    @Path("/secured")
    public String testSecured() {
        System.out.println("Secured");
        return "OK it is secured!";
    }

    @Autowired
    private UserRepository userRepository;

}
