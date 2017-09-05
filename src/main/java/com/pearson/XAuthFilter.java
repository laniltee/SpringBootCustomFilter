package com.pearson;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lanil Marasinghe on 05-Sep-17.
 */
@Component
public class XAuthFilter extends GenericFilterBean {

    final String CONST_AUTH_TOKEN = "1qaz2wsx3edc4rfv5tgb6yhn7ujm";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String receivedHeader = httpServletRequest.getHeader("X-Authorization");
        if(receivedHeader == null || !receivedHeader.equals(CONST_AUTH_TOKEN)){
            System.err.println("Received invalid token");
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setContentType("application/json");
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
