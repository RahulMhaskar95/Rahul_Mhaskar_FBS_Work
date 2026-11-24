package demoEmpmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USER = "root";
    private static final String PASSWORD = "Deadshot@2603";

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // ASSIGN connection to variable
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Established: " + con);
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database Connection Failed! Check URL, username, or password.");
            e.printStackTrace();
        }
        return con;
    }
}