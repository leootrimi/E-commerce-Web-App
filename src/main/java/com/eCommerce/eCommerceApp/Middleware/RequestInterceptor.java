package com.eCommerce.eCommerceApp.Middleware;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logRequestInfo(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            logger.info("View name: {}", modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            logger.error("Exception occurred during request processing:", ex);
        }
    }

    private void logRequestInfo(HttpServletRequest request) {
        logger.info("Request URL: {} {}", request.getMethod(), request.getRequestURI());
        logger.info("Request Headers:");
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName ->
                        logger.info("{}: {}", headerName, request.getHeader(headerName)));

        logger.info("Request Parameters:");
        request.getParameterMap().forEach((param, values) -> {
            for (String value : values) {
                logger.info("{}: {}", param, value);
            }
        });
    }
}
