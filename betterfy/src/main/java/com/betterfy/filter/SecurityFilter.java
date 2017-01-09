package com.betterfy.filter;

/**
 * Created by nik on 1/8/17.
 */


import java.io.IOException;

import javax.annotation.Priority;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements Filter {

    public static final String USER_ID_HEADER = "USER_ID";
    private static final String SECURED_URL_PREFIX = "secured";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) res;
        String authToken = null;

        String requestedUrl = request.getRequestURI().toString();
        if(requestedUrl.contains(SECURED_URL_PREFIX)){

            if(!isTokenValid(authToken)){
                Response.ResponseBuilder builder = null;
                String msg = "User cannot access the resource!";
                builder = Response.status(Response.Status.UNAUTHORIZED).entity(msg);
                throw new WebApplicationException(builder.build());
            }



        }
        //response.setHeader(USER_ID_HEADER, "12");
        chain.doFilter(req, res);
    }

    private boolean isTokenValid(String token) {

        return true;
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}

}
