package in.jspider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Updatae {

	public static void main(String[] args) {
	
			String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=123";
//	        String user = "postgres";
//	        String password = "123";


			try {
				// Step 1--->. Load and register PostgreSQL Driver
				Class.forName("org.postgresql.Driver");
				System.out.println("Driver loaded and registered...!");
				
				//Step 2--> Create Connection
				 Connection connection = DriverManager.getConnection(url);
				 System.out.println("Connection Established...!");
				
				
				 //Step 3-->Create Statement 
				 Statement statement=connection.createStatement();
				  System.out.println("Statement Created----!");
				  
				 String sql = "UPDATE student set age=19 where id=2";
				//String sql1="UPDATE student set name='Ankitaa' where id=1";
				 
				 //Step 4-->Execute Query
				int res= statement.executeUpdate(sql);
				if(res!=0)
				{
					 System.out.println("Updated!");
			    }
				 System.out.println("Query Executed---!");
				 
				 //Step 5--> Connection Close 
				 connection.close();
				 System.out.println("Connection Close---!");

			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		}
	}

	


