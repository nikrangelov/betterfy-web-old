package com.betterfy.controller;

import com.betterfy.entity.Credentials;
import com.betterfy.entity.RegistrationInformation;
import com.betterfy.entity.User;
import com.betterfy.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;

/**
 * Created by nik on 1/9/17.
 */

@Path("/registration")
public class Registration {

    private static final String SALT = "LongStringForExtraSecurity@#$!%^&*(*)1234567890";

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response registerNewUser(RegistrationInformation registrationInformation){

        String firstName = registrationInformation.getFirstName();
        String lastName = registrationInformation.getLastName();
        String email = registrationInformation.getEmail();
        String password = registrationInformation.getPassword();

        final String hashedPassword = Hashing.sha256().hashString((password+SALT), StandardCharsets.UTF_8).toString();

        User user = new User(firstName, lastName, email, hashedPassword);



        // register the user to the database;

        return Response.ok("New user registered").build();
    }


    @Autowired
    private UserRepository userRepository;

}
