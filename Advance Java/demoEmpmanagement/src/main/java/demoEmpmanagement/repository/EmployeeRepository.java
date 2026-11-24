package demoEmpmanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import demoEmpmanagement.model.Employee;
import demoEmpmanagement.util.DBUtil;

public class EmployeeRepository {

    public boolean addEmployee(Employee employee) {
        // Corrected SQL syntax with proper table name (assuming table name is 'employee')
        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
        
        Connection con = DBUtil.getConnection();
        
        if (con == null) {
            System.err.println("Database connection is null.");
            return false;
        }

        try (PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setInt(1, employee.getId());
            psmt.setString(2, employee.getName());

          
            if (employee.getSalary() != null) {
                psmt.setDouble(3, employee.getSalary());
            } else {
                psmt.setNull(3, java.sql.Types.DOUBLE);
            }

            int res = psmt.executeUpdate();
            return res == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return false;
    }
}