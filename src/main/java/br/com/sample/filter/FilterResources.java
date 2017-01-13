package br.com.sample.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter("/*")
public class FilterResources implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if( servletRequest.getParameter("dev") != null )
            filterChain.doFilter(servletRequest, servletResponse );

        filterChain.doFilter(servletRequest, new AddExpiresHeaderResponse( servletResponse ) );
    }

    public void destroy() {

    }
}