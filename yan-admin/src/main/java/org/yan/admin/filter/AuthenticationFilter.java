package org.yan.admin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = ")
public class AuthenticationFilter implements Filter {

    private Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object raw = req.getSession().getAttribute("userId");
        if (raw == null) {
            LOGGER.info("用户未登录");
            resp.sendRedirect("http://localhost:8000" + "/views/login");
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
