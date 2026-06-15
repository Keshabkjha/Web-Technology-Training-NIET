import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int a1 = Integer.parseInt(request.getParameter("n1"));
		int a2 = Integer.parseInt(request.getParameter("n2"));
		
		if(request.getParameter("r1")!=null)
		{
			out.println("<h3> Addition= </h3>"+(a1 + a2));
		}
		else if(request.getParameter("r2")!=null)
		{
			out.println("<h3> Subtraction= </h3>"+(a1 - a2));
		}
		else if(request.getParameter("r3")!=null)
		{
			out.println("<h3> Multiplication= </h3>"+(a1 * a2));
		}
		else
		{
			out.println("<h3> Divide= </h3>"+(a1 / a2));
		}
	}

}
