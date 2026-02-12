package in.jspider;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "postgres";
        String password = "123";


		try {
			// Step 1--->. Load and register PostgreSQL Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registered...!");
			
			//Step 2--> Create Connection
			 Connection connection = DriverManager.getConnection(url, user, password);
			 System.out.println("Connection Established...!");
			
			
			 //Step 3-->Create Statement 
			 Statement statement=connection.createStatement();
			  System.out.println("Statement Created----!");
			  
			 String sql = "INSERT INTO student Values(6,'Aman','aman@gmail.com',26)";
			 
			 //Step 4-->Execute Query
			 statement.execute(sql);
			 System.out.println("Query Executed---!");
			 
			 //Step 5--> Connection Close 
			 connection.close();
			 System.out.println("Connection Close---!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}