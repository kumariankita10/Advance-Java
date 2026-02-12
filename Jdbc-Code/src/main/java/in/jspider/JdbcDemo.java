package in.jspider;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "postgres";
        String password = "123";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
