import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeclarativeErrorHandlingServlet extends HttpServlet 
{


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
			PrintWriter out = res.getWriter();
			out.println("<p>Just throw the exception and do not catch it....</p>");
	
			throw new ServletException("Test for declarative exception handling.");
		
	}
}

