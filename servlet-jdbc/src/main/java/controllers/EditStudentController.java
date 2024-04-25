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

@WebServlet("/edit-student")
public class EditStudentController extends HttpServlet {

    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reg = req.getParameter("reg-no");
        Student student = studentDAO.getStudentByRegNo(reg);
        System.out.println(student);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/WEB-INF/views/edit-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        HttpSession session = req.getSession();

        student.setUsername(req.getParameter("username"));
        student.setEmail(req.getParameter("email"));
        student.setRegNo(req.getParameter("regNo"));
        student.setPhone(req.getParameter("phone"));
        student.setId(Integer.parseInt(req.getParameter("id")));

        int result = studentDAO.updateStudent(student);
        System.out.println(result);

        if (result == 1)
            session.setAttribute("edit", true);

        else
            session.setAttribute("edit", false);

        resp.sendRedirect("all-students");
    }
}
