

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchJobServlet
 */
public class SearchJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static final String CONTENT_TYPE = "text/html; charset=Cp950";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchString;
	    String[] stateList;
	    Enumeration paramList;
	    
	    response.setContentType(CONTENT_TYPE);
	    PrintWriter out = response.getWriter();
	    searchString = request.getParameter("searchingstring");
	    stateList = request.getParameterValues("state");
	    out.println("<html>");
	    out.println("<head><title>SearchJobServlet</title></head>");
	    out.println("<body BGCOLOR=\"#FDF5E6\">");
	    out.println("<p>Techonogy searching for <h1> " + searchString + "</h1></p>");
	    out.println("<p>at States as below</p>");
	    
	    for (int i = 0; i < stateList.length; i++)
	      out.println("<h4>" + stateList[i] + "</h4>");

	    out.println("<hr>");
	    out.println("<p>Search Job Form Parameters</p>");
	    paramList = request.getParameterNames();
	    
	    while (paramList.hasMoreElements())
	      out.println("<h4>" + (String)paramList.nextElement()+ "</h4>");
	      
	    out.println("</body></html>");
	    out.close();
	}

}
