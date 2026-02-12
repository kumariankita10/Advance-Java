package in.BatchExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
     String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=123";
		
		try {
			// Step 1--->. Load and register PostgreSQL Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registered...!");

			// Step 2--> Create Connection
			Connection connection = DriverManager.getConnection(url);
			System.out.println("Connection Established...!");

			String sql = "INSERT INTO student VALUES (?,?, ?, ?)";
			PreparedStatement pstm = connection.prepareStatement(sql);
			System.out.println("Preapared Statemnet Created");
			pstm.setInt(1, 101);
			pstm.setString(2, "Ankitaa");
			pstm.setString(3, "ankitasingh123@gmail.com");
			pstm.setInt(4, 24);
			pstm.addBatch();
			
			pstm.setInt(1, 10);
			pstm.setString(2, "Anu");
			pstm.setString(3, "anu123@gmail.com");
			pstm.setInt(4, 24);
			pstm.addBatch();
			
			pstm.setInt(1, 11);
			pstm.setString(2, "Kamya");
			pstm.setString(3, "kamya123@gmail.com");
			pstm.setInt(4, 25);
			pstm.addBatch();

			
			// Step 4-->Execute Query
			int[] executeBatch=pstm.executeBatch();
			for(int i=0;i<executeBatch.length;i++) {
				System.out.println(executeBatch[i]);
			}
			
				
	
			System.out.println("Query Executed---!");

			// Step 5--> Connection Close
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

