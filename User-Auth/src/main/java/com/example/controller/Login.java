package com.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.util.DBConnection;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {

        String user = req.getParameter("user");
        String pswd = req.getParameter("pswd");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );

            // 🔹 Set parameters
            ps.setString(1, user);
            ps.setString(2, pswd);

            // 🔹 Execute query
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	
            	
            	 HttpSession session = req.getSession();
                 session.setAttribute("username", user);
                 session.setMaxInactiveInterval(60);

                // 🔹 CREATE COOKIE
//                Cookie cookie = new Cookie("user", user);
//                cookie.setMaxAge(10); 
//                cookie.setPath("/");
//                resp.addCookie(cookie);

                RequestDispatcher dispatcher =
                        req.getRequestDispatcher("home.jsp");
                dispatcher.forward(req, resp);

            } else {
                resp.getWriter().print("Wrong username or password");
            }

        } catch (Exception e) {
        	req.setAttribute("error", e.getMessage() );
        	RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
        	rd.forward(req, resp);
            
        }
    }
}
