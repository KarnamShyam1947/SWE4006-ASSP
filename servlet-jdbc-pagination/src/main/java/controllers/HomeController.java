package controllers;

import java.io.IOException;
import java.util.List;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Student;

@WebServlet("/all-students")
public class HomeController extends HttpServlet {
    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        String perPageStr = req.getParameter("per-page");

        int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr); // default offset 1 
        int perPage = (perPageStr == null) ? 2 : Integer.parseInt(perPageStr); // default limit 2

        List<Student> studentPage = studentDAO.getStudentPage(page, perPage);
        int cnt = studentDAO.getStudentCount();

        if (cnt > 0) {
            req.setAttribute("currentPage", page);
            req.setAttribute("currentRecords", studentPage.size());
            req.setAttribute("totalRecords", cnt);
            req.setAttribute("totalPages", (int)Math.ceil((double)cnt / (double)perPage));
        }

        req.setAttribute("studentPage", studentPage);
        req.getRequestDispatcher("/WEB-INF/views/all-students.jsp").forward(req, resp);
    }
}
