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

@WebServlet("/delete-student")
public class DeleteStudentController extends HttpServlet {
    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String regNo = req.getParameter("reg-no");
        int rows = studentDAO.deleteStudent(regNo);

        if (rows == 1)
            session.setAttribute("delete", true);

        else
            session.setAttribute("delete", false);

        resp.sendRedirect("all-students");
    }
}
