package in.jspider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/mydb";
		String user = "postgres";
		String password = "123";

		try {
			// 1. Create connection
			Connection con = DriverManager.getConnection(url, user, password);

			// 2. Create statement
			Statement stmt = con.createStatement();

			// 3. Execute SELECT query
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			// 4. Process result
			System.out.println("ID | NAME | EMAIL | AGE");
			System.out.println("-----------------------");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int age = rs.getInt("age");

				System.out.println(id + " | " + name + " | " + email + " | " + age);
			}

			// 5. Close resources
			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
