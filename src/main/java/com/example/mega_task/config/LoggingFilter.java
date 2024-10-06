package com.example.mega_task.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Логирование запроса
        logger.info("Incoming Request: Method: {}, URI: {}, Headers: {}",
                httpRequest.getMethod(),
                httpRequest.getRequestURI(),
                httpRequest.getHeaderNames());

        chain.doFilter(request, response);

        // Логирование ответа
        logger.info("Outgoing Response: Status: {}, Headers: {}",
                httpResponse.getStatus(),
                httpResponse.getHeaderNames());
    }

    @Override
    public void destroy() {
    }
}