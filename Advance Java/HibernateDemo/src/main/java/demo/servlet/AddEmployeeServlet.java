package demo.servlet;

import java.io.IOException;

// Changed javax to jakarta
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import HibernateDemo.Employee;
import demo.repository.HibrenateDAO;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee(id, name, salary);
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);

        HibrenateDAO dao = new HibrenateDAO();
        dao.saveEmployee(emp);

        response.setContentType("text/html");
        response.getWriter().println("<h3>Employee added successfully!</h3>");
    }
}