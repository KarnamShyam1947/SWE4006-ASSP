import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
            "<html>" +
            "<head>" +
            "<title>Result</title>" +
            "</head>" +
            "<body>" + 
            "<h1> Data from form </h1>" +
            "<hr>" +
            "<table>" +
            "<tr>" +
            "<th>Parameter name</th>" +
            "<th>Parameter value</th>" +
            "</tr>"
        );

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Entry<String, String[]> entry : parameterMap.entrySet()) {
            String value = (entry.getValue().length) > 1 ? arrayToString(entry.getValue()) : entry.getValue()[0];

            out.print(
                "<tr>" +
                "<td>" + entry.getKey() + "</td>" +
                "<td>" + value + "</td>" +
                "<tr>"
            );
        }

        out.print(
            "</table>" +
            "</body>" +
            "</html>" 
        );
        out.close();
    }

    public String arrayToString(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) 
                sb.append(arr[i] + ".");
            
            else
                sb.append(arr[i] + ", ");
        }

        return sb.toString();
    }
}
