package com.truespring.messages.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class AuditingFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = new Date().getTime();
        chain.doFilter(request, response);
        long elapsed = new Date().getTime() - start;
        HttpServletRequest req = (HttpServletRequest) request;
        log.info(">> Request[uri=" + req.getRequestURI() + ", method=" + req.getMethod() + "] completed in " + elapsed + " ms");
    }
}
