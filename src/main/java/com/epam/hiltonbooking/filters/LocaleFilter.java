package com.epam.hiltonbooking.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LocaleFilter implements Filter {
    private static final String ATTRIBUTE = "language";
    private static final String DEFAULT_LANGUAGE = "en";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String language = request.getParameter(ATTRIBUTE);
        HttpSession session = request.getSession();

        if (language == null) {
            language = (String) session.getAttribute(ATTRIBUTE);
            if (language == null) {
                language = DEFAULT_LANGUAGE;
                session.setAttribute(ATTRIBUTE, language);
            }
        } else {
            session.setAttribute(ATTRIBUTE, language);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
