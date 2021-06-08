package org.yan.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yan.common.api.CommonResult;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/api/v2.1/university/*"})
public class AuthenticationFilter implements Filter {

    private Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object raw = req.getSession().getAttribute("userId");
        if (raw == null) {
            LOGGER.info("用户未登录");
            // json消息
            ObjectMapper objectMapper = new ObjectMapper();
            CommonResult<Object> res = CommonResult.unauthorized(null);

            String json = objectMapper.writeValueAsString(res);

            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().write(json);
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
