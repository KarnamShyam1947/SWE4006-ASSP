package controllers;

import java.io.IOException;
import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Employee;

@WebServlet("/all-employees")
public class HomeController extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.getAllEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/WEB-INF/views/all-employees.jsp").forward(req, resp);
    }
}
