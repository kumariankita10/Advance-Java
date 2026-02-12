package in.jspider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dynamic_Update {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=123";


		try {
			// Step 1--->. Load and register PostgreSQL Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registered...!");
			
			//Step 2--> Create Connection
			 Connection connection = DriverManager.getConnection(url);
			 System.out.println("Connection Established...!");
			 
			 String sql ="Update student set name=? where id =?";
			 PreparedStatement pstm=connection.prepareStatement(sql);
			 System.out.println("Preapared Statemnet Created");
			 
			 pstm.setString(1, "Ankita Singh");
	         pstm.setInt(2,7);
			 
			 
			 //Step 4-->Execute Query
			int res= pstm.executeUpdate();
			if(res!=0)
			{
				 System.out.println("Updated!");
		    }
			 System.out.println("Query Executed---!");
			 
			 //Step 5--> Connection Close 
			 connection.close();
			 System.out.println("Connection Close---!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	 catch (SQLException e) {
		e.printStackTrace();
	 }

	}

}

		

