package com.oracle.HomeTheater.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
        String url;
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("로그인 확인 인터셉터 URL = {}", requestURI);
        log.info("로그인 확인 인터셉터 Query = {}", queryString);
        //파라미터 널체크
        if(queryString == null){
             url =requestURI;
        }else {
             url = requestURI + "?" + queryString;
        }
        log.info("리다이렉트 URL = {}", url);
        HttpSession session = request.getSession(false);
        String check = url.substring(0,5);
        if(!check.equals("/rese")) {
        	  HttpSession sessionUrl = request.getSession();
              sessionUrl.setAttribute("sessionUrl",url);
              
        }
        else if (session == null ||session.getAttribute("sessionId")
                == null) {
            log.info("허가 되지 않은 사용자");
            //로그인으로 redirect
            HttpSession sessionUrl = request.getSession();
            sessionUrl.setAttribute("sessionUrl",url);
            response.sendRedirect("loginForm");
            return false;
        }
        return true;
    }
}