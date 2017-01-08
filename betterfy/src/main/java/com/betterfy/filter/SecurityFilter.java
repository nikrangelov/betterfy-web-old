package com.betterfy.filter;

/**
 * Created by nik on 1/8/17.
 */


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class SecurityFilter implements Filter {

    public static final String X_CLACKS_OVERHEAD = "X-Clacks-Overhead";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("filter");
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader(X_CLACKS_OVERHEAD, "GNU Terry Pratchett");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}

}
