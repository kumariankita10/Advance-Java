package com.example.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/mydb";
	private static final String USER = "postgres";
	private static final String PASSWORD = "123";

	public static Connection getConnection() {
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	        //System.out.println("✅ Database Connected Successfully");
	        return con;
	    } catch (Exception e) {
	        System.out.println("❌ DB Connection Failed");
	        e.printStackTrace();
	    }
	    return null;
	}


}
