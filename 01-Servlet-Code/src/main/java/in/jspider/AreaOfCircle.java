package in.jspider;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AreaOfCircle  extends HttpServlet{
	 @Override
	public void init() throws ServletException {
		
		super.init();
	}
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Called fot first time");
		String radius=req.getParameter("radius");
            double rad= Double.parseDouble(radius);
		
            ServletConfig config =getServletConfig();
            String pii=config.getInitParameter("pi");
            double pi=Double.parseDouble(pii);
            
            double res=pi*rad*rad;
            
            resp.getWriter().print("<h1> The area of circle is"+res);
            
           
	}
	

}
