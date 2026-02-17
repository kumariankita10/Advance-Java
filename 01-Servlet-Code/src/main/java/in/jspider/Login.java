package in.jspider;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Login extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    ServletContext context =req.getServletContext();
	    System.out.println(req.getServletContext().getInitParameter("user"));
	    System.out.println(req.getServletContext().getInitParameter("appname"));
	    System.out.println(context);
	    resp.sendRedirect("circle.jsp");
		
		
		
	
	}	
	
	
	
}



//protected void doPost(HttpServletRequest req, HttpServletResponse res)


