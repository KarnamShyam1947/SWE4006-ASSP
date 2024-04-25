package controllers;

import java.io.IOException;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Student;

@WebServlet("/add-student")
public class AddStudentController extends HttpServlet {
    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        HttpSession session = req.getSession();

        student.setUsername(req.getParameter("username"));
        student.setEmail(req.getParameter("email"));
        student.setRegNo(req.getParameter("regNo"));
        student.setPhone(req.getParameter("phone"));

        int result = studentDAO.addStudent(student);
        System.out.println(result);

        if (result == 1) {
            session.setAttribute("add", true);
            resp.sendRedirect("all-students");
        } else {
            session.setAttribute("add", false);
            resp.sendRedirect("add-student");
        }
    }
}
