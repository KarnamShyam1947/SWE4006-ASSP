import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello-world")
public class HelloWorldController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
            "<html>" +
            "<head>"+
            "<title>Hello World</title>" +
            "</head>" +
            "<body>" +
            "<h1>Hello, World I am from the servlet</h1>" +
            "<hr>" +
            "</body>" +
            "</html"
        );

        out.close();
    }
}
