package in.jspider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Flight_Booking {

	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=123";
	


		try {
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded and registered...!");
			
		
			 Connection connection = DriverManager.getConnection(url);
			 
			
			 Statement statement=connection.createStatement(); 
			 
			  connection.setAutoCommit(false);
			 
			 String sql1="Insert into flight values(1883,'Ankita','BLR','PATNA')";
			 
			 statement.execute(sql1);
			 
			 String sql2="Insert into passenger values(16558,'Ankita',80000)";
			 statement.execute(sql2);
			 
			 String sql21="Insert into passenger values(17777,'Aman',80000)";
			 
			 statement.execute(sql21);
			 
			 
			Savepoint savepoint   =connection.setSavepoint();
			
			 String sql3="Insert into payment values(8070,'Ankita','Success')";
			
			 
			 statement.execute(sql3);
			 
			 if(Payment.isSuccess()) {
				 System.out.println("Payment done");
				 connection.commit();
				 connection.close();
			 }else {
				 System.out.println("Paymentnot not done");
				 connection.rollback(savepoint);
				 connection.commit();
			 }
			 
			
			  
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
