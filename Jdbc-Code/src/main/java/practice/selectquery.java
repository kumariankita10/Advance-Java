package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectquery {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/mydb";
		String user = "postgres";
		String password = "123";

		try {

			// Step 1
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Class Loaded");

			// Step 2 Establish connection

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");

			// Step 3 Create Statement
			Statement stm = con.createStatement();
			System.out.println("Statement Created");

			// Step 4 create Query
			String sql = "Select * from student";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			}
			rs.close();

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}

//  -------------------------------------------------------
//public int delete(int id) {
//
//    int res = 0;
//    String sql = "DELETE FROM student WHERE id=?";
//
//    try {
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        System.out.println("Prepared Statement Created");
//
//        pstm.setInt(1, id);
//
//        res = pstm.executeUpdate();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//    return res;
//}


//--------------------------------------------
//case 4:
//    System.out.println("Enter Student id to delete");
//    int did = sc.nextInt();
//
//    int dres = service.delete(did);
//
//    if (dres != 0) {
//        System.out.println("Data Deleted Successfully");
//    } else {
//        System.out.println("No record found with this id");
//    }
//    break;






