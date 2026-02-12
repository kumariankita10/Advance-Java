package in.jspider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDemo2 {
     public static void main(String[] args) {

	        String url = "jdbc:postgresql://localhost:5432/mydb";
	        String user = "postgres";
	        String password = "123";

	        try {
	            // 1. Load PostgreSQL Driver
	            Class.forName("org.postgresql.Driver");

	            // 2. Create connection
	            Connection con = DriverManager.getConnection(url, user, password);

	            // 3. SQL Insert Query
	            String sql = "INSERT INTO student(name, email, age) VALUES (?, ?, ?)";

	            // 4. Prepare statement
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, "Ankitaa");
	            ps.setString(2, "ankitasingh123@gmail.com");
	            ps.setInt(3, 24);

	            // 5. Execute insert
	            int rows = ps.executeUpdate();

	            System.out.println(rows + " record inserted successfully!");

	            // 6. Close connection
	            ps.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}



