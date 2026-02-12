package in.BatchExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=123";


		try {
			// Step 1--->. Load and register PostgreSQL Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registered...!");
			
			//Step 2--> Create Connection
			 Connection connection = DriverManager.getConnection(url);
			 System.out.println("Connection Established...!");
			 
			 String sql ="Delete From student where id=?";
			 
			 PreparedStatement pstm=connection.prepareStatement(sql);
			 System.out.println("Preapared Statemnet Created");
			  pstm.setInt(1,21);
			  pstm.addBatch();
			  pstm.setInt(1,10);
			  pstm.addBatch();
			 
			  int[] executeBatch=pstm.executeBatch();
				for(int i=0;i<executeBatch.length;i++) {
					System.out.println(executeBatch[i]);
				}
				
			
				 System.out.println("Updated!");
		   
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


