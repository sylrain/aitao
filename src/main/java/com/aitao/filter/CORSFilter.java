package com.aitao.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *  处理跨域问题
 *
 */
@Component
public class CORSFilter extends OncePerRequestFilter {
    private String regex;

    public void setFilterRegex(String domainReg){
        this.regex = domainReg;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String origin = request.getHeader("Origin");
//        if(StringUtils.isNotBlank(origin) && origin.matches(regex)){
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin") == null ? "*" : request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type, Authorization");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Expose-Headers", "server-replace");
//        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
