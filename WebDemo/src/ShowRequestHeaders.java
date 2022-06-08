

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowRequestHeaders
 */
public class ShowRequestHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Servlet Example: Showing Request Headers";
	    
	    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			        "Transitional//EN\n" +
	                "<HTML>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
	                "<B>Request Method: </B>" +
	                request.getMethod() + "<BR>\n" +
	                "<B>Request URI: </B>" +
	                request.getRequestURI() + "<BR>\n" +
	                "<B>Request Protocol: </B>" +
	                request.getProtocol() + "<BR><BR>\n" +
	                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
	                "<TR BGCOLOR=\"#FFAD00\">\n" +
	                "<TH>Header Name<TH>Header Value");
	                
	    Enumeration headerNames = request.getHeaderNames();
	    
	    while(headerNames.hasMoreElements()) {
	      String headerName = (String)headerNames.nextElement();
	      out.println("<TR><TD>" + headerName);
	      out.println("    <TD>" + request.getHeader(headerName));
	    }
	    
	    out.println("</TABLE>\n</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
