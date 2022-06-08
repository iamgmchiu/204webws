import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProgramaticErrorHandlingServlet extends HttpServlet 
{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{

      res.setContentType("text/html;charset=UTF-8");

	  PrintWriter out = res.getWriter();
	  out.println("<p>I will throw a ServletEexception now....</p>");
	
	  try
	  {
		throw new ServletException("Test for programatic exception handling using ServletResponse.sendError().");
	  }
	  catch(Exception e)
	  {
		log("Exception in ProgramaticExceptionHandlingServlet", e);
	    res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
	  }
		
	}
}

