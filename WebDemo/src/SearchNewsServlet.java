

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchNewsServlet
 */
public class SearchNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
	    PrintWriter out = response.getWriter();
	    
	    
	    if ("companynews".equals(request.getParameter("news_category")))
	    {  

	      out.println("<html>");
	      out.println("<head><title>SearchNewsServlet</title></head>");
	      out.println("<body BGCOLOR=\"#FDF5E6\">");
	      out.println("<h2>Welcome to Company News Site</h2>");
	      out.println("</body></html>");
	      out.close();
	    }
	    else if ("yahoonews".equals(request.getParameter("news_category")))
	    {  

	      //out.flush(); //if you invoke this statement, the next statement will throw a IllegalStateException Object 
	      response.sendRedirect("http://tw.news.yahoo.com"); 
	    
	      //or 
	      //response.setStatus(response.SC_MOVED_TEMPORARILY);
	      //response.setHeader("location", "http://tw.news.yahoo.com");  
	    }
	    else 
	    {
	      //case 1: the file has been permanently removed  
	      response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
	      //case 2: the user is not authorized to access this page
	      //response.sendError(HttpServletResponse.SC_FORBIDDEN,"You are not allowed to access this page");
	    }
	}

}
