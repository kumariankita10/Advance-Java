package com.example.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/followers")
public class Followers extends HttpServlet {

//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//     
//      
//     	Cookie[] cookies = req.getCookies();
//		boolean found = false;
//	if (cookies != null) {
//		for (Cookie cookie : cookies) {
//
//				if ("user".equals(cookie.getName())) { 
//    	  
//
//				String username = cookie.getValue();
//
//					if ("Ankita".equals(username)) {
//						resp.getWriter().print("<h1>Followers list:</h1>");
//						resp.getWriter().print("<h2>Aman</h2>");
//						resp.getWriter().print("<h2>Ashish</h2>");
//						resp.getWriter().print("<h2>Advik</h2>");
//					found = true;
//					}
//				}
//		}
//	}
//
//	if (!found) {
//     
//			resp.getWriter().print("<h2>Please Login First</h2>");
//		
//	}
//
//	}
//	}
	
	
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

	        
	        HttpSession session = req.getSession(false);

	        // Check session exists or not
	        if (session != null && session.getAttribute("username") != null) {

	            String username = (String) session.getAttribute("username");

	            resp.getWriter().print("<h1>Welcome " + username + "</h1>");
	            resp.getWriter().print("<h2>Followers list:</h2>");
	            resp.getWriter().print("<h3>Aman</h3>");
	            resp.getWriter().print("<h3>Ashish</h3>");
	            resp.getWriter().print("<h3>Advik</h3>");

	        } else {
	            resp.getWriter().print("<h2>Please Login First</h2>");
	        }
	    }
	}
	
	
	
	
