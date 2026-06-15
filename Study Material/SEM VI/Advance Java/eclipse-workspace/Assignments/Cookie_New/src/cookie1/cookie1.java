package cookie1;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class process1
 */
@WebServlet("/process1")
public class cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookie1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String subject=request.getParameter("subject");
		Cookie cref1=new Cookie("ckuname", uname);
		Cookie cref2=new Cookie("cksubject",subject);
		cref1.setMaxAge(365*24*60*60);
		response.addCookie(cref1);
		cref2.setMaxAge(365*24*60*60);
		response.addCookie(cref1);
		RequestDispatcher rq=request.getRequestDispatcher("process");
		rq.forward(request, response);
	}
}
