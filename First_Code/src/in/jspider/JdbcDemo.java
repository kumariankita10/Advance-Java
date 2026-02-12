package in.jspider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JdbcDemo {
	public static void main(String[] args) {

	        String url = "jdbc:postgresql://localhost:5432/testdb";
	        String user = "postgres";
	        String password = "postgres";

	        try {
	            // Load PostgreSQL Driver (optional in Java 8+)
	            Class.forName("org.postgresql.Driver");

	            // Create connection
	            Connection con = DriverManager.getConnection(url, user, password);

	            System.out.println("Database connected successfully!");

	            // Close connection
	            con.close();

	        } catch (ClassNotFoundException e) {
	            System.out.println("PostgreSQL Driver not found");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Connection failed");
	            e.printStackTrace();
	        }
	    }
	}


}
