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

@WebServlet("/delete-top-student")
public class DeleteTopStudentController extends HttpServlet {
    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int rows = studentDAO.deleteTopRecord();

        if (rows == 1)
            session.setAttribute("deleteTop", true);

        else
            session.setAttribute("deleteTop", false);

        resp.sendRedirect("all-students");
    }
}
