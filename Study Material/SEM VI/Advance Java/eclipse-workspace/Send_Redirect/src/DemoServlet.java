import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DemoServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try { 
            response.sendRedirect("https://dotnettutorials.net/course/java-servlets-tutorials/F");
        }
        finally {            
            out.close();
        }
    }
}