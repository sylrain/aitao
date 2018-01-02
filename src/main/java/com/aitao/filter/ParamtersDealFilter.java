package com.aitao.filter;

import com.aitao.util.ObjectMapperUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

//@Component
public class ParamtersDealFilter extends OncePerRequestFilter {
    private static Field requestField;

    private static Field parametersParsedField;

    private static Field coyoteRequestField;

    private static Field parametersField;

    private static Field hashTabArrField;

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        try {
            Class clazz = Class.forName("org.apache.catalina.connector.RequestFacade");
            requestField = clazz.getDeclaredField("request");
            requestField.setAccessible(true);


            parametersParsedField = requestField.getType().getDeclaredField("parametersParsed");
            parametersParsedField.setAccessible(true);


            coyoteRequestField = requestField.getType().getDeclaredField("coyoteRequest");
            coyoteRequestField.setAccessible(true);


            parametersField = coyoteRequestField.getType().getDeclaredField("parameters");
            parametersField.setAccessible(true);


            hashTabArrField = parametersField.getType().getDeclaredField("paramHashStringArray");
            hashTabArrField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String , String[]> getRequestMap(ServletRequest request) {
        try {
            Object innerRequest = requestField.get(request);
            parametersParsedField.setBoolean(innerRequest, true);
            Object coyoteRequestObject = coyoteRequestField.get(innerRequest);
            Object parameterObject = parametersField.get(coyoteRequestObject);
            return (Map<String,String[]>)hashTabArrField.get(parameterObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String parameters = httpServletRequest.getParameter("parameters");
        Map<String , String[]> map = getRequestMap(httpServletRequest);
        if (!StringUtils.isEmpty(parameters)){
            Map<String,String> parametersMap = ObjectMapperUtil.readValue(parameters,Map.class);
            for (String a : parametersMap.keySet()){
                map.put(a,new String[]{parametersMap.get(a)});
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
