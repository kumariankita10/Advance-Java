package in.jspider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        
        int id = Integer.parseInt(req.getParameter("Id"));
        String name = req.getParameter("Name");
        int age = Integer.parseInt(req.getParameter("Age"));
        
        

       
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "postgres";
        String password = "123";
        int count = 0;

        try {
            // 3. Load Driver
            Class.forName("org.postgresql.Driver");

            System.out.println("Ankita");
            Connection con = DriverManager.getConnection(url, user, password);

            // 5. Insert Query
            String sql = "INSERT INTO public.application(id,name,age) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            // 6. Execute Query
            count = ps.executeUpdate();

            

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

       
        if (count>0) {
           // req.setAttribute("username", name);
          	res.sendRedirect("login.jsp");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
//            dispatcher.forward(req, res);

        } else {
            req.setAttribute("msg", "Register Failed ❌ Try Again");

            RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
            dispatcher.forward(req, res);
        }
    }
   }


