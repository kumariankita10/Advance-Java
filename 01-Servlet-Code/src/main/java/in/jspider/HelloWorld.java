//package in.jspider;
//
//import java.io.IOException;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//@WebServlet("/hello")
//public class HelloWorld  extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//		resp.setContentType("text/plain");
//		resp.getWriter().print("Hello World");
//	}
//
//}
//
//package in.jspider;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//@WebServlet("/register")
//public class Register extends HttpServlet{ 
//	
//	    protected  void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//	    	System.out.println("My Ref");
//	    	String idddd = req.getParameter("Id");
//	    	int id = Integer.parseInt(idddd);
//	    	String name = req.getParameter("Name");
//	    	String ageeee = req.getParameter("Age");
//	    	int age = Integer.parseInt(ageeee);
//	    	System.out.println("ID: " + id + " Name: "+ name + " Age: " + age);
//	    	
//	    	
//	    	boolean flag=true;
//	    	if(flag) {
//	    		
//	    		res.sendRedirect("login.jsp");
//    		
////	    		RequestDispatcher dispatcher =req.getRequestDispatcher("login.jsp");
////	    		dispatcher.forward(req,res);
//	    	}
//	    	else {
//	    		req.setAttribute("msg","Register Failed Try Again");
//	    		RequestDispatcher dispatcher =req.getRequestDispatcher("register.jsp");
//	    		
//	    		dispatcher.include(req,res);
//	    		
//	    	}  	
//	    	
//	    	
//	    		    	
//    	
//// 	res.getWriter().print("<h1> user details below :" +"ID: " + id + " Name: "+ name + " Age: " + age + "</h1>");
//    		    }	
//	
//}
//
