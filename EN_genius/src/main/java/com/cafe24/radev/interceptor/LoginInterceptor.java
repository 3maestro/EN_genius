package com.cafe24.radev.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInterceptor implements HandlerInterceptor {
      
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object handler) {    	
//    	HttpSession session = request.getSession(false);
//    	
//		  if(session == null) { 
//
//			  System.out.println("세션이 만료되었거나 존재하지 않습니다."); 
//			  try {
//				  response.sendRedirect("/"); 
//			  } catch (IOException e) {
//				  e.printStackTrace(); 
//			  } 
//			  return false; 
//		
//		  }else { 
//			  System.out.println("==세션값있음=="); 
//			  return true; 
//		  }   	
//    }	
}