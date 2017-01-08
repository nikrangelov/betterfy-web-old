package com.betterfy.controller;

import com.betterfy.entity.User;
import com.betterfy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by nik on 1/8/17.
 */

@Component
@Path("/secured")
public class TestController {
    @GET
    @Produces("application/json")
    @Path("/test")
    public String test() {
        System.out.println("controller");
        User user = new User("Ivan", "Rangelov");

        try {
            userRepository.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
        //return "Jersey: Up and Running!";
    }


    @Autowired
    private UserRepository userRepository;

}
