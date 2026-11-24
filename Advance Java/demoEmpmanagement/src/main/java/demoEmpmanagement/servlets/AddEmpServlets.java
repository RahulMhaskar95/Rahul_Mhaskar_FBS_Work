package demoEmpmanagement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import demoEmpmanagement.model.Employee;
import demoEmpmanagement.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addemployee")
public class AddEmpServlets extends HttpServlet{

	EmployeeService employeeservice = new EmployeeService();
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
       resp.sendRedirect("empform.html");
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp ) throws ServletException , IOException 
    {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String idStr = req.getParameter("id");
        String nameStr = req.getParameter("name");
        String salaryStr = req.getParameter("salary");

        if (idStr == null || idStr.trim().isEmpty() || salaryStr == null || salaryStr.trim().isEmpty()) {
            // Handle error safely without crashing
            resp.getWriter().println("Error: Invalid or missing numeric inputs for ID or Salary.");
            return;
        }
        
        try {
            // 1. Read input values from the HTML form
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double salary = Double.parseDouble(req.getParameter("salary"));

            // 2. Create the Employee object
            Employee emp = new Employee(id, name, salary);

            // 3. Invoke business logic
            boolean res = employeeservice.addEmployee(emp);

            // 4. Send response back to the client
            if (res) {
                out.println("<h3>Employee Added Successfully!</h3>");
            } else {
                out.println("<h3>Failed to Add Employee.</h3>");
            }

        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<h3>Error: Invalid or missing numeric inputs for ID or Salary.</h3>");
        }
    	
    }
}
