package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentService {

	private static String url = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=123";
	private static Connection connection;

	static {

		try {

			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int save(Student st) {

		int res = 0;
		String sql = "INSERT INTO student VALUES (?,?,?,?)";
		try {

			PreparedStatement pstm = connection.prepareStatement(sql);
			System.out.println("Preapared Statement Created");
			pstm.setInt(1, st.getId());
			pstm.setString(2, st.getName());
			pstm.setString(3, st.getMail());
			pstm.setInt(4, st.getAge());

			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int update(Student st) {

		int res = 0;
		String sql = "UPDATE student SET name=?, email=?, age=? WHERE id=?";

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			System.out.println("Preapared Statement Created");
			pstm.setString(1, st.getName());
			pstm.setString(2, st.getMail());
			pstm.setInt(3, st.getAge());
			pstm.setInt(4, st.getId());

			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public List<Student> fetchAll() {
		List<Student> list = new ArrayList<Student>();
		String sql = "Select * from student";
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				 
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		return list;
	}
	

	public List<Student> festchAll() {

		
		List<Student> list = new ArrayList<Student>();
		String sql = "Select * from student";
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public int delete(int did) {

		int res = 0;
		String sql = "DELETE FROM student WHERE id=?";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			System.out.println("Prepared Statement Created");
			pstm.setInt(1, did);

			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;

	}

	public boolean exitt() {
		boolean flag = false;
		try {
			connection.close();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	

}
