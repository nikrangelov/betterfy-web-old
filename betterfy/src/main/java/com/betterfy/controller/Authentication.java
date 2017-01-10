package com.betterfy.controller;

import com.betterfy.entity.Credentials;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Created by nik on 1/9/17.
 */

@Path("/authentication")
public class Authentication {

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response authenticateUser(Credentials credentials){

        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String token = null;

        if(authenticate(email, password)){
            token = issueToken(email);
            return Response.ok(token).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    private boolean authenticate(String email, String password){
        if(email.equals("niki") && password.equals("miki")){
            return true;
        }else{
            return false;
        }
    }

    private String issueToken(String email){
        final String token = UUID.randomUUID().toString().replaceAll("-", "");
        // Associate with user;
        return token;
    }


}
